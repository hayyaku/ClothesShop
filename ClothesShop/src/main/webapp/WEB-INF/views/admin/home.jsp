<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADMIN</title>
</head>
<body>
 
  <div class="container mb-3">
                <div><h4>Phân loại sản phẩm</h4></div>
                    <select name="" id="list-categories" class="form-control">
                        <option value="">Tất cả sản phẩm</option>
                        <option value="">Nam</option>
                        <option value="">--Áo</option>
                        <option value="">----Áo thun</option>
                        <option value="">--Quần</option>
                        <option value="">----Quần thun</option>
                    </select>
            </div>
            <div class="container">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th id="td-id">Id</th>
                            <th id="td-img">Ảnh</th>
                            <th id="td-category">Category</th>
                            <th id="td-name">Tên sản phẩm</th>
                            <th id="td-control">
                            	<a href="<c:url value = "/admin/create-product"></c:url>" class="btn btn-primary"> Thêm sản phẩm</a>
                            </th>
                
                        </tr>
                    </thead>
                    <tbody class="show-item">
                        <tr>
                            <td>1</td>
                            <td class="item-image"><img src="" alt=""></td>
                            <td>áo thun</td>
                            <td>áo thun nữ</td>
                            <td>
                                <div class="d-flex">
                                    <button id="btn-edit" class="btn btn-warning mr-2">Chỉnh sửa</button>
                                    <button id="btn-delete" class="btn btn-danger">Xóa</button>
                                </div>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <div class=" mt-4">
                    <ul class="pagination" style="font-size: 16px; margin: 20px;"></ul>
                  </div>
            </div>

   <script src='<c:url value= "/resources/js/admin-home.js"/>'></script>
   
</body>
</html>