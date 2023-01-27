<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="dec" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><dec:title default="ADMIN" /></title>
<link rel="stylesheet" href='<c:url value="/resources/fontawesome-6.2.1/css/all.min.css"></c:url>' />
<link rel="stylesheet" href='<c:url value="/resources/bootstrap-4.3.1/css/bootstrap.min.css"></c:url>' />

<script src='<c:url value= "/resources/js/jquery-3.6.3.min.js"/>'></script>
<script
      src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
      integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
      crossorigin="anonymous"></script>

<link rel="stylesheet" href="<c:url value='/resources/css/sb-admin.css'></c:url>" />
<link rel="stylesheet" href="<c:url value='/resources/css/admin.css'></c:url>" />
<link rel="stylesheet" href="<c:url value='/resources/css/admin-update.css'></c:url>" />

</head>
<body id="page-top">
    <nav class="navbar navbar-expand navbar-dark bg-dark static-top d-flex justify-content-between">

        <a class="navbar-brand mr-1" href="">ADMIN</a>
        <a class="navbar-brand ml-4" style="font-size: 16px;" href="<c:url value="/home/thoat"></c:url>">Thoát</a>

      </nav>
      <div id="wrapper">
    
        <!-- Sidebar -->
        <ul class="sidebar navbar-nav">
          <li class="nav-item active">
            <a class="nav-link" href="<c:url value="/admin/home"></c:url>">
              <i class="fas fa-fw fa-tachometer-alt"></i>
              <span>Sản Phẩm</span>
            </a>
          </li>

        </ul>
    
        <div id="content-wrapper">
    
          <dec:body></dec:body>
    
        </div>
          <!-- /.container-fluid -->
</body>
</html>