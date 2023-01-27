/* **********************
	get data
   **********************  */
var nameProject = "ClothesShop"
var data = [];
var xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function() {
	if (xhttp.readyState == 4) {
		data = JSON.parse(xhttp.response);
		//product infor
		getCategory(data.categoryId);
		document.querySelector("#name-product").value = data.name;
		document.querySelector("#old-price").value = data.oldPrice;
		document.querySelector("#new-price").value = data.newPrice;
		document.querySelector("#description").value = data.description;
		//product image
		renderImage(data.productImageDtos);
		//product detail
		renderAllProductDetail(data.productDetailDtos);

	}
};
xhttp.open("GET", `${location.href}/api`, true);
xhttp.send();

function updateProduct(){
              var product={
                id:data.id,
                categoryId : document.getElementById("list-categories").value,
                name : document.getElementById("name-product").value,
                oldPrice : document.getElementById("old-price").value,
                newPrice : document.getElementById("new-price").value,
                description : document.getElementById("description").value,
              }
            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function () {
            if (xhttp.readyState == 4) {
              if(xhttp.response == "ok"){
                alert("Update thành công");
              }
          }
        };
        xhttp.open("PUT",`${location.origin}/${nameProject}/admin/upload-product/api`, true);
        xhttp.send(JSON.stringify(product));
        }
/* **********************
  function of image
 **********************  */
function renderImage(data) {
	var html = "";
	data.forEach(element => {
		html += `<tr>
                          <td>${element.id}</td>
                          <td class="item-image">
                            <img id="image-${element.id}" src="/${nameProject}/resources/images/${element.path}" alt="">
                          </td>
                          <td>
                            <button id="btn-edit-img-${element.id}" class="btn btn-warning mr-2" onclick="updateImage(${element.id})">Thay ảnh</button>
                            <button id="btn-delete-img-${element.id}" class="btn btn-danger" onclick="deleteImage(${element.id})">Xóa</button>
                          </td>
                      </tr>`
	});
	document.querySelector(".product-image-body table tbody").innerHTML = html;
}
/* **************
	Đổi ảnh
******************/
function updateImage(id) {
	var html = `<div class="edit-product" onclick="closeEdit()">
                        <div class="edit-product-inner">
                            <div class="close" onclick="closeEdit()">
                              <i class="fa-solid fa-xmark"></i>
                              </div>
                          <div class="form-group">
                            <label for="image-product">Tải ảnh lên</label>
                            <input type="file" class="form-control"id="image-product"/>
                          </div>
                          <button class="btn btn-success mt-2"onclick="successUpdateImage(${id})">Đổi ảnh</button>
                        </div>
                      </div>`
	document.querySelector(".edit-product-body").innerHTML = html;
	document.querySelector(".edit-product").addEventListener("click", (e) => {
		if (e.target == e.currentTarget) {
			document.querySelector(".edit-product-body").innerHTML = "";
		}
	});
	document.querySelector(".close").addEventListener("click", (e) => {
		document.querySelector(".edit-product-body").innerHTML = "";
	});
}

function successUpdateImage(id) {
	if (document.querySelector("#image-product").files.length != 0) {
		uploadImage();
		sendInforUpdateImage(id)
	} else {
		document.querySelector(".edit-product-body").innerHTML = "";
	}
}

function sendInforUpdateImage(id) {
	var file = document.querySelector("#image-product").files;
	var productImageDto = {
		id: id,
		productId: data.id,
		path: file[0].name,
	}
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4) {
			if (xhttp.response == "ok") {
				document.querySelector(`#image-${id}`).src = `/${nameProject}/resources/images/${productImageDto.path}`;
				document.querySelector(".edit-product-body").innerHTML = "";
				alert("Update thành công");
			}
		}
	};
	xhttp.open("PUT", `${location.origin}/${nameProject}/admin/product-image/api`, true);
	xhttp.send(JSON.stringify(productImageDto));
}
/* **************
	Thêm ảnh
******************/
function insertImage() {
	var html = `<div class="edit-product" onclick="closeEdit()">
                        <div class="edit-product-inner">
                            <div class="close" onclick="closeEdit()">
                              <i class="fa-solid fa-xmark"></i>
                              </div>
                          <div class="form-group">
                            <label for="image-product">Tải ảnh lên</label>
                            <input type="file" class="form-control"id="image-product"multiple/>
                          </div>
                          <button class="btn btn-success mt-2"onclick="successUploadImage()">Thêm</button>
                        </div>
                      </div>`
	document.querySelector(".edit-product-body").innerHTML = html;
	document.querySelector(".edit-product").addEventListener("click", (e) => {
		if (e.target == e.currentTarget) {
			document.querySelector(".edit-product-body").innerHTML = "";
		}
	});
	document.querySelector(".close").addEventListener("click", (e) => {
		document.querySelector(".edit-product-body").innerHTML = "";
	});
}

function successUploadImage() {
	if (document.querySelector("#image-product").files.length != 0) {
		uploadImage();
		createNewImage()
	} else {
		document.querySelector(".edit-product-body").innerHTML = "";
	}
}

function createNewImage() {
	var listFile = document.querySelector("#image-product").files;
	var productImageDtos = [];
	for (let index = 0; index < listFile.length; index++) {
		var productImageDto = {
			productId: data.id,
			path: listFile[index].name,
		}
		productImageDtos.push(productImageDto);
	}

	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4) {
			renderImage(JSON.parse(xhttp.response));
			document.querySelector(".edit-product-body").innerHTML = "";
		}
	};
	xhttp.open("POST", `${location.origin}/${nameProject}/admin/product-image/api`, true);
	xhttp.send(JSON.stringify(productImageDtos));
}
/* **************
		  xóa ảnh
******************/
function deleteImage(id) {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4) {
			// if response ok delete show this image
			if (xhttp.response == "ok") {
				var deleteNode = document.querySelector(`#btn-delete-img-${id}`).parentNode.parentNode;
				document.querySelector(".product-image-body tbody").removeChild(deleteNode);
				alert("Xóa thành công");
			}
		}
	};
	xhttp.open("DELETE", `${location.origin}/${nameProject}/admin/product-image/api`, true);
	xhttp.send(id);
}

function uploadImage() {
	file = document.querySelector("#image-product").files;
	var formData = new FormData();
	for (let i = 0; i < file.length; i++) {
		formData.append("file", file[i]);
	}
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4) {

		}
	};
	xhttp.open("POST", `${location.origin}/${nameProject}/admin/uploadfile/api`, true);

	xhttp.send(formData);
}

/* **********************
	function of color
   **********************  */
// get color
async function getColor() {
	var promitseColor = new Promise(function(resolve, reject) {
		var xhttpColor = new XMLHttpRequest();
		xhttpColor.onreadystatechange = function() {
			if (xhttpColor.readyState == 4) {
				resolve(JSON.parse(xhttpColor.response));
			}
		};
		xhttpColor.open("GET", `${location.origin}/${nameProject}/color/api`, true);
		xhttpColor.send();
	});
	return await promitseColor;
}

/* **********************
	function of size
   **********************  */
// get size
async function getSize() {
	var promitseSize = new Promise(function(resolve, reject) {
		var xhttpSize = new XMLHttpRequest();
		xhttpSize.onreadystatechange = function() {
			if (xhttpSize.readyState == 4) {
				resolve(JSON.parse(xhttpSize.response));
			}
		};
		xhttpSize.open("GET", `${location.origin}/${nameProject}/size/api`, true);
		xhttpSize.send();
	})
	return await promitseSize;
}


/* **********************
 function of color and size (chi tiết sản phẩm)
********************** */
async function renderAllProductDetail(data) {
	var listSize = await getSize();
	var listColor = await getColor();
	var html = "";
	for (let i = 0; i < data.length; i++) {
		html += `<tr>
                 <td>${data[i].id}</td>
                 <td>
                 <select class="my-1 mr-sm-2 list-color-${data[i].id} form-control">`;
		listColor.forEach(element => {
			if (data[i].colorId == element.id) {
				html += `<option value="${element.id}" selected>${element.name}</option>`;
			} else {
				html += `<option value="${element.id}">${element.name}</option>`;
			}
		})
		html += `</select>
                </td>
                <td>
                  <select class="my-1 mr-sm-2 list-size-${data[i].id} form-control">`;
		listSize.forEach(element => {
			if (data[i].sizeId == element.id) {
				html += `<option value="${element.id}" selected>${element.name}</option>`;
			} else {
				html += `<option value="${element.id}">${element.name}</option>`;
			}
		})
		html += `</select>
                </td>
                <td>
                   <input class="form-control qty-${data[i].id}"type="number"value="${data[i].qty}"/>
                </td>
                <td>
                   <button id="btn-update-detail-${data[i].id}" class="btn btn-warning"onclick="updateDetail(${data[i].id})">Sửa</button>
                   <button id="btn-delete-detail-${data[i].id}" class="btn btn-danger"onclick="deleteDetail(${data[i].id})">Xóa</button>
                </td>
              </tr>
             </tbody>
             </table>
             </div>`
	}
	document.querySelector(".product-detail-body table tbody").innerHTML = html;
}
async function renderOneProductDetail(data) {
	var listSize = await getSize();
	var listColor = await getColor();
	var html = `<tr>
                      <td>${data.id}</td>
                      <td>
                        <select class="my-1 mr-sm-2 list-color-${data.id} form-control">`;
	listColor.forEach(element => {
		if (data.colorId == element.id) {
			html += `<option value="${element.id}" selected>${element.name}</option>`;
		} else {
			html += `<option value="${element.id}">${element.name}</option>`;
		}
	})
	html += `</select>
                      </td>
                      <td>
                        <select class="my-1 mr-sm-2 list-size-${data.id} form-control">`;
	listSize.forEach(element => {
		if (data.sizeId == element.id) {
			html += `<option value="${element.id}" selected>${element.name}</option>`;
		} else {
			html += `<option value="${element.id}">${element.name}</option>`;
		}
	})
	html += `</select>
                      </td>
                      <td>
                        <input class="form-control qty-${data.id}"type="number"value="${data.qty}"/>
                      </td>
                      <td>
                        <button id="btn-update-detail-${data.id}" class="btn btn-warning"onclick="updateDetail(${data.id})">Sửa</button>
                        <button id="btn-delete-detail-${data.id}" class="btn btn-danger"onclick="deleteDetail(${data.id})">Xóa</button>
                      </td>
                    </tr>`
	var trElement = document.createElement("tr");
	trElement.innerHTML = html;
	document.querySelector(".product-detail-body table tbody").appendChild(trElement);
}
/* **************
  Thêm detail
***************** */
async function insertDetail() {
	var listSize = await getSize();
	var listColor = await getColor();
	var html = `<div class="edit-product" onclick="closeEdit()">
                  <div class="edit-product-inner">
                     <div class="close" onclick="closeEdit()">
                        <i class="fa-solid fa-xmark"></i>
                     </div>
                      
                  <table class="table">
                    <thead>
                      <tr>
                         <th>Màu sản phẩm</th>
                         <th>Size sản phẩm</th>
                         <th>Số lượng</th>
                      </tr>
                    </thead>

                    <tbody>
                      <tr>
                        <td>
                        <select class="my-1 mr-sm-2 list-color form-control">`;
	listColor.forEach(element => {
		html += `<option value="${element.id}">${element.name}</option>`;
	});
	html += `</select>
               </td>
               <td>
                 <select class="my-1 mr-sm-2 list-size form-control">`;
	listSize.forEach((element) => {
		html += `<option value="${element.id}">${element.name}</option>`;
	});
	html += `</select>
                      </td>
                      <td>
                        <input class="form-control qty"type="number"value="0"/>
                      </td>
                     </tbody>
                   </table>
                      <button class="btn btn-success mt-2"onclick="successInsertDetail()">Thêm</button>
                  </div>
               </div>`
	document.querySelector(".edit-product-body").innerHTML = html;
	document.querySelector(".edit-product").addEventListener("click", (e) => {
		if (e.target == e.currentTarget) {
			document.querySelector(".edit-product-body").innerHTML = "";
		}
	});
	document.querySelector(".close").addEventListener("click", (e) => {
		document.querySelector(".edit-product-body").innerHTML = "";
	});
}

function successInsertDetail() {
	var productDetail = {
		product_id: data.id,
		colorId: document.querySelector(".edit-product-body .list-color").value,
		sizeId: document.querySelector(".edit-product-body .list-size").value,
		qty: document.querySelector(".edit-product-body .qty").value,
	}
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4) {
			renderOneProductDetail(JSON.parse(xhttp.response));
			document.querySelector(".edit-product-body").innerHTML = "";
		}
	}
	xhttp.open("POST", `${location.origin}/${nameProject}/admin/product-detail/api`, true);
	xhttp.send(JSON.stringify(productDetail));
}

/* **************
		  xóa detail
***************** */

function deleteDetail(id) {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4) {
			if (xhttp.response == "ok") {
				var deleteNode = document.querySelector(`#btn-delete-detail-${id}`).parentNode.parentNode;
				document.querySelector(".product-detail-body tbody").removeChild(deleteNode);
				alert("Xóa thành công");
			}
		}
	}
	xhttp.open("DELETE", `${location.origin}/${nameProject}/admin/product-detail/api`, true);
	xhttp.send(id);
}

function updateDetail(id) {
	var dataUpdate = {
		id: id,
		colorId: document.querySelector(`.product-detail-body .list-color-${id}`).value,
		sizeId: document.querySelector(`.product-detail-body .list-size-${id}`).value,
		qty: document.querySelector(`.product-detail-body .qty-${id}`).value,
	}
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4) {
			if (xhttp.response == "ok") {
				alert("Update thành công");
			}
		}
	}
	xhttp.open("PUT", `${location.origin}/${nameProject}/admin/product-detail/api`, true);
	xhttp.send(JSON.stringify(dataUpdate));
}

/* **********************
	function of category
   **********************  */
// get categor

function getCategory(select) {
	var dataCategory = [];
	var listCategories = document.querySelector("#list-categories");
	var xhttpCategory = new XMLHttpRequest();
	xhttpCategory.onreadystatechange = function() {
		if (xhttpCategory.readyState == 4) {
			dataCategory = JSON.parse(xhttpCategory.response);
			var html = renderOptionCategory(getOptionCategory, dataCategory, 0, 0);
			listCategories.innerHTML = html;
			document.getElementById("list-categories").value = select;
		}
	}
	xhttpCategory.open("GET", `${location.origin}/${nameProject}/nav/api`, true);
	xhttpCategory.send();
}

function renderOptionCategory(getOptionCategory, data, parentId, level) {
	var result = `<option value="0">Chọn category</option>`;
	var rp = "---";
	getOptionCategory(data, parentId, level).forEach((element) => {
		result += `<option value="${element.id}">${rp.repeat(element.lv)}${element.name
			}</option>`;
	})
	return result;
}

function getOptionCategory(data, parentId, level) {
	var result = [];
	data.forEach((element) => {
		if (element.parentId == parentId) {
			var item = {
				id: element.id,
				name: element.name,
				lv: level,
			};
			result.push(item);
			if (checkChild(data, element.id)) {
				getOptionCategory(data, element.id, level + 1).forEach(
					(element) => {
						result.push(element);
					}
				);
			}
		}
	});
	return result;
}

function checkChild(data, id) {
	for (let i = 0; i < data.length; i++) {
		if (data[i].parentId == id) {
			return 1;
		}
	}
	return 0;
}