Setup file:
tool: jdk1.8, elclipse, apache-tomcat, MySQL Workbench

b1: Chạy MySQL Workbench
b2: Ấn ctrl + T để new một Query tab
b3: Coppy tất cả code trong file clothesshopdb.sql paste vào query tab vừa tạo rồi execute để tạo database.
b4: Chạy eclipse chọn file -> import 
    trong cửa sổ import chọn thư mục maven -> chọn Existing Maven Projects -> ấn next
    -> chọn đường dẫn tới thư mục chứa thư mục project -> chọn select Folder -> ấn Finish
b5: Chọn project vừa import -> src -> main -> WEB-INF -> config -> mở file springDispatcherServelet
b6: Sửa value của username và password ở dòng 33 và 34 cho đúng với username và passwork của MySQL Workbeanch trong máy
b7: Trên thanh công cụ chọn Window -> Web Browser -> Default system web browser
b8: Bên tab Project Explorer chuột phải vào project ClothesShop chọn Run As -> Run on server -> chọn thư mục Apache -> Tomcat v9.0 Server
	-> chọn đến thư mục chứa apache-tomcat-9.0 có sẵn trong máy hoặc ấn Download and Install để tải -> chọn Finish

