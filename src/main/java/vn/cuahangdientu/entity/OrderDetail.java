package vn.cuahangdientu.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "OrderDetail")
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_order_detail;
	
	@ManyToOne
	@JoinColumn(name = "id_order", nullable = false)
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "id_voucher")
	private Voucher voucher;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_product", nullable = false)
    private Product product;

 
    
	public Double calculateDiscountedPrice() {
        Double price = product.getPrice() * product.getQuantity(); // Giá ban đầu
        if (voucher != null) { // Kiểm tra nếu có mã giảm giá
            if (voucher.getType() == VoucherType.PERCENTAGE) {
                price -= price * voucher.getValue() / 100; // Giảm giá theo phần trăm
            } else if (voucher.getType() == VoucherType.FIXED_AMOUNT) {
                price -= voucher.getValue(); // Giảm giá cố định
            }
        }
        return Math.max(price, 0); // Đảm bảo giá không âm
    }
   
    



}
