var nameProject = "ClothesShop"
var dataNav = [];
var fiterdata = {
	categoryId: 0,
	curentPage: 1,
}
var totalPage;
//lấy danh mục sản phẩm từ API
var xhttpNav = new XMLHttpRequest();
xhttpNav.onreadystatechange = function() {
	if (xhttpNav.readyState == 4) {
		dataNav = JSON.parse(xhttpNav.response);
		var mainMenu = document.querySelector(".nav-menu-category");
		mainMenu.innerHTML = renderMenu(dataNav, 0, 0);

	}
};
xhttpNav.open("GET", `${location.origin}/${nameProject}/nav/api`, true);
xhttpNav.send();

//lấy sản phẩm từ API khi load trang lần đầu
var xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function() {
	if (xhttp.readyState == 4) {
		var data = JSON.parse(xhttp.response);
		totalPage = data.totalPage;
		var html = "";
		var listProduct = data.productDtos;
		listProduct.forEach(element => {
			html += renderOneItem(element.id, element.productImageDtos[0].path, element.name, element.newPrice, element.oldPrice)
		})
		document.querySelector(".list-product-filter").innerHTML = html;
		getItem(pagination, totalPage, fiterdata.curentPage);
	}
};
xhttp.open("POST",`${location.origin}/${nameProject}/filter-product/api`,true);
xhttp.setRequestHeader("Content-type", "application/json");
xhttp.send(JSON.stringify(fiterdata));

function checkChild(data, id) {
	for (let i = 0; i < data.length; i++) {
		if (data[i].parentId == id) {
			return 1;
		}
	}
	return 0;
}

function renderMenu(data, parentId, levelMenu) {
	var result = "";
	if (levelMenu == 0) {
		result = `<ul class="main-menu">`;
	} else {
		result = `<ul class="sub-menu">`;
	}
	data.forEach((element) => {
		if (element.parentId == parentId) {
			result += `<li>`;
			result += `<p id="menu_item_${element.id}" onclick="clickCategor(${element.id})">${element.name}</p>`;
			if (checkChild(data, element.id)) {
				result += renderMenu(data, element.id, levelMenu + 1);
			}
			result += `</li>`;
		}
	});
	result += `</ul>`;

	return result;
}

function clickCategor(id) {
	fiterdata.categoryId = id;
	document
		.querySelector("#menu_item_0")
		.classList.remove("category-action");
	var pCategoty = document.querySelectorAll(".main-menu p");
	pCategoty.forEach((element) => {
		element.classList.remove("category-action");
	});
	document.querySelector(`#menu_item_${id}`).classList.add("category-action");
	getItem(pagination, totalPage, 1);

}


function pagination(totalPage, page) {
	let ulTag = document.querySelector(".pagination");
	let active = "";
	let html = "";
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

function renderOneItem(id, imageName, itemName, newPrice, oldPrice) {
	return `<div class="col-xl-4 col-lg-6 col-md-6">
            <a href='/${nameProject}/product-detail/${id}'>
          <div class="item">
            <div class="img">
              <img src='/${nameProject}/resources/images/${imageName}' alt="">
             
              <ul>
                <li class="icon-bag"><i class="fa fa-shopping-cart"></i></li>
                <li class="qick-view">Xem nhanh</li>
              </ul>
            </div>
            
            <div class="title">
              <p>${itemName}</p>
              <div class="price">
                ${newPrice.toLocaleString('de-DE')}đ
                <span>${oldPrice.toLocaleString('de-DE')}đ</span>
              </div>
            </div>
          </div>
            </a>
        </div>`
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
				html += renderOneItem(element.id, element.productImageDtos[0].path, element.name, element.newPrice, element.oldPrice)
			})
			document.querySelector(".list-product-filter").innerHTML = html;
			if(pagination != null){
			pagination(totalPage, curentPage);
			}
		}
	};
	xhttp.open(
		"POST",
		"http://localhost:8080/ClothesShop/filter-product/api",
		true
	);
	xhttp.send(JSON.stringify(fiterdata));
}




