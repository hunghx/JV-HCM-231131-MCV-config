<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 5/31/2024
  Time: 2:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>List : ${name}</h1>
<form method="post" action="/product/add">
    <input type="text" name="id" id="1">
    <input type="text" name="name" id="2">
    <button type="submit">ADĐ</button>
</form>

<form action="/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="file">
    <button type="submit">ADĐ</button>
</form>

</body>
</html>
