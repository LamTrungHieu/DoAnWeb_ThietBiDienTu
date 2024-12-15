package vn.cuahangdientu.entity;

import jakarta.persistence.Entity;
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
	@JoinColumn(name = "id_voucher", nullable = false)
	private Voucher voucher;
}
