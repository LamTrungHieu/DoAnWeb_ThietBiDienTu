// Add any additional JavaScript functionality if needed
document.addEventListener('DOMContentLoaded', function() {
    // Slide in the "Cosmetics" text from the position of the logo
    const nameLabel = document.getElementById('name');
    nameLabel.style.opacity = '1';
});
// Hàm để mở sidebar giỏ hàng và tải dữ liệu giỏ hàng
function openNav() {
    // Lấy userId từ session hoặc từ đâu đó
    const userId = document.getElementById("userId-cart").value; // Giả sử bạn lưu userId trong input ẩn

    // Gửi yêu cầu GET để lấy giỏ hàng của người dùng
    fetch(`/api/cart/user/${userId}`)
        .then(response => {
            if (!response.ok) {
                throw new Error("Failed to fetch cart items");
            }
            return response.json();
        })
        .then(data => {
            console.log("Dữ liệu giỏ hàng nhận được:", data);  // Kiểm tra cấu trúc dữ liệu
            loadShoppingCart(data.items);  // Sử dụng data.items nếu dữ liệu trả về có thuộc tính items
        })
        .catch(error => {
            console.error("Lỗi khi tải giỏ hàng:", error);
        });

    // Hiển thị sidebar giỏ hàng
    document.getElementById("shoppingNavbar").style.width = "300px"; // Mở sidebar
}

// Hàm đóng sidebar giỏ hàng
function closeNav() {
    document.getElementById("shoppingNavbar").style.width = "0"; // Ẩn sidebar
}

// Hàm để hiển thị sản phẩm trong giỏ hàng
function loadShoppingCart(items) {
    const cartItemsBody = document.getElementById("cart-items-body");
    const shoppingNavbar = document.getElementById("shoppingNavbar");
    const userId = document.getElementById("userId-cart").value; // Lấy userId từ input ẩn

    if (!cartItemsBody) {
        console.error("Không tìm thấy phần tử cart-items-body.");
        return;
    }

    cartItemsBody.innerHTML = ""; // Xóa nội dung cũ

    if (items.length === 0) {
        cartItemsBody.innerHTML = "<tr><td colspan='2'>Giỏ hàng của bạn trống.</td></tr>";
    } else {
        items.forEach(item => {
            const row = document.createElement("tr");

            row.innerHTML = `
                <td class="product-image">
                    <img src="${item.productImage}" alt="${item.productName}" class="product-image" />
                </td>
                <td class="product-details">
                    <div class="product-name">
                        ${item.productName}
                        <button class="delete-btn" onclick="deleteCartItem(${userId}, ${item.productId})">Xóa</button>
                    </div>
                    <div class="product-price-quantity">
                        <span class="product-quantity">Số lượng: ${item.shoppingCartQuantity}</span>
                        <span class="product-price">Giá: ${item.productPrice} VNĐ</span>
                        <span class="product-total">Tổng: ${item.shoppingCartQuantity * item.productPrice} VNĐ</span>
                    </div>
                </td>
            `;
            cartItemsBody.appendChild(row);
        });
    }

    // Thêm nút "Xem giỏ hàng" dưới bảng
    const viewCartButton = document.createElement("div");
    viewCartButton.classList.add("view-cart-button-container");
    viewCartButton.innerHTML = `
        <button class="view-cart-button" onclick="redirectToCart(${userId})">Xem giỏ hàng</button>
    `;
    shoppingNavbar.appendChild(viewCartButton);
}

// Hàm để xóa sản phẩm khỏi giỏ hàng
function deleteCartItem(userId, productId) {
    fetch(`/api/delete-cart/${userId}&${productId}`, {
        method: "POST"
    })
        .then(response => {
            if (!response.ok) {
                throw new Error("Không thể xóa sản phẩm.");
            }
            return response.text(); // Lấy phản hồi dạng text thay vì JSON
        })
        .then(data => {
            console.log("Xóa thành công:", data);
            alert(data); // Hiển thị thông báo từ server
            // Tải lại giỏ hàng hoặc cập nhật giao diện
            loadShoppingCart(data);
        })
        .catch(error => {
            console.error("Lỗi khi xóa sản phẩm:", error);
        });
}
function redirectToCart(userId) {
    window.location.href = `/ShoppingCart/${userId}`;
}