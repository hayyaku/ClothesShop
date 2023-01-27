var nameProject = "ClothesShop"
var data = [];
const url = location.href;
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
          if (xhttp.readyState == 4) {
            data = JSON.parse(xhttp.response);
            //lây tên sp
            document.querySelector(".name-item").innerHTML = data.name;
            //lấy giá sp
            document.querySelector(".price").innerHTML = `${data.newPrice.toLocaleString('de-DE')}đ <span>${data.oldPrice.toLocaleString('de-DE')}đ</span>`;
            var subData = data.productDetailDtos;
            //lọc các màu mà sản phẩm có
            var color = new Set();
            subData.forEach((element) => {
              color.add(element.color);
            });
            //đổi set sang array tiện truy vấn
            color = Array.from(color);
            //hiển thị các màu
            color.forEach((element) => {
              document.querySelector(".color-item ul").insertAdjacentHTML("beforeend", `<li>${element}</li>`);
            });
            //hiển các size của màu đầu tiên
            subData.forEach((element) => {
              if (color[0] == element.color) {
                document.querySelector(".size-item ul").insertAdjacentHTML("beforeend", `<li>${element.size}</li>`);
              }
            });
            //duyệt từng thẻ li bắt sự kiện kick vào chọn màu sản phẩm
            document.querySelectorAll(".color-item ul li").forEach((element) => {
                //bắt sự kiển khi kích vào thẻ li nào đó
                element.addEventListener("click", (e) => {
                  //xóa class active ở tất cả thẻ
                  document.querySelectorAll(".color-item ul li").forEach((element) => {
                      element.classList.remove("active");
                    });
                  //thêm class active cho thẻ dc click
                  element.classList.add("active");
                  //lưu tên màu thẻ dc click vào 1 biến tạm
                  temp = element.innerHTML;
                  //làm trống thẻ ul chứa tên size
                  document.querySelector(".size-item ul").innerHTML = "";
                  //hiển thị các size của màu sp dc click
                  subData.forEach((element) => {
                    if (temp == element.color) {
                      document.querySelector(".size-item ul").insertAdjacentHTML("beforeend",`<li>${element.size}</li>`
                        );
                    }
                  });
                  //duyệt từng thẻ li bắt sự kiện kick vào chọn size sản phẩm
                  document.querySelectorAll(".size-item ul li").forEach(element =>{
                    element.addEventListener("click", (e)=>{
                      //xóa class active ở tất cả thẻ
                      document.querySelectorAll(".size-item ul li").forEach(element =>{
                        element.classList.remove("active");
                      });
                      //thêm class active cho thẻ dc click
                      element.classList.add("active");
                     });
                    })
                });
              });     
              document.querySelector(".description p").innerHTML = data.description;
              
              /* *******************
                 Render ảnh sản phẩm
              ********************** */
              document.querySelector(".render-image").innerHTML = renderImage(data);
              controlViewImage()
              console.log(document.querySelector(".render-image"));
          }
        };
      
        xhttp.open("GET", url + `/api`, true);
        xhttp.send(); 

//chọn số lượng sản phẩm 
        var btnDec = document.querySelector(".qty-item .dec");
        var btnInc = document.querySelector(".qty-item .inc");
        var qtyInput = document.querySelector(".qty-item input");
        
        btnDec.addEventListener("mousedown", (e) =>{
          if(qtyInput.value > 0){
            qtyInput.value--;
          }
        })
        btnInc.addEventListener("mousedown", (e) =>{
            qtyInput.value++;
        })

//ảnh sản phẩm
		function controlViewImage (){
        var showItem = document.querySelector(".show-item img");
        var listImg = document.querySelectorAll(".list-item img");
        var listItem = document.querySelector(".list-item");
        var listItem1 = document.querySelectorAll(".list-item");

        listImg.forEach((element) => {
          element.addEventListener("click", (e) => {
            showItem.src = element.src;
          });
        });

        var isdragStart = false;
        var prevPagex;
        var prevScrollLeft;

        var dragStart = (e) => {
          isdragStart = true;
          //lấy vị trí chuột vừa kích xuống
          //prevPagex vị trí lúc ấn chuột lưu bằng tọa độ của page lúc ấn
          prevPagex = e.pageX;
          //lấy vị trí hiện tại của trang cuộn ban đầu sẽ = 0
          prevScrollLeft = listItem.scrollLeft;
        };
        var dragStop = (e) => {
          isdragStart = false;
        };
        var dragging = (e) => {
          if (!isdragStart) return;
          e.preventDefault();
          // khoảng cách kéo chuột bằng vị trí tọa độ hiện tại chuột đang ở - vị trí lúc ấn chuột
          var positionDiff = e.pageX - prevPagex;
          //vị trí trang cuộn bằng vị trí ban đầu của nó - khoảng cách kéo chuột
          listItem.scrollLeft = prevScrollLeft - positionDiff;
        };

        listItem.addEventListener("mousedown", dragStart);
        listItem.addEventListener("mousemove", dragging);
        listItem.addEventListener("mouseup", dragStop);
        }
        
        function renderImage(data){
			var listImage = data.productImageDtos;
			var result =`<div class="show-item">
                			<img src="/${nameProject}/resources/images/${listImage[0].path}" alt="" />
              			 </div>
             			 <div class="list-item d-flex">`;
             listImage.forEach((element) =>{
				 result += `<img src="/${nameProject}/resources/images/${element.path}" alt="" />`
			 })
			 result +=`</div>`;
			return result;
		}
		
		