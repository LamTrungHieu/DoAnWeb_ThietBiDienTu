package vn.cuahangdientu.entity;

public enum VoucherType {
    PERCENTAGE(1, "Phần trăm"),
    FIXED_AMOUNT(2, "Số tiền cố định");

    private final int value;
    private final String displayName;

    VoucherType(int value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }

    public int getValue() {
        return value;
    }

    public String getDisplayName() {
        return displayName;
    }
}

