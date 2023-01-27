<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product</title>
</head>
<body>
    <!----------------- 
        start main 
    ------------------>
    <main>
      <section class="product">
           <div class="container">
          <div class="row">
            <div class="col-lg-3 order-2 order-lg-1">
              <!-- Categories -->
              <div class="filter-widget">
                <h4
                  class="fw-title category-action"
                  id="menu_item_0"
                  onclick="clickCategor(0)"
                >
                  Xem tất cả sản phẩm
                </h4>
                <div class="nav-menu-category"></div>
              </div>

            </div>
            <div class="col-lg-9 order-1 order-lg-2">
              <div class="list-product-filter row"></div>
              <div class="mt-3">
                <ul class="pagination"></ul>
              </div>
            </div>
          </div>
        </div>
      </section>
              
</main>

<script src='<c:url value= "/resources/js/product.js"/>'></script>
      
    
</body>
</html>