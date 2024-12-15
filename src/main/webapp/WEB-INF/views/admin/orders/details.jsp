<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Chi tiết đơn hàng</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <!-- Nút quay lại -->
    <a href="/admin/orders" class="btn btn-secondary mb-4">Quay lại</a>

    <!-- Thông tin chi tiết đơn hàng -->
    <h1 class="text-center mb-4">Chi tiết đơn hàng</h1>
    <div class="card">
        <div class="card-body">
            <p><strong>Mã đơn hàng:</strong> ${order.id_order}</p>
            <p><strong>Người dùng:</strong> ${order.user.fullName}</p>
            <p><strong>Trạng thái:</strong> ${order.statusOrder}</p>
            <p><strong>Tổng tiền:</strong> ${order.total}</p>
            <p><strong>Ngày tạo:</strong> ${order.creationTime}</p>
        </div>
    </div>

    <!-- Bảng chi tiết sản phẩm trong đơn hàng -->
    <h3 class="mt-5">Chi tiết sản phẩm</h3>
    <table class="table table-bordered table-striped text-center">
        <thead class="table-light">
        <tr>
            <th>Mã sản phẩm</th>
            <th>Tên sản phẩm</th>
            <th>Số lượng</th>
            <th>Giá gốc</th>
            <th>Voucher</th>
            <th>Giá đã giảm</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${order.voucher}">
            <tr>
                <td>${item.product.id_product}</td>
                <td>${item.product.name}</td>
                <td>${item.product.quantity}</td>
                <td>${item.calculateDiscountedPrice()}</td>
		<td>
			<c:choose>
			    <c:when test="${item.voucher.type == 'PERCENTAGE'}">${item.voucher.value}%</c:when>
			    <c:when test="${item.voucher.type == 'FIXED_AMOUNT'}">-${item.voucher.value}</c:when>
			    <c:otherwise>Không có</c:otherwise>
			 </c:choose>
			</td>
                <td>${item.calculateDiscountedPrice()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
