<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>SB Admin 2 - Dashboard</title>

  <!-- Custom fonts for this template-->
  <link href="../theme/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="../theme/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

<%@ include file="/header.jsp" %>

<form method="post" name="Edit User">

  User Name<br>
  <input type="text" name="userName" value="${username}"><br>
  E-mail<br>
  <input type="email" name="email" value="${email}"><br>
  Password<br>
  <input type="password" name="password" placeholder="input new password"><br>
  <input type="submit" name="Submit"><br>

</form>

<%@ include file="/footer.jsp" %>

</body>

</html>
