var nameProject = "ClothesShop"
function insertProduct() {
	//productdetail
	var count = totalDetail;
	var listColor = document.querySelectorAll('.list-color');
	var listSize = document.querySelectorAll('.list-size');
	var listQty = document.querySelectorAll('.qty');
	var totalQty = 0;
	var listProductDetail = [];
	for (let i = 0; i < count; i++) {
		var ProductDetail = {
			colorId: listColor[i].value,
			sizeId: listSize[i].value,
			qty: parseInt(listQty[i].value),
		}
		//err json empty string when mapping dto be
		if (ProductDetail.qty == "") {
			ProductDetail.qty = 0
		}
		totalQty = totalQty + parseInt(listQty[i].value);
		listProductDetail.push(ProductDetail);
	}
	//image
	var listFile = document.querySelector("#image-product").files;
	var listImage = [];
	for (let index = 0; index < listFile.length; index++) {
		var productImageDto = {
			path: listFile[index].name,
		}
		listImage.push(productImageDto);
	}
	//product
	var product = {
		name: document.querySelector("#name-product").value,
		oldPrice: parseFloat(document.querySelector("#old-price").value),
		newPrice: parseFloat(document.querySelector("#new-price").value),
		description: document.querySelector("#description").value,
		qty: totalQty,
		categoryId: document.querySelector("#list-categories").value,
		productDetailDtos: listProductDetail,
		productImageDtos: listImage,
	}
	//err json empty string when mapping dto be
	if (product.oldPrice == "") {
		product.oldPrice = 0
	}
	//err json empty string when mapping dto be
	if (product.newPrice == "") {
		product.newPrice = 0
	}
	uploadImage();
	sendProduct(product);
}
/* **********************
  function send product
 **********************  */
function sendProduct(product) {

	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4) { 
			if(xhttp.response != null){
				window.location = `${location.origin}/${nameProject}/admin/home`;
			}
		}
	};
	xhttp.open(
		"POST",
		`${location.origin}/${nameProject}/admin/upload-product/api`,
		true
	);
	xhttp.send(JSON.stringify(product));
}


/* **********************
  function of image
 **********************  */
function uploadImage() {
	file = document.querySelector("#image-product").files;
	var formData = new FormData();
	for (let i = 0; i < file.length; i++) {
		formData.append("file", file[i]);
	}
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4) {}
	};
	xhttp.open("POST",`${location.origin}/${nameProject}/admin/uploadfile/api`,true);
	xhttp.send(formData);
}

/* **********************
	function of color
   **********************  */
// get color
var dataColor = [];
var xhttpColor = new XMLHttpRequest();
xhttpColor.onreadystatechange = function() {
	if (xhttpColor.readyState == 4) {
		dataColor = JSON.parse(xhttpColor.response);
		var result = ``;
		dataColor.forEach((element) => {
			result += `<option value="${element.id}">${element.name}</option>`;
		});
		document.querySelector(".list-color").innerHTML = result;
	}
};
xhttpColor.open(
	"GET",
	`${location.origin}/${nameProject}/color/api`,
	true
);
xhttpColor.send();
/* **********************
	function of size
   **********************  */
// get size
var dataSize = [];
var xhttpSize = new XMLHttpRequest();
xhttpSize.onreadystatechange = function() {
	if (xhttpSize.readyState == 4) {
		dataSize = JSON.parse(xhttpSize.response);
		var result = ``;
		dataSize.forEach((element) => {
			result += `<option value="${element.id}">${element.name}</option>`;
		});
		document.querySelector(".list-size").innerHTML = result;
	}
};
xhttpSize.open("GET",`${location.origin}/${nameProject}/size/api`,true);
xhttpSize.send();

/* **********************
 function of color and size (chi tiết sản phẩm)
**********************  */
var totalDetail = 1;
function insertDetail() {
	var tbody = document.querySelector("tbody");
	var tr = document.createElement("tr");
	var html = ``;
	html += renderOptionColorOrSize(dataColor, "color");
	html += renderOptionColorOrSize(dataSize, "size");
	html += `<td>
                          <input class="form-control qty"type="number"value="0"/>
                      </td>
                      <td>
                          <button class="btn btn-danger btn${totalDetail + 1}"onclick="deleteDetail(${totalDetail + 1})">Xóa</button>
                      </td>`
	tr.innerHTML = html;
	tbody.appendChild(tr);
	totalDetail++;
}
function deleteDetail(id) {
	var deleteNode = document.querySelector(`.btn${id}`).parentNode
		.parentNode;
	document.querySelector("tbody").removeChild(deleteNode);
	totalDetail--;
}
function renderOptionColorOrSize(data, colorOrSize) {
	var result = `<td><select class="my-1 mr-sm-2 list-${colorOrSize} form-control">`;
	data.forEach((element) => {
		result += `<option value="${element.id}">${element.name}</option>`;
	});
	result += `</select></td>`;
	return result;
}

/* **********************
	function of category
   **********************  */
// get categor
var dataCategory = [];
var listCategories = document.querySelector("#list-categories");
var xhttpCategory = new XMLHttpRequest();
xhttpCategory.onreadystatechange = function() {
	if (xhttpCategory.readyState == 4) {
		dataCategory = JSON.parse(xhttpCategory.response);
		var html = renderOptionCategory(getOptionCategory, dataCategory, 0, 0);
		listCategories.innerHTML = html;
	}
};
xhttpCategory.open(
	"GET",
	`${location.origin}/${nameProject}/nav/api`,
	
	true
);
xhttpCategory.send();

function renderOptionCategory(getOptionCategory, data, parentId, level) {
	var result = `<option value="0">Chọn category</option>`;
	var rp = "---";
	getOptionCategory(data, parentId, level).forEach((element) => {
		result += `<option value="${element.id}">${rp.repeat(element.lv)}${element.name}</option>`;
	});
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