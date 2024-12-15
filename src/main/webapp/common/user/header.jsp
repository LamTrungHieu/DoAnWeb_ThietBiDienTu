<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Header</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/templates/user/css/styles-header.css"/>
    <script src="${pageContext.request.contextPath}/templates/user/js/scripts-header.js" defer></script>
</head>
<body>
<!-- header section start -->
<div class="header_section">
    <div class="logo_and_name">
        <img src="${pageContext.request.contextPath}/templates/images/logohexatech.jpg"/>
        <label id="name">HexaTech</label>
    </div>
    <div class="header-container-fluid">
        <nav class="header-navbar navbar-light header-bg-light">
            <div class="navbar-links">
                <a href="${pageContext.request.contextPath}/user/home">Trang chủ</a>
                <a href="${pageContext.request.contextPath}/products">Sản phẩm</a>
                <a href="${pageContext.request.contextPath}/info">Tài khoản của tôi</a>
                <a href="${pageContext.request.contextPath}/user/vendor-register">Đăng kí bán hàng</a>
            </div>
            <div class="login_text">
                <ul>
                    <li>

                        <c:choose>
                            <c:when test="${not empty username}">
                                <a href="${pageContext.request.contextPath}/user/history">
                                    <i class='bx bx-time' style="font-size: 36px; color: black;"></i>
                                </a>

                                <a href="${pageContext.request.contextPath}/user/follow-shop">
                                    <i class='bx bx-heart' style="font-size: 36px; color: black;"></i>
                                </a>

                                <a href="${pageContext.request.contextPath}/user/orders">
                                    <i class='bx bxs-receipt' style="font-size: 36px; color: black;"></i>
                                </a>


                                <!-- Nếu người dùng đã đăng nhập, hiển thị icon logout -->
                                <a href="${pageContext.request.contextPath}/logout">
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
                        <!-- Sidebar -->
                        <!-- Lấy userId từ session và lưu vào input ẩn -->
                        <input type="hidden" id="userId-cart" value="${sessionScope.user.id_user}">
                        <div id="shoppingNavbar">
                            <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
                            <h2>Giỏ hàng</h2>

                            <table class="shopping-cart-table">
                                <tbody id="cart-items-body">
                                <!-- Các sản phẩm sẽ được thêm ở đây -->
                                </tbody>
                            </table>
                        </div>


                        <span class="toggle_icon" onclick="openNav()">
                            <i id="shoppingBagToggle" class='bx bx-shopping-bag' style="font-size: 36px; color: black; cursor: pointer;"></i>
                        </span>
                    </li>
                </ul>
            </div>

        </nav>
    </div>
</div>
</body>
</html>
