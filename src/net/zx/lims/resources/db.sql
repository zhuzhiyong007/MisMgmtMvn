
--公司表
create table OGORGMSK(
  org_no      number(8) NOT NULL,
  ORG_ID      number(8),
  org_nam     VARCHAR2(20),
  porg_no     number(8)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table OGORGMSK
  add constraint PK_OGORGMSK primary key (org_no)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
  
  
  --树查询
  with tree(org_no,org_id,org_nam,porg_no,rank) as
(
   select f.org_no,f.org_id,f.org_nam,f.porg_no,0 as rank from OGORGMSK f where porg_no=0
   union all
   select o.org_no,o.org_id,o.org_nam,o.porg_no,t.rank+1 from OGORGMSK o join tree t on o.porg_no=t.org_no
)
select * from tree


  --部门表
  create table DPDEPMSK
(
  DEP_NO      NUMBER(8) not null,
  DEP_ID      NUMBER(8),
  Dep_NAM     varchar2(50),--部门名称
  PDEP_NO     varchar2(50)--上级部门
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table DPDEPMSK
  add constraint PK_DPDEPMSK primary key (DEP_NO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );