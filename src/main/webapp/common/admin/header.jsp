<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="https://cdn.jsdelivr.net/npm/boxicons@2.1.4/css/boxicons.min.css" rel="stylesheet">
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Header</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/templates/admin/css/styles-header.css"/>
    <script src="${pageContext.request.contextPath}/templates/admin/js/scripts-header.js" defer></script>
</head>
<body>
<!-- Header Section Start -->
<div class="header_section">
    <div class="container-fluid">
        <nav class="navbar navbar-light bg-light justify-content-between">
            <div id="mySidenav" class="sidenav">
                <div class="logo">
                    <img src="${pageContext.request.contextPath}/templates/images/logo1.jpg" alt="Logo"/>
                </div>
                <div class="select-item">
                    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
                    <a href="/admin/home">Trang chủ</a>
                    <a href="/admin/list-shop">Cửa hàng</a>
                    <a href="/admin/list-product">Sản phẩm</a>
                    <a href="/admin/top-shops">Doanh thu</a>
                    <a href="${pageContext.request.contextPath}/info">Tài khoản của tôi</a>
                    <a href="${pageContext.request.contextPath}/admin/page-admin">Quản trị</a>
                </div>
            </div>
            <span class="toggle_icon" onclick="openNav()">
                    <img src="${pageContext.request.contextPath}/templates/images/toggle-icon.png" alt="Toggle"/>
                </span>
            <label id="name">Cosmetics</label>
            <form class="form-inline">
                <div class="login_text">
                    <ul>
                        <li>
                            <c:choose>
                                <c:when test="${not empty username}">
                                    <!-- Nếu người dùng đã đăng nhập, hiển thị icon logout -->
                                    <a href="/logout">
                                        <i class='bx bx-door-open' style="font-size: 36px; color: black;"></i>
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <!-- Nếu chưa đăng nhập, hiển thị icon người dùng -->
                                    <a href="${pageContext.request.contextPath}/login">
                                    <i class='bx bxs-user-account' style="font-size: 36px; color: black;"></i>
                                    </a>
                                </c:otherwise>
                            </c:choose>
                        </li>
                        <li>
                            <a href="#">
                                <i class='bx bx-shopping-bag' style="font-size: 36px; color: black;"></i>
                            </a>
                        </li>
                    </ul>
                </div>
            </form>
        </nav>
    </div>
</div>
<!-- Header Section End -->
</body>
</html>
