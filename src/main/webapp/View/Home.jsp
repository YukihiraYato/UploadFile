<%--
  Created by IntelliJ IDEA.
  User: Yukihira Souma
  Date: 30/08/2023
  Time: 2:34 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload Single File</title>
</head>
<body>
<form method="POST" enctype="multipart/form-data" action="HomeController">
    File to upload: <input type="file" name="upfile"><br/>
    Notes about the file: <input type="text" name="note"><br/>
    <br/>
    <input type="submit" value="Press"> to upload the file!
</form>
</body>
</html>
