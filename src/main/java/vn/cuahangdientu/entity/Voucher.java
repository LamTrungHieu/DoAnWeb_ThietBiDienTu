package vn.cuahangdientu.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Vouchers")
@AllArgsConstructor
@NoArgsConstructor
public class Voucher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_voucher;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_shop")
	private Shop shop;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_category")
	private Category category;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_product")
	private Product product;
	
	@Column(name = "type_voucher", nullable = false)
	private Integer type;
	
	@Column(name = "start_time", nullable = false) 
	@Temporal(TemporalType.TIMESTAMP) 
	private Date startTime;
	
	@Column(name = "end_time", nullable = false) 
	@Temporal(TemporalType.TIMESTAMP) 
	private Date endTime;
	
	@Column(name = "value_voucher", nullable = false)
	private Double value;
}
