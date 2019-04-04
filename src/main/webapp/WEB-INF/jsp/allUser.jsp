<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" isELIgnored="false" %>
<% pageContext.setAttribute("path", request.getContextPath()); %>
<% String appPath = request.getContextPath(); %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>User列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <script type="text/javascript" src="<%=basePath %>js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="<%=basePath %>js/bootstrap.js"></script>
    <script type="text/javascript" src="<%=basePath %>js/bootstrap-datetimepicker.js"></script>
    <script type="text/javascript" src="<%=basePath %>js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
    <script type="text/javascript" src="<%=basePath %>js/common.js"></script>

    <link href="<%=basePath %>css/bootstrap.css" rel="stylesheet">
    <link href="<%=basePath %>css/bootstrap-datetimepicker.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="page-header">
                    <h1>
                        各用户列表
                    </h1>
                </div>
            </div>
        </div>

        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="page-header">
                    <h1>
                        <small>用户列表 —— 显示所有用户</small>
                    </h1>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4 column">
                <a class="btn btn-primary" href="${path}/userInfo/jump?jspName=addUser">新增</a>
                <a class="btn btn-primary" href="${path}/userInfo/toAddUser2">新增</a>
            </div>
        </div>
        <div class="row clearfix">
            <div class="col-md-12 column">
                <table class="table table-hover table-striped">
                    <thead>
                    <tr>
                        <th>用户编号</th>
                        <th>用户名字</th>
                        <th>用户小名</th>
                        <th>用户性别</th>
                        <th>用户生日</th>
                        <th>用户父亲</th>
                        <th>用户母亲</th>
                        <th>用户信息</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="userInfo" items="${requestScope.list}" varStatus="status">
                        <tr>
                            <td>${userInfo.name}</td>
                            <td>${userInfo.oldName}</td>
                            <td>${userInfo.sex}</td>
                            <td>${userInfo.birth}</td>
                            <td>${userInfo.idcard}</td>
                            <td>${userInfo.father[0].name}</td>
                            <td>${userInfo.mother[0].name}</td>
                            <td>${userInfo.text}</td>
                            <td>
                                <a id="addChildren">增加子代</a> |
                                <a href="${path}/userInfo/toUpdateUser?id=${userInfo.id}">更改</a> |
                                <label onclick="del(${userInfo.id})">删除</label>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="modal fade" id="myModal" tabindex="-1" aria-hidden="true" data-backdrop="static">
        <div class="modal-dialog">
            <form class="form-horizontal">
                <div class="modal-content">
                    <input type="hidden" name="id"/>
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                        <h4 class="modal-title">新增子嗣</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="name" class="col-sm-3 control-label">真实名字</label>
                            <div class="col-sm-6 input-group" style="padding-left: 0;">
                                <label>
                                    <input type="text" class="form-control" id="name" name="name"
                                           style="width: 350px;"/>
                                </label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="oldName" class="col-sm-3 control-label">其他名字</label>
                            <div class="col-sm-6 input-group" style="padding-left: 0;">
                                <label>
                                    <input type="text" class="form-control" id="oldName" name="oldName"
                                           style="width: 350px;"/>
                                </label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="idcard" class="col-sm-3 control-label">身份证号码</label>
                            <div class="col-sm-6 input-group" style="padding-left: 0;">
                                <label>
                                    <input type="text" class="form-control" id="idcard" name="idcard"
                                           style="width: 350px;"/>
                                </label>
                                <div id="idCardAlert" class="alert alert-danger fade in ">
                                    <strong>您输入的身份证号码不正确，请重新输入。</strong>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="sex" class="col-sm-3 control-label">性别</label>
                            <div class="col-sm-6 input-group" style="padding-left: 0;">
                                <select class="form-control" id="sex" name="sex">
                                    <option value="0" >女</option>
                                    <option value="1" >男</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="birth" class="col-sm-3 control-label">生日</label>
                            <div class="col-sm-6 input-group date birth" id="datetimepicker" data-date="" data-date-format="dd MM yyyy" data-link-field="birth" data-link-format="yyyy-mm-dd" style="padding-left: 0;">
                                <input class="form-control" size="16" id="birthShow" type="text" value="" readonly>
                                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                            </div>
                            <input type="hidden" id="birth" name="birth" value="" />
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="submit" class="btn btn-primary" id="saveChildren">保存</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</body>
<script>
    function del(id) {
        var r=confirm("确认删除吗？");
        if(r==true){
            $.ajax({
                //几个参数需要注意一下
                type: "POST",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                url: "<%=appPath%>/userInfo/del/"+id,//url
                data:{},
                success: function (result) {
                    console.log(result);//打印服务端返回的数据(调试用)
                    if (result.flag == "SUCCESS") {
                        alert("新用户创建成功！");
                        window.location.href="${path}/userInfo/allUser";
                    }else{
                        alert("新用户创建失败！； ");
                    }
                },
                error : function() {
                    alert("异常！");
                }
            });
        }else if(r==false){

        }
    }
</script>
<script type="text/javascript">
    $(function(){
        $("#idcard").blur(function () {
            var idcard=$(this).val();
            if (isIdCardNo(idcard)===false) {//检查号码是否符合规范
                console.log("检查号码是否符合规范");
                $("#idCardAlert").show();
                return false;
            }else if (checkIdCardProvince(idcard) === false) {//检查省份
                console.log("检查省份是否符合规范");
                $("#idCardAlert").show();
                return false;
            }else if (checkIdCardBirthday(idcard) === false) {//校验生日
                console.log("校验生日是否符合规范");
                $("#idCardAlert").show();
                return false;
            }else if (checkIdCardParity(idcard) === false) {//检验位的检测
                console.log("检验位的检测是否符合规范");
                $("#idCardAlert").show();
                return false;
            }else{
                $("#idCardAlert").hide();//隐藏身份证的提示框
                $("#sex").val(getSexByIdCard(idcard));//自动生成性别
                $("#birth").val(getBirthByIdCard(idcard));//自动生成生日
                $("#birthShow").val(getBirthByIdCard(idcard));//自动生成生日（展示框）
                $('#datetimepicker').datetimepicker('update');//自动更新日期时间选择器
                return true;
            }
        });
        $('.birth').datetimepicker({
            language:  'zh-CN',
            format: 'yyyy-mm-dd',
            weekStart: 1,
            todayBtn:  1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            minView: 2,
            forceParse: 0
        });

        $('#addChildren').click(function () {
            $('#myModal').modal('show');
        });

        $('#saveChildren').click(function () {
            $(this).html('保存中……');
            //var data = $('#myModal').formGet();
            $.ajax({
                type: "POST",
                url: "/channel/save",
                contentType: "application/json",
                data: $('#myModal').serialize(),
                success: function (result) {
                    console.log(result);
                    if (!result.code) {
                        location.href = '/'
                    }else{
                        alert(result.msg);
                    }
                    $(this).html('保存');
                },
                error: function (result) {
                    alert("出错了，请稍后重试");
                    $(this).html('保存');
                }
            });
        });
    });

    function checkChildrenSubmit() {
    }
</script>
<style>
    .alert {
        margin-bottom: 0;
        display: none;
    }
</style>