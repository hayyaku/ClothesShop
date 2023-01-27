
var nameProject = "ClothesShop"

/* **********************
  function get category
 **********************  */
var dataNav = [];
var listCategories = document.querySelector('#list-categories');
var xhttpNav = new XMLHttpRequest();
xhttpNav.onreadystatechange = function() {
	if (xhttpNav.readyState == 4) {
		dataNav = JSON.parse(xhttpNav.response);
		var html = renderOption(getOption, dataNav, 0, 0)
		listCategories.innerHTML = html
	}
};
xhttpNav.open(
	"GET",
	`${location.origin}/${nameProject}/nav/api`,
	true
);
xhttpNav.send();


/* **********************
  function show item
 **********************  */
//api get item anh page
var fiterdata = {
	categoryId: 0,
	curentPage: 1,
}
var dataProduct = [];
var totalPage;
var xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function() {
	if (xhttp.readyState == 4) {
		dataProduct = JSON.parse(xhttp.response);
		totalPage = dataProduct.totalPage;
		var html = "";
		var listProduct = dataProduct.productDtos;
		listProduct.forEach((element) => {
			html += renderOneItem(element.id, element.productImageDtos[0].path, element.category, element.name)
		})

		document.querySelector(".show-item").innerHTML = html;
		getItem(pagination, totalPage, fiterdata.curentPage);
	}
};
xhttp.open("POST", `${location.origin}/${nameProject}/filter-product/api`, true);
xhttp.send(JSON.stringify(fiterdata));

//filter product by category
listCategories.addEventListener("change", () => {
	fiterdata.categoryId = listCategories.value;
	getItem(pagination, totalPage, 1);
})

function renderOption(getOption, data, parentId, level) {
	var result = `<option value="0">Tất cả sản phẩm</option>`;
	var rp = "---"
	getOption(data, parentId, level).forEach(element => {
		result += `<option value="${element.id}">${rp.repeat(element.lv)}${element.name}</option>`
	})
	return result;
}

function getOption(data, parentId, level) {
	var result = [];
	data.forEach((element) => {
		if (element.parentId == parentId) {
			var item = {
				id: element.id,
				name: element.name,
				lv: level
			};
			result.push(item);
			if (checkChild(data, element.id)) {
				getOption(data, element.id, level + 1).forEach(element => {
					result.push(element);
				})
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
// render pagination
function pagination(totalPage, page) {
	var ulTag = document.querySelector(".pagination");
	var active = "";
	var html = "";
	//tổng số trang nhỏ hơn 10 in ra tất cả các trang ko có dấu ...
	if (totalPage <= 10) {
		for (let i = 1; i <= totalPage; i++) {
			if (page == i) active = "page-active";
			else active = "";
			html += `<li class="${active} page-link" onclick="pagination(${totalPage}, ${i})" ><span>${i}</span></li>`;
		}
	} else {
		//nếu ở 4 page đầu in ra 5 page đầu => .. +>page cuối
		if (page < 5) {
			for (let i = 1; i <= 5; i++) {
				if (page == i) active = "page-active";
				else active = "";
				html += `<li class="${active} page-link" onclick="pagination(${totalPage}, ${i})"><span>${i}</span></li>`;
			}
			if (page == totalPage) active = "page-active";
			else active = "";
			html += `<li class="page-link"><span>...</span></li>
                    <li class="${active} page-link" onclick="pagination(${totalPage}, ${totalPage})"><span>${totalPage}</span></li>`;
		}
		//nếu ở 4 page cuối cùng in ra page 1 => ... => 5 page cuối
		else if (page > totalPage - 4) {
			if (page == 1) active = "page-active";
			else active = "";
			html += `<li class="${active} page-link" onclick="pagination(${totalPage}, 1)"><span>1</span></li>
                    <li class="page-link"><span>...</span></li>`;
			for (let i = totalPage - 4; i <= totalPage; i++) {
				if (page == i) active = "page-active";
				else active = "";
				html += `<li class="${active} page-link" onclick="pagination(${totalPage}, ${i})"><span>${i}</span></li>`;
			}
		}
		//còn lại in ra page 1 đến ... đến 5 page liền nhau đến ... đến page cuối
		else {
			if (page == 1) active = "page-active";
			else if (page == totalPage) active = "page-active";
			else active = "";
			html += `<li class="${active} page-link" onclick="pagination(${totalPage}, 1)"><span>1</span></li>
                    <li class="page-link"><span>...</span></li>`;
			for (let i = page - 2; i <= page + 2; i++) {
				if (page == i) active = "page-active";
				else active = "";
				html += `<li class="${active} page-link" onclick="pagination(${totalPage}, ${i})"><span>${i}</span></li>`;
			}
			html += `<li class="page-link"><span>...</span></li>
                    <li class="${active} page-link" onclick="pagination(${totalPage}, ${totalPage})"><span>${totalPage}</span></li>`;
		}
	}
	ulTag.innerHTML = html;
	fiterdata.curentPage = page;
	getItem();
}

function renderOneItem(id, imageName, category, nameProduct) {
	//<button class="btn-edit btn btn-warning mr-2" onclick="editItem(${id})">Chỉnh sửa</button>	
	return `<tr>
               <td>${id}</td>
               <td class="item-image"><img src="/${nameProject}/resources/images/${imageName}" alt=""></td>
               <td>${category}</td>
               <td>${nameProduct}</td>
               <td>
               <div class="row">
                    
                    <a href="/${nameProject}/admin/update-product/${id}" id="btn-edit" class="btn btn-warning mr-2">Chỉnh sửa</a>
                    <button id="btn-delete-${id}" class="btn btn-danger" onclick="removeItem(${id})">Xóa</button>
               </div>
               </td>
             </tr>`
}

function getItem(pagination, totalPage, curentPage) {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4) {
			var data = JSON.parse(xhttp.response);
			totalPage = data.totalPage;
			var html = "";
			var listProduct = data.productDtos;
			listProduct.forEach(element => {
				html += renderOneItem(element.id, element.productImageDtos[0].path, element.category, element.name)
			})
			document.querySelector(".show-item").innerHTML = html;
			// không truyền tham số vavof getItem thì ko gọi hàm này
			if (pagination != null) {
				pagination(totalPage, curentPage);
			}
		}
	};
	xhttp.open(
		"POST",
		`${location.origin}/${nameProject}/filter-product/api`,
		true
	);
	xhttp.send(JSON.stringify(fiterdata));
}

function removeItem(id) {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4) {
			if (xhttp.response == "ok") {
				var deleteNode = document.getElementById(`btn-delete-${id}`).parentNode.parentNode.parentNode;
				console.log(deleteNode);
				console.log(document.querySelector(".show-item tbody"));
				document.querySelector(".show-item").removeChild(deleteNode);
				alert("Xóa thành công");
			}
		}
	};
	xhttp.open("DELETE",
	 `${location.origin}/${nameProject}/admin/upload-product/api`,
	  true);
	xhttp.send(id);
}