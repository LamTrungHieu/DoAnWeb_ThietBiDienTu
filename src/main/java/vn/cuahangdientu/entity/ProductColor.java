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
@Table(name = "ProductColor")
@AllArgsConstructor
@NoArgsConstructor
public class ProductColor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_product_color;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_product", nullable = false)
	private Product product;
	
	@Column(name = "color", length = 100)
	private String color;
	 
	@Column(name = "image_product", length = 500, nullable = false)
	private String imageProduct;
}