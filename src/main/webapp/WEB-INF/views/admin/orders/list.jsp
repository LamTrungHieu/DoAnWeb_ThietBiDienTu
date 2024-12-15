<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh sách đơn hàng</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <!-- Tiêu đề -->
    <h1 class="text-center mb-4">Danh sách đơn hàng</h1>

    <!-- Tìm kiếm đơn hàng -->
    <form class="d-flex mb-4" action="/admin/orders/search" method="get">
        <input class="form-control me-2" type="search" name="status" placeholder="Nhập trạng thái đơn hàng" value="${searchTerm}">
        <button class="btn btn-primary" type="submit">Tìm kiếm</button>
    </form>

    <!-- Bảng danh sách đơn hàng -->
    <table class="table table-bordered table-striped text-center">
        <thead class="table-primary">
        <tr>
            
            <th>Mã đơn hàng</th>
            <th>Người dùng</th>
            <th>Trạng thái</th>
            <th>Tổng tiền</th>
            <th>Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="order" items="${orderList}">
            <tr>
                <td>${order.id_order}</td>
                <td>${order.user.fullName}</td>
                <td>${order.statusOrder.displayName}</td>
                <td>${order.total}</td>
                <td>
                    <a href="/admin/orders/${order.id_order}" class="btn btn-primary btn-sm me-2">Chi tiết</a>
                    <form action="/admin/orders/delete/${order.id_order}" method="post" style="display:inline;">
                        <button type="submit" class="btn btn-danger btn-sm">Xóa</button>
                    </form>
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

    <!-- Phân trang -->
    <nav>
        <ul class="pagination justify-content-center">
            <c:if test="${totalPages > 0}">
                <c:if test="${currentPage > 0}">
                    <li class="page-item">
                        <a class="page-link" href="?page=${currentPage - 1}&status=${searchTerm}">Trước</a>
                    </li>
                </c:if>
                <c:forEach var="i" begin="0" end="${totalPages - 1}">
                    <li class="page-item ${i == currentPage ? 'active' : ''}">
                        <a class="page-link" href="?page=${i}&status=${searchTerm}">${i + 1}</a>
                    </li>
                </c:forEach>
                <c:if test="${currentPage < totalPages - 1}">
                    <li class="page-item">
                        <a class="page-link" href="?page=${currentPage + 1}&status=${searchTerm}">Sau</a>
                    </li>
                </c:if>
            </c:if>
        </ul>
    </nav>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
