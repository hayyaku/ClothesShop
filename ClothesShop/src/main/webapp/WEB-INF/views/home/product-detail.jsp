<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product detail</title>
</head>
<body>
    <!----------------- 
        start main 
    ------------------>
    <main>
      <section class="product-detail">
        <div class="container">
          <div class="row">
            <div class="col-lg-6 col-md-6 pr-4 render-image">
              <div class="show-item">
                <img src='<c:url value="/resources/images/ao-thun-nu-1.jpg"></c:url>' alt="" />
              </div>
              <div class="list-item d-flex">
                <img src='<c:url value="/resources/images/ao-thun-nu-1.jpg"></c:url>' alt="" />
                <img src='<c:url value="/resources/images/ao-thun-nu-2.jpg"></c:url>' alt="" />
                <img src='<c:url value="/resources/images/ao-thun-nu-3.jpg"></c:url>' alt="" />
              </div>
            </div>
            <div class="col-lg-6 col-md-6">
              <h2 class="name-item">name</h2>
              <div class="price">
                
              </div>
              <div class="color-item">
                <p>Màu sắc:</p>
                <ul class="d-flex">
                  
                </ul>
              </div>
              <div class="size-item">
                <p>Kích thước:</p>
                <ul class="d-flex">
                  
                </ul>
              </div>
              <p>Số lượng:</p>
              <div class="qty d-flex">
                <div class="qty-item d-flex mr-4">
                  <span class="dec">-</span>
                  <input type="number" value="0" id="qty-product" />
                  <span class="inc">+</span>
                </div>
                <div class="add-product"><span>Thêm vào giỏ hàng</span></div>
              </div>
              <div class="description">
                <h6>Thông tin sản phẩm:</h6>
                <p></p>
              </div>
            </div>
          </div>
        </div>
      </section>
</main>

<script src='<c:url value= "/resources/js/product-detail.js"/>'></script>
      
    
</body>
</html>