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
@Table(name = "HistoryProduct")
@AllArgsConstructor
@NoArgsConstructor
public class HistoryProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_history;
	
	@ManyToOne
	@JoinColumn(name = "id_user", nullable = false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "id_product", nullable = false)
	private Product product;
}
