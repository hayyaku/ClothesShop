<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="dec" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><dec:title default="Trang chủ" /></title>
<link rel="stylesheet" href='<c:url value="/resources/fontawesome-6.2.1/css/all.min.css"></c:url>' />
<link rel="stylesheet" href='<c:url value="/resources/bootstrap-4.3.1/css/bootstrap.min.css"></c:url>' />

<script src='<c:url value= "/resources/js/jquery-3.6.3.min.js"/>'></script>
<script
      src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
      integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
      crossorigin="anonymous"></script>

<link rel="stylesheet" href="<c:url value='/resources/css/common.css'></c:url>" />
<link rel="stylesheet" href="<c:url value='/resources/css/login.css'></c:url>" />
<link rel="stylesheet" href="<c:url value='/resources/css/home.css'></c:url>" />
<link rel="stylesheet" href="<c:url value='/resources/css/product.css'></c:url>" />
<link rel="stylesheet" href="<c:url value='/resources/css/product-detail.css'></c:url>" />
<link rel="stylesheet" href="<c:url value='/resources/css/nav-footer.css'></c:url>" />
</head>
<body>

<%@ include file= "/WEB-INF/views/master-layout/home/nav.jsp" %>

<dec:body></dec:body>

<%@ include file= "/WEB-INF/views/master-layout/home/footer.jsp" %>


</body>
</html>