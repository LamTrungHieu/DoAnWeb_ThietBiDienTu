package vn.cuahangdientu.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Products")
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_product;
	
	@Column(name = "name_product", length = 100, nullable = false)
	private String name;
	
	
	@ManyToOne
	@JoinColumn(name = "id_category", nullable = false)
	private Category category;
	
	@Column(name = "price", nullable = false)
	private Double price;
	
	@Column(name = "quantity", nullable = false)
	private Integer quantity;
	
	@Column(name = "status_product", nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
	private boolean status_product;

}
