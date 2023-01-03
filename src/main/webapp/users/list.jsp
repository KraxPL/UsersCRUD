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

        <!-- Begin Page Content -->
        <div class="container-fluid">
          <!-- Page Heading -->
          <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800">UsersCRUD</h1>
            <a href="/user/add" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-download fa-sm text-white-50"></i> Add new user</a>
          </div>

          <table class="table" style="width: 100%">
            <tr>
              <th>ID</th>
              <th>Username</th>
              <th>Email</th>
              <th>Action</th>
            </tr>
          <c:forEach items="${users}" var="personList">
            <tr>
              <td>${personList.id}</td>
              <td>${personList.username}</td>
              <td>${personList.email}</td>
              <td><a href="${pageContext.request.contextPath}/user/delete?id=${personList.id}">Delete</a>
                <a href="${pageContext.request.contextPath}/user/edit?id=${personList.id}">Edit</a>
                <a href="${pageContext.request.contextPath}/user/show?id=${personList.id}">Show</a></td>
            </tr>
            </c:forEach>



          <%@ include file="/footer.jsp" %>

</body>

</html>
