<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADMIN Create Product</title>
</head>
<body>
 	        
  <div class="container">
          <label class="my-1 mr-2" for="list-categories">Catagory</label>
          <select class="custom-select my-1 mr-sm-2 list-categories"id="list-categories">
            <option selected>Choose...</option>
            <option value="1">Nam</option>
            <option value="2">Nữ</option>
            <option value="3">Trẻ em</option>
          </select>
          <div class="form-group">
            <label for="name-product">Tên sản phẩm</label>
            <input type="text"class="form-control"id="name-product"placeholder="Tên sản phẩm"/>
          </div>
          <div class="form-group">
            <label for="old-price">Giá trước khi giảm</label>
            <input type="number"class="form-control"id="old-price"placeholder="Giá trước khi giảm" value="0"/>
          </div>
          <div class="form-group">
            <label for="new-price">Giá sau khi giảm</label>
            <input type="number"class="form-control"id="new-price"placeholder="Giá sau khi giảm"value="0"/>
          </div>
          <div class="form-group">
            <label for="description">Mô tả</label>
            <textarea name="" id="description"class="form-control" cols="30" rows="6"></textarea>
          </div>
          <button class="btn btn-primary btn-submit-product mt-3 mb-5"onclick="updateProduct()">Update</button>
          <h4>Hình ảnh sản phẩm:</h4>
          <div class="product-image-body">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>Id</th>
                  <th id="td-img">Hình ảnh</th>
                  <th><button class="btn btn-success mt-3"onclick="insertImage()">Thêm</button></th>
                </tr>
              </thead>
              <tbody  class="show-item">
                <tr>
                  <td>1</td>
                  <td  class="item-image">
                    <img src="./image/Nu-01-06.jpg" alt="">
                  </td>
                  <td>
                    <button id="btn-edit" class="btn btn-warning mr-2">Thay ảnh</button>
                    <button id="btn-delete" class="btn btn-danger">Xóa</button>
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
          <h4>Chi tiết sản phẩm:</h4>
          <div class="product-detail">
            <div class="product-detail-body">
              <table class="table">
                <thead>
                  <tr>
                    <th>Id</th>
                    <th>Màu sản phẩm</th>
                    <th>Size sản phẩm</th>
                    <th>Số lượng</th>
                    <th>
                      <button class="btn btn-success mt-3"onclick="insertDetail()">Thêm</button>
                    </th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td></td>
                    <td>
                      <select class="my-1 mr-sm-2 list-color form-control">
                        <option value="1">Đỏ</option>
                        <option value="2">Vàng</option>
                        <option value="3">Xanh</option>
                      </select>
                    </td>
                    <td>
                      <select class="my-1 mr-sm-2 list-size form-control">
                        <option value="1">S</option>
                        <option value="2">M</option>
                        <option value="3">L</option>
                      </select>
                    </td>
                    <td>
                      <input class="form-control qty"type="number"value="0"/>
                    </td>
                    <td>
                      <button class="btn btn-warning btn1"onclick="updateDetail()">Sửa</button>
                      <button class="btn btn-danger btn1"onclick="deleteDetail()">Xóa</button>
                    </td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
          
        </div>

        <div class="edit-product-body">
          
        </div>

   <script src='<c:url value= "/resources/js/admin-update-product.js"/>'></script>
   
</body>
</html>