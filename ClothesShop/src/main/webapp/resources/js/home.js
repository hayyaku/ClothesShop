      var dataList = [];
      var nameProject = "ClothesShop"
      var xhttpHome = new XMLHttpRequest();
      xhttpHome.onreadystatechange = function () {
        if (xhttpHome.readyState == 4) {
          dataList = JSON.parse(xhttpHome.response);
            var listItem ="";
          dataList.forEach(element => {
            listItem+=renderOneItem(element.id,element.productImageDtos[0].path,element.name,element.newPrice,element.oldPrice)
                          

          });
          document.querySelector(".body-list-item").innerHTML = listItem;
        }
      };

      xhttpHome.open("GET",`${location.origin}/${nameProject}/home-item/api`,true);
      xhttpHome.send();


      function renderOneItem(id, imageName, itemName, newPrice, oldPrice) {
        return `<div class="col-xl-3 col-lg-4 col-md-6">
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