<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Chi tiết khách hàng</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <!-- Nút quay lại -->
    <a href="/admin/users" class="btn btn-secondary mb-4">Quay lại</a>

    <!-- Thông tin chi tiết khách hàng -->
    <h1 class="text-center mb-4">Chi tiết khách hàng</h1>
    <div class="card">
        <div class="card-body">
            <p><strong>ID:</strong> ${customer.id_user}</p>
            <p><strong>Họ tên:</strong> ${customer.fullName}</p>
            <p><strong>Email:</strong> ${customer.email}</p>
            <p><strong>Số điện thoại:</strong> ${customer.phone}</p>
        </div>
    </div>

    <!-- Danh sách đơn hàng -->
    <h3 class="mt-5">Danh sách đơn hàng</h3>
    <table class="table table-bordered table-striped text-center">
        <thead class="table-light">
        <tr>
            <th>Mã đơn hàng</th>
            <th>Ngày tạo</th>
            <th>Trạng thái</th>
            <th>Tổng tiền</th>
            <th>Hành động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="order" items="${orderList}">
            <tr>
                <td>${order.id_order}</td>
                <td>${order.creationTime}</td>
                <td>${order.statusOrder}</td>
                <td>${order.total}</td>
                <td>
                    <a href="/admin/orders/${order.id_order}" class="btn btn-primary btn-sm">Chi tiết</a>
                </td>
            </tr>
        </c:forEach>
        <c:if test="${empty orderList}">
            <tr>
                <td colspan="5" class="text-center">Không có đơn hàng nào!</td>
            </tr>
        </c:if>
        </tbody>
    </table>

    <!-- Phân trang -->
    <nav aria-label="Page navigation">
    <ul class="pagination justify-content-center">
        <c:if test="${currentPage > 0}">
            <li class="page-item">
                <a class="page-link" href="?page=${currentPage - 1}" aria-label="Trước">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
        </c:if>

        <c:if test="${totalPages > 0}">
            <c:forEach var="i" begin="0" end="${totalPages - 1}">
                <li class="page-item ${i == currentPage ? 'active' : ''}">
                    <a class="page-link" href="?page=${i}">${i + 1}</a>
                </li>
            </c:forEach>
        </c:if>

        <c:if test="${currentPage < totalPages - 1}">
            <li class="page-item">
                <a class="page-link" href="?page=${currentPage + 1}" aria-label="Sau">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </c:if>
    </ul>
</nav>

</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
