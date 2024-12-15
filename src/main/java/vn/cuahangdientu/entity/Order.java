package vn.cuahangdientu.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Orders")
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_order;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user", nullable = false)
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_product", nullable = false)
	private Product product;

	@Column(name = "quantity", nullable = false)
	private Integer quantity;
	
	@Column(name = "creation_time", nullable = false) 
	@Temporal(TemporalType.TIMESTAMP) 
	private Date creationTime;
    
	@Enumerated(EnumType.STRING) 
    @Column(name = "status_order", nullable = false, length = 100)
    private OrderStatus statusOrder;
    
    @Column(name = "total")
    private Double total;
    
    
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OrderDetail> voucher;
	
	public Double calculateTotal() {
        return voucher.stream()
        		 .mapToDouble(OrderDetail::calculateDiscountedPrice)
                      .sum();
    }
	public void calculateAndSetTotal() {
        this.total = calculateTotal();
    }
}
