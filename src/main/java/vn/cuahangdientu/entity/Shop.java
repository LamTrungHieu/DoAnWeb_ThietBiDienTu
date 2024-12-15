package vn.cuahangdientu.entity;

import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Table(name = "Shops")
@AllArgsConstructor
@NoArgsConstructor
public class Shop {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_shop;
	
	@OneToOne
	@JoinColumn(name = "id_vendor", nullable = false)
	private User vendor;
	
	@Column(name = "name_shop", length = 100, nullable = false)
	private String name;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "sign_up_date", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date signUpDate;
	
	@Column(name = "address", length = 250, nullable = false)
	private String address;
	
	@Column(name = "introduce", columnDefinition = "TEXT") 
	private String introduce;
	
	@Column(name = "image", length = 500)
	private String image;
}

