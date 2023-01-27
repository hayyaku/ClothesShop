<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
</head>
<body>

    <!----------------- 
        start main 
    ------------------>
    <main>
    <section>
        <div class="container mt-5">
            <div class="row">
                <div class="col-lg-6 offset-lg-3">
                  <div class="form-login">
                    <h3>Đăng nhập</h3>
                    <form action="" method="post">
                      <div class="mb-3 col-12">
                        <label for="username" class="form-label">Tài khoản *</label>
                        <input
                          type="text"
                          class="form-control"
                          id="username"
                          name="userName"
                        />
                      </div>
                      <div class="mb-3 col-12">
                        <label for="password" class="form-label">Mật khẩu *</label>
                        <input
                          type="password"
                          class="form-control"
                          id="password"
                          name="passWord"
                        />
                      </div>
                      <div style="color: red; padding-left: 15px">${loginErr}</div>
                      <div class="col-12">
                        <button id="btntest" class="btn btn-primary" type="submit">
                          Đăng nhập
                        </button>
                      </div>
                    </form>
                  </div>
                </div>
              </div>
        </div>
    </section>
</main>
    
</body>
</html>