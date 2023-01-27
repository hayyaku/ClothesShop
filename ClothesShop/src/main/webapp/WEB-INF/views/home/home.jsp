<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Clothes Shop</title>
</head>
<body>
    <!----------------- 
        start main 
    ------------------>
    <main>
  <h1 hidden>Clothes Shop</h1>
  <section class="intro container">
      <div class="controlLeft">
        <i class="fa-solid fa-chevron-left"></i>
      </div>
      <div class="gallery-inner">
        <img src='<c:url value="/resources/images/slider-1.jpg"></c:url>' alt="" />
      </div>
      <div class="controlRight">
        <i class="fa-solid fa-chevron-right"></i>
      </div>
  </section>
  <section class="product mt-4">
    <div class="container">
      <div class="top-title">
        <h2>Sản phẩm</h2>
      </div>
      <div class="row mt-5 body-list-item">
      
					<!-- *******
					    list item 
					     ******* -->

      </div>
    </div>
  </section>
</main>
<script src='<c:url value= "/resources/js/home.js"/>'></script>
</body>
</html>