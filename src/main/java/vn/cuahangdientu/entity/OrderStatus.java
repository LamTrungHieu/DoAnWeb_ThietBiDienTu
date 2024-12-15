package vn.cuahangdientu.entity;

public enum OrderStatus {
	NEW("Đơn hàng mới"),
    CONFIRMED("Đã xác nhận"),
    SHIPPING("Đang giao"),
    DELIVERED("Đã giao"),
    CANCELED("Hủy"),
    RETURN_REFUND("Trả hàng - Hoàn tiền");
	private final String displayName;

    OrderStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
