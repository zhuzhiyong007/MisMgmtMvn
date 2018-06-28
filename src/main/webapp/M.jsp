<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>M jsp</title>
</head>
<body>

<form id="addform" class="form-horizontal" method="post" action="请求接口地址" enctype="multipart/form-data" target="rfFrame">
              <div class="box-body">
                 <div class="form-group">
                  <label for="customName" class="col-sm-2 control-label">广告包名称</label>

                  <div class="col-sm-6">
                    <input type="text" class="form-control" name="customName" id="customName" placeholder="广告包名称">
                  </div>
                </div>
                <div class="form-group">
                  <label for="limited" class="col-sm-2 control-label">日限量</label>

                  <div class="col-sm-6">
                    <input type="text" class="form-control" name="limited" id="limited" placeholder="每日下载次数">
                  </div>
                </div>
                  <div class="form-group">
                  <label for="file" class="col-sm-2 control-label">URL地址</label>

                  <div class="col-sm-6">
                        <input type="file"  name="file" id="file">
                  </div>
                </div>              
              <!-- /.box-body -->
            <div class="form-group">
             <label for="submit" class="col-sm-2 control-label"></label>
                <div class="col-sm-2">
                    <button type="button" id="submit" class="btn btn-primary">提交</button>
                </div>
              </div>
              <!-- /.box-footer -->
            </form>

<iframe id="rfFrame" name="rfFrame" src="about:blank" style="display:none;"></iframe>  



$("#submit").click(function(){
        var options  = {    
            url:请求接口地址,   //同action 
            type:'post',
            beforeSend:function(xhr){//请求之前
                  var index = layer.load(1, {
                      shade: [0.5,'#000'] //0.5透明度的黑色背景
                    });
              },    
            success:function(data)    
            {   
　　　　　　
            },

　　 complete:function(xhr){//请求完成
                       layer.closeAll('loading');
                      //询问框
                        layer.confirm('广告主修改成功！页面将跳转到列表页。', {
                          btn: ['确定'] //按钮
                        }, function(){
                          location.href = "adList.html";//location.href实现客户端页面的跳转 
                        });
                       
                   },
             error: function(xhr,status,msg){
                     //alert("状态码"+status+"; "+msg)
                     layer.msg('玩命加载中..');

                  }    
                };    
           $("#addform").ajaxSubmit(options);
        });  
        
        
        <script type="text/javascript">
        function login() {
            $.ajax({
            //几个参数需要注意一下
                type: "POST",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                url: "/users/login" ,//url
                data: $('#form1').serialize(),
                success: function (result) {
                    console.log(result);//打印服务端返回的数据(调试用)
                    if (result.resultCode == 200) {
                        alert("SUCCESS");
                    }
                    ;
                },
                error : function() {
                    alert("异常！");
                }
            });
        }
    </script>
          

</body>
</html>