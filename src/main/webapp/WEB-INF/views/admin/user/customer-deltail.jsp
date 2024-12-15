<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Chi tiết khách hàng</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
    <style>
        /* CSS tùy chỉnh cho nút Khóa tài khoản */
        .btn-danger.custom-hover {
            background-color: #dc3545;
            border-color: #dc3545;
            color: #fff;
        }

        .btn-danger.custom-hover:hover {
            background-color: #444444;
            border-color: #444444;
            color: #fff;
        }

        .btn-custom-gray {
            background-color: #444444;
            border-color: #444444;
            color: #fff;
        }

        .btn-custom-gray:hover {
            background-color: #dc3545;
            border-color: #dc3545;
            color: #fff;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 10px;
            text-align: center;
            border: 1px solid #ddd;
        }

        thead {
            background-color: #f8f9fa;
            color: #333;
        }

        tbody tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tbody tr:hover {
            background-color: #e9ecef;
        }
    </style>
</head>
<body>
<div class="container mt-5">
    <!-- Back Button and Title -->
    <div class="d-flex align-items-center justify-content-between mb-4">
        <a href="${pageContext.request.contextPath}/admin/customers" class="btn btn-secondary"
           style="display: inline-block; background-color: #444444; color: white; padding: 10px; text-align: center; width: 40px; height: 40px; border-radius: 0; text-decoration: none; cursor: pointer;"
           onmouseover="this.style.backgroundColor='#d8373e';"
           onmouseout="this.style.backgroundColor='#444444';">
            <i class="fa fa-arrow-left" style="font-size: 20px;"></i>
        </a>
        <h1 class="text-center flex-grow-1">Chi tiết khách hàng</h1>
    </div>

    <!-- Customer Information -->
    <div class="card mt-4">
        <div class="card-header">
            <h4>Thông tin khách hàng</h4>
        </div>
        <div class="card-body">
            <p><strong>Mã khách hàng:</strong> <span>${customer.id}</span></p>
            <p><strong>Tên:</strong> <span>${customer.fullName}</span></p>
            <p><strong>Email:</strong> <span>${customer.email}</span></p>
            <p><strong>Giới tính:</strong> <span>${customer.gender}</span></p>
            <p><strong>Số điện thoại:</strong> <span>${customer.phone}</span></p>
            <p><strong>Địa chỉ:</strong> <span>${customer.address}</span></p>
            <p><strong>Trạng thái:</strong> <span>${customer.active ? 'Đang hoạt động' : 'Bị khóa'}</span></p>
        </div>
    </div>

    <!-- Lock/Unlock Buttons -->
    <div class="mt-3">
        <c:if test="${customer.active}">
            <a href="#" class="btn btn-danger custom-hover"
               onclick="return confirm('Bạn có chắc chắn muốn khóa tài khoản này?');">Khóa tài khoản</a>
        </c:if>
        <c:if test="${!customer.active}">
            <a href="#" class="btn btn-custom-gray"
               onclick="return confirm('Bạn có chắc chắn muốn mở khóa tài khoản này?');">Mở khóa tài khoản</a>
        </c:if>
    </div>

    <!-- Order History -->
    <div class="card mt-4">
        <div class="card-header">
            <h4>Lịch sử mua hàng</h4>
        </div>
        <div class="card-body">
            <table class="table table-bordered table-striped text-center">
                <thead>
                    <tr>
                        <th scope="col">STT</th>
                        <th scope="col">Mã đơn hàng</th>
                        <th scope="col">Ngày đặt</th>
                        <th scope="col">Trạng thái</th>
                        <th scope="col">Tổng tiền</th>
                        <th scope="col">Chi tiết</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="order" items="${orderList}" varStatus="status">
                        <tr>
                            <td>${status.index + 1}</td>
                            <td>${order.orderId}</td>
                            <td>${order.orderDate}</td>
                            <td>${order.shippingStatus}</td>
                            <td>${order.totalAmount}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/admin/orders/${order.orderId}" class="btn btn-primary">Chi tiết</a>
                            </td>
                        </tr>
                    </c:forEach>
                    <c:if test="${empty orderList}">
                        <tr>
                            <td colspan="6" class="text-center">Không có đơn hàng nào!</td>
                        </tr>
                    </c:if>
                </tbody>
            </table>

            <!-- Pagination -->
            <nav>
                <ul class="pagination justify-content-center">
                    <c:if test="${currentPage > 0}">
                        <li class="page-item">
                            <a class="page-link" href="?page=${currentPage - 1}">« Trước</a>
                        </li>
                    </c:if>
                    <c:forEach var="i" begin="0" end="${totalPages - 1}">
                        <li class="page-item ${i == currentPage ? 'active' : ''}">
                            <a class="page-link" href="?page=${i}">${i + 1}</a>
                        </li>
                    </c:forEach>
                    <c:if test="${currentPage < totalPages - 1}">
                        <li class="page-item">
                            <a class="page-link" href="?page=${currentPage + 1}">Sau »</a>
                        </li>
                    </c:if>
                </ul>
            </nav>
        </div>
    </div>
</div>
<!-- Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
