<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<header id="header">
      <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container">
          <div class="logo">
            <a class="navbar-brand" href='<c:url value = "/home"></c:url>'>
              <span style="color: rgb(231, 131, 148)">Clothes</span>
              <samp style="color: rgb(240, 89, 34)">Shop</samp>
            </a>
          </div>

          
          <button
            class="navbar-toggler"
            type="button"
            data-toggle="collapse"
            data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
              <li class="nav-item">
                <a class="nav-link" href='<c:url value="/home"></c:url>'>Trang chủ</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href='<c:url value="/products"></c:url>'>Tất cả sản phẩm</a>
              </li>
             
            </ul>
            <form class="form-inline my-2 my-lg-0">
              <input
                class="form-control mr-sm-2"
                type="search"
                placeholder="Tìm kiếm sản phẩm"
                aria-label="Search"
              />
              <button
                class="btn btn-outline-success my-2 my-sm-0"
                type="submit"
              >
                <i class="fa fa-search"></i>
              </button>
            </form>

            <ul class="navbar-nav ml-auto nav-right">
              <li class="nav-item mr-3">
                <a class="nav-link" href="#">
                  <i class="fa fa-shopping-cart"></i>
                  <span class="count-item">10</span>
                  <span>Giỏ hàng</span>
                </a>
              </li>
              <li class="nav-item">
              <c:if test="${empty loginInfor}">
                <div class="nav-link">
                  <i class="fa fa-user-alt"></i>
                  <a href="<c:url value="/register"></c:url>">Đăng ký</a>
                  /
                  <a href="<c:url value="/login"></c:url>">Đăng nhập</a>
                </div>
              </c:if>
			  <c:if test="${not empty loginInfor}">
			  	<c:if test="${loginInfor.role.equals('admin')}">
				  	<div class="nav-link">
	                  <i class="fa fa-user-alt"></i>
	                  <a href="<c:url value="/admin/home"></c:url>">${loginInfor.userName}</a>
	                  /
	                  <a href="<c:url value="/logout"></c:url>">Đăng xuất</a>
	                </div>
			  	</c:if>
			  	<c:if test="${!loginInfor.role.equals('admin')}">
				  	<div class="nav-link">
	                  <i class="fa fa-user-alt"></i>
	                  <a href="<c:url value="/home"></c:url>">${loginInfor.userName}</a>
	                  /
	                  <a href="<c:url value="/logout"></c:url>">Đăng xuất</a>
	                </div>
			  	</c:if>

			  </c:if>
              </li>
            </ul>

          </div>
        </div>
      </nav>
</header>
    