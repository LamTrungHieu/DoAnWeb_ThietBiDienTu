<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
    	      /* Reset */
		* {
		    margin: 0;
		    padding: 0;
		    box-sizing: border-box;
		}
		
		body {
		    font-family: Arial, sans-serif;
		    background-color: #f9f9f9;
		}
		
		/* Layout */
		.layout {
		    display: flex;
		}
		
		/* Sidebar */
		.sidebar {
		    width: 250px;
		    height: 100vh;
		    background-color: #FFB5C5;
		    color: white;
		    position: fixed;
		    top: 0;
		    left: 0;
		    display: flex;
		    flex-direction: column;
		    align-items: center;
		    padding: 20px 10px;
		    overflow-y: auto; /* Thanh cuộn nếu nội dung dài */
		}
		
		.sidebar h2 {
		    margin-bottom: 20px;
		}
		
		.sidebar-menu {
		    list-style: none;
		    width: 100%;
		}
		
		.sidebar-menu li {
		    margin: 10px 0;
		}
		
		.sidebar-menu li a {
		    text-decoration: none;
		    color: white;
		    display: block;
		    padding: 10px 15px;
		    border-radius: 5px;
		    transition: background-color 0.2s;
		}
		
		.sidebar-menu li a.active, .sidebar-menu li a:hover {
		    background-color: #FF82AB;
		}
		/* Main Content */
		.main-content {
		    margin-left: 250px;
		    padding: 20px;
		    width: calc(100% - 250px);
		    background-color: #f9f9f9;
		}
		
		.header {
		    display: flex;
		    justify-content: space-between;
		    align-items: center;
		    margin-bottom: 20px;
		}
		
		.search-bar {
		    width: 60%;
		    padding: 10px;
		    border: 1px solid #ccc;
		    border-radius: 5px;
		}
		
		 .categories {
		        display: flex;
		        gap: 10px;
		        margin-bottom: 20px;
		    }
		    .category {
		        background-color: #eae8fe;
		        padding: 10px 20px;
		        border-radius: 5px;
		        text-align: center;
		        flex: 1;
		        cursor: pointer;
		    }
		    .category:hover {
		        background-color: #d0ceff;
		    }
		
		/* Product Grid */
		.product-grid {
		    display: grid;
		    grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
		    gap: 20px;
		}
		
		.product-card {
		    background-color: white;
		    border: 1px solid #ddd;
		    border-radius: 10px;
		    text-align: center;
		    padding: 20px;
		    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
		    transition: transform 0.2s;
		}
		
		.product-card:hover {
		    transform: translateY(-5px);
		}
		
		.product-card img {
		    max-width: 100px;
		    margin-bottom: 10px;
		}
		
		.product-card h3 {
		    font-size: 1.2em;
		    margin-bottom: 10px;
		}
		
		.product-card p {
		    font-size: 1em;
		    color: #5b5fc7;
		    font-weight: bold;
		}

    </style>
</head>
<body>
<div class="layout">
        <!-- Sidebar -->
        <div class="sidebar">
            <h2>Admin</h2>
            <ul class="sidebar-menu">
                <li><a href="#" class="active">Home</a></li>
                <li><a href="#">Quản lý người dùng</a></li>
                <li><a href="products">Quản lý sản phẩm</a></li>
                <li><a href="#">Quản lý danh mục</a></li>
                <li><a href="#">Quản lý đơn hàng</a></li>
                <li><a href="#">Thống kê</a></li>
                <li><a href="#">Đăng xuất</a></li>
            </ul>
        </div>

</body>
</html>