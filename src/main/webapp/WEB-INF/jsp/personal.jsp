<%--
  Created by IntelliJ IDEA.
  User: smz
  Date: 2019/4/3
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>个人页面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--引入JS-->
    <script type="text/javascript" src="<%=basePath %>js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="<%=basePath %>js/bootstrap.js"></script>
    <!--引入CSS-->
    <link href="<%=basePath %>css/bootstrap.css" rel="stylesheet">
</head>
<body>
    <svg width="100%" height="100%" version="1.1"
         xmlns="http://www.w3.org/2000/svg">
        <rect width="300" height="100"
              style="fill:red;fill-opacity:0.1;stroke-width:50;stroke:red;stroke-opacity:0.1"/>
    </svg>
</body>
</html>
