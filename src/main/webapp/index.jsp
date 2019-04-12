<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <script src="./js/jquery-3.3.1.js"></script>
    <script src="./js/bootstrap.js"></script>
    <script src="./js/MD5.js"></script>
    <link rel="stylesheet" href="./css/bootstrap.css">
    <link rel="stylesheet" href="./css/icon.css">
    <style>
        .login {
            color: white;
            height: 38px;
            width: 300px;
            background-color: #2b669a;
        }
    </style>
    <script>
        function login() {
            if(""==$.trim($("#loginName").val())){
                $("#alert-loginName").attr("class","alert alert-danger fade in");
                return
            }else if(""==$.trim($("#loginPassword").val())){
                $("#alert-loginPassword").attr("class","alert alert-info fade in");
                return
            }
            var user={};
            var passwd = hex_md5($("#loginPassword").val());
            user['loginName']=$("#loginName").val();
            user['loginPassword']=passwd;
            $.ajax({
                //几个参数需要注意一下
                type: "POST",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                url: "user/login",
                data:user,
                success: function (result) {
                    console.log(result);//打印服务端返回的数据(调试用)
                    if(result.code=="1"){
                        $("#alert-msg").children("strong").html(result.data.msg);
                        $("#alert-msg").attr("class","col-sm-offset-2 col-sm-10 alert alert-danger fade in");
                    }else if(result.code="0"){
                        window.location.href="userInfo/login";
                    }
                },
                error : function() {
                    alert("登录异常，请联系管理员！");
                }
            });
        }
    </script>
</head>
<body>
<div class="container">
    <h2 class="text-center">请登录</h2>
    <div class="row">
        <form class="form-horizontal col-md-offset-4 col-md-4" id="loginForm">
            <div class="form-group">
                <label for="loginName" class="col-sm-2 control-label">账号</label>
                <div class="col-sm-10">
                    <div class="input-group">
                        <input type="text" class="form-control" id="loginName" placeholder="请输入账号">
                        <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                    </div>
                </div>
            </div>
            <div id="alert-loginName" class="hide">
                <strong>账号不能为空</strong>
            </div>
            <div class="form-group">
                <label for="loginPassword" class="col-sm-2 control-label">密码</label>
                <div class="col-sm-10">
                    <div class="input-group">
                        <input type="password" class="form-control" id="loginPassword" placeholder="请输入密码">
                        <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                    </div>
                </div>
            </div>
            <div id="alert-loginPassword" class="hide">
                <a href="#" class="close" data-dismiss="alert">&times;</a>
                <strong>密码不能为空</strong>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="button" class="btn btn-default login" onclick="login()">登录</button>
                </div>
            </div>
            <div id="alert-msg" class="hide">
                <strong></strong>
            </div>
        </form>
    </div>
</div>
<script type="text/javascript">
    $(function(){
        $("#loginName,#loginPassword").blur(function(){
            $("#alert-msg").children("strong").html();
            $("#alert-msg").attr("class","hide");
            if($("#loginName").val()!=""){
                $("#alert-loginName").attr("class","hide");
            }
            if($("#loginPassword").val()!=""){
                $("#alert-loginPassword").attr("class","hide");
            }
        });
        $("#loginPassword").keydown(function(event){
            var e = event || window.event ||arguments.callee.caller.arguments[0];
            if(e && e.keyCode==13){
                login();
            }
        });
    });
</script>
</body>
</html>
