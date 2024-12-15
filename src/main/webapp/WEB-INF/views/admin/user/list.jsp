<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh sách người dùng</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Danh sách người dùng</h1>

        <!-- Tìm kiếm -->
        <form method="get" action="/admin/users">
            <input type="text" name="search" class="form-control mb-3" placeholder="Tìm kiếm người dùng" value="${searchTerm}">
            <button type="submit" class="btn btn-primary">Tìm kiếm</button>
        </form>

        <!-- Hiển thị danh sách người dùng -->
        <table class="table table-bordered mt-3">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Tên</th>
                    <th>Email</th>
                    <th>Phone</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="${users.content}">
                    <tr>
                        <td>${user.id_user}</td>
                        <td>${user.fullName}</td>
                        <td>${user.email}</td>
                        <td>${user.phone}</td>
                        <td style="text-align: center; vertical-align: middle;">
                                        <a href="/admin/customers/${user.id_user}" class="btn btn-danger custom-hover">Chi tiết</a>
                                    </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <!-- Phân trang -->
        <div class="pagination">
    <c:if test="${currentPage > 0}">
        <a href="?page=${currentPage - 1}&search=${searchTerm}" class="btn btn-secondary">Trước</a>
    </c:if>
    
    <c:forEach var="i" begin="0" end="${totalPages - 1}">
        <a href="?page=${i}&search=${searchTerm}" 
           class="btn ${i == currentPage ? 'btn-primary' : 'btn-outline-secondary'}">
            ${i + 1}
        </a>
    </c:forEach>

    <c:if test="${currentPage < totalPages - 1}">
        <a href="?page=${currentPage + 1}&search=${searchTerm}" class="btn btn-secondary">Sau</a>
    </c:if>
</div>

    </div>
</body>
</html>
