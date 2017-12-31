/*--树形数据处理方案   
    
  树形数据的排序,新增,修改,复制,删除,数据完整性检查,汇总统计   
  --邹建   2003.9--*/   
    
  /*--数据测试环境   
  表名tb,如果修改表名,则相应修改所有数据处理中涉及到的表名tb   
  id为编号(标识字段+主键)   
  pid为上级编号   
  name为名称,后面可以自行增加其他字段.   
    
  凡是未特殊标注的地方,对自行增加的字段不影响处理结果   
  --*/   
    
  create   table   tb(id   int   identity(1,1)   not   null   constraint   PK_tb   primary   key   clustered   
  ,pid   int,name   varchar(20))   
  insert   into   tb   
  select   0,'中国'   
  union   all   select   0,'美国'   
  union   all   select   0,'加拿大'   
  union   all   select   1,'北京'   
  union   all   select   1,'上海'   
  union   all   select   1,'江苏'   
  union   all   select   6,'苏州'   
  union   all   select   7,'常熟'   
  union   all   select   6,'南京'   
  union   all   select   6,'无锡'   
  union   all   select   2,'纽约'   
  union   all   select   2,'旧金山'   
  go   


/*--数据处理--*/   
    
  /*--   一个重要的函数,很多处理的地方都会用到   --*/   
  --自定义函数--获取编码累计   
  create   function   f_getmergid(@id   int)   
  returns   varchar(8000)   
  as   
  begin   
  declare   @re   varchar(8000),@pid   int   
    
  --为了数字排序正常,需要统一编码宽度   
  declare   @idlen   int,@idheader   varchar(20)   
  select   @idlen=max(len(id))   
  ,@idheader=space(@idlen)   
  from   tb   
    
  --得到编码累计   
  set   @re=right(@idheader+cast(@id   as   varchar),@idlen)   
  select   @pid=pid   from   tb   where   id=@id   
  while   @@rowcount>0   
  select   @re=right(@idheader+cast(@pid   as   varchar),@idlen)+','+@re   
  ,@pid=pid   from   tb   where   id=@pid   
  return(@re)   
  end   
  go   


/*--数据显示排序--*/   
  --分级显示--横向,先一级,后二级...   
  select   *   from   tb   order   by   pid   
    
  --分级显示--纵向   
  select   *   from   tb   order   by   dbo.f_getmergid(id)   
  go   
    
  /*--数据统计--*/   
  --分级统计,每个地区下的明细地区数   
  select   *,   
  明细地区数=(select   count(*)   from   tb   where   dbo.f_getmergid(id)   like   dbo.f_getmergid(a.id)+',%')   
  from   tb   a   order   by   dbo.f_getmergid(id)   
    
  go   
  /*--数据新增,修改   
    
  数据新增,修改(包括修改所属的类别)没有什么技巧   
  ,只需要检查所属的上级是否存在就行了.这个可以简单的用下面的语句来解决:   
  if   exists(select   1   from   tb   where   id=@id)   print   '存在'   else   print   '不存在'   
  --*/   
    
  /*--数据删除--*/   
  create   proc   p_delete   
  @id   int, --要删除的id   
  @deletechild   bit=0 --是否删除子   1.删除子,0.如果@id有子,则删除失败.   
  as   
  if   @deletechild=1   
  delete   from   tb   where   dbo.f_getmergid(id)   like   dbo.f_getmergid(@id)+'%'   
  else   
  if   exists(select   1   from   tb   where   pid=@id)   
  goto   lbErr   
  else   
  delete   from   tb   where   id=@id   
    
  return lbErr:   
  RAISERROR   ('该结点下有子结点,不能删除',   16,   1)   
  go   
    
  --调用示例   
  --删除'美国'的数据   
  --exec   p_delete   2 --不包含子,因为有美国下有子,所以删除会出错   
  exec   p_delete   2,1 --包含子,将删除美国及所有数据   
  go   



 /*--数据完整性检查--*/   
  --自定义函数--检测某个编码出发,是否被循环引用   
  create   function   f_chkid(@id   int)   
  returns   bit --循环,返回1,否则返回0   
  as   
  begin   
  declare   @re   bit,@pid   int   
    
  set   @re=0   
    
  --检测   
  select   @pid=pid   from   tb   where   id=@id   
  while   @@rowcount>0   
  begin   
  if   @pid=@id   
  begin   
  set   @re=1   
  goto   lbErr   
  end   
  select   @pid=pid   from   tb   where   id=@pid   
  end   
    
  lbErr:   
  return(@re)   
  end   
  go   
    
  --显示表中的那些数据不符合规范   
  select   *   from   tb   a     
  where   not   exists(select   1   from   tb   where   id=a.pid)   
  or   dbo.f_chkid(id)=1   
  go   
    
  /*--数据复制   
    
  如果表中包含自定义字段,需要修改存储过程   
  存在嵌套不超过32层的问题.   
  --*/   
    
  --创建复制的存储过程--复制指定结点下的子结点到另一个结点下   
  create   proc   p_copy   
  @s_id   int, --复制该项下的所有子项   
  @d_id   int, --复制到此项下   
  @new_id   int --新增加项的开始编号   
  as   
  declare   @nid   int,@oid   int,@name   varchar(20)   
  select   id,name   into   #temp   from   tb   where   pid=@s_id   and   id<@new_id   
  while   exists(select   1   from   #temp)   
  begin   
  select   @oid=id,@name=name   from   #temp   
  insert   into   tb   values(@d_id,@name)   
  set   @nid=@@identity   
  exec   p_copy   @oid,@nid,@new_id   
  delete   from   #temp   where   id=@oid   
  end   
  go   
    
  --创建批量复制的存储过程--复制指定结点及其下面的所有子结点,并生成新结点   
  create   proc   p_copystr   
  @s_id   varchar(8000) --要复制项的列表,用逗号分隔   
  as   
  declare   @nid   int,@oid   int,@name   varchar(20)   
  set   @s_id=','+@s_id+','   
  select   id,name   into   #temp   from   tb   
  where   charindex(','+cast(id   as   varchar)+',',   @s_id)>0   
  while   exists(select   1   from   #temp)   
  begin   
  select   @oid=id,@name=name   from   #temp   
  insert   into   tb   values(@oid,@name)   
  set   @nid=@@identity   
  exec   p_copy   @oid,@nid,@nid   
  delete   from   #temp   where   id=@oid   
  end   
  go   
    
  --测试   
  exec   p_copystr   '5,6'   
    
  --显示处理结果   
  select   *   from   tb   order   by   dbo.f_getmergid(id)   
    
  go   
    
  --删除数据测试环境   
  drop   table   tb   
  drop   function   f_getmergid,f_chkid   
  drop   proc   p_delete,p_copystr,p_copy


/*--数据完整性检查--*/   
  --自定义函数--检测某个编码出发,是否被循环引用   
  create   function   f_chkid(@id   int)   
  returns   bit --循环,返回1,否则返回0   
  as   
  begin   
  declare   @re   bit,@pid   int   
    
  set   @re=0   
    
  --检测   
  select   @pid=pid   from   tb   where   id=@id   
  while   @@rowcount>0   
  begin   
  if   @pid=@id   
  begin   
  set   @re=1   
  goto   lbErr   
  end   
  select   @pid=pid   from   tb   where   id=@pid   
  end   
    
  lbErr:   
  return(@re)   
  end   
  go   
    
  --显示表中的那些数据不符合规范   
  select   *   from   tb   a     
  where   not   exists(select   1   from   tb   where   id=a.pid)   
  or   dbo.f_chkid(id)=1   
  go   
    
  /*--数据复制   
    
  如果表中包含自定义字段,需要修改存储过程   
  存在嵌套不超过32层的问题.   
  --*/   
    
  --创建复制的存储过程--复制指定结点下的子结点到另一个结点下   
  create   proc   p_copy   
  @s_id   int, --复制该项下的所有子项   
  @d_id   int, --复制到此项下   
  @new_id   int --新增加项的开始编号   
  as   
  declare   @nid   int,@oid   int,@name   varchar(20)   
  select   id,name   into   #temp   from   tb   where   pid=@s_id   and   id<@new_id   
  while   exists(select   1   from   #temp)   
  begin   
  select   @oid=id,@name=name   from   #temp   
  insert   into   tb   values(@d_id,@name)   
  set   @nid=@@identity   
  exec   p_copy   @oid,@nid,@new_id   
  delete   from   #temp   where   id=@oid   
  end   
  go   
    
  --创建批量复制的存储过程--复制指定结点及其下面的所有子结点,并生成新结点   
  create   proc   p_copystr   
  @s_id   varchar(8000) --要复制项的列表,用逗号分隔   
  as   
  declare   @nid   int,@oid   int,@name   varchar(20)   
  set   @s_id=','+@s_id+','   
  select   id,name   into   #temp   from   tb   
  where   charindex(','+cast(id   as   varchar)+',',   @s_id)>0   
  while   exists(select   1   from   #temp)   
  begin   
  select   @oid=id,@name=name   from   #temp   
  insert   into   tb   values(@oid,@name)   
  set   @nid=@@identity   
  exec   p_copy   @oid,@nid,@nid   
  delete   from   #temp   where   id=@oid   
  end   
  go   
    
  --测试   
  exec   p_copystr   '5,6'   
    
  --显示处理结果   
  select   *   from   tb   order   by   dbo.f_getmergid(id)   
    
  go   
    
  --删除数据测试环境   
  drop   table   tb   
  drop   function   f_getmergid,f_chkid   
  drop   proc   p_delete,p_copystr,p_copy


增加几个函数:   

  /*--   得到级别   --*/   
  create   function   f_getidlevel(@id   int)   
  returns   int   
  as   
  begin   
  declare   @re   int,@pid   int   
  set   @re=1   
    
  --得到级别(深度)   
  select   @pid=pid   from   tb   where   id=@id   
  while   @@rowcount>0   
  select   @re=@re+1   
  ,@pid=pid   from   tb   where   id=@pid   
  return(@re)   
  end   
  go   
    
  --调用   
  select   *,dbo.f_getidlevel(id)   from   tb



/*--   得到指定id的子id列表   --*/   
  --不包含排序字段的情况   
  create   function   f_getchildid(@id   int)   
  returns   @re   table(id   int)   
  as   
  begin   
  insert   into   @re   select   id   from   tb   where   pid=@id   
  while   @@rowcount>0   
  insert   into   @re select   a.id     
  from   tb   a   inner   join   @re   b   on   a.pid=b.id   
  where   a.id   not   in(select   id   from   @re)   
  return   
  end   
  go   
    
  --包含排序字段的情况   
  create   function   f_getchildidsort(@id   int)   
  returns   @re   table(id   int,sortid   varchar(8000))   
  as   
  begin   
  --为了数字排序正常,需要统一编码宽度   
  declare   @idlen   int,@idheader   varchar(20)   
  select   @idlen=max(len(id))   
  ,@idheader=space(@idlen)   
  from   tb   
    
  insert   into   @re   select   id,right(@idheader+cast(id   as   varchar),@idlen)   
  from   tb   where   pid=@id   
  while   @@rowcount>0   
  insert   into   @re select   a.id,right(@idheader+cast(a.id   as   varchar),@idlen)+','+b.sortid     
  from   tb   a   inner   join   @re   b   on   a.pid=b.id   
  where   a.id   not   in(select   id   from   @re)   
  return   
  end   
  go   
    
  --调用示例,显示1的所有子.   
  select   a.*   from   tb   a   inner   join   dbo.f_getchildidsort(1)   b   on   a.id=b.id   order   by   b.sortid   

/*--   得到指定id的父id列表   --*/   
  --不包含排序字段的情况   
  create   function   f_getparentid(@id   int)   
  returns   @re   table(id   int)   
  as   
  begin   
  declare   @pid   int   
  select   @pid=pid   from   tb   where   id=@id   
  while   @pid<>0   
  begin   
  insert   into   @re   values(@pid)   
  select   @pid=pid   from   tb   where   id=@pid   
  end   
  return   
  end   
  go   