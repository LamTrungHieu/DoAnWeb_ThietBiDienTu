package vn.cuahangdientu.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Table(name = "Users")
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_user;
	
	@Column(name = "username", length = 50, nullable = false, unique = true)
	private String username;
	
	@Column(name = "password_user", length = 200, nullable = false)
	private String password;
	
	@Column(name = "email", length = 150, nullable = false)
	private String email;
	
	@Column(name = "phone", length = 10, nullable = false)
	private String phone;
	
	@Column(name = "full_name", length = 100, nullable = false)
	private String fullName;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "sign_up_date", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date signUpDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "birth_date", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	
	@Column(name = "address", length = 250)
	private String address;
	
	@Column(name = "role_user", length = 20, nullable = false)
	private String role;
	
	@Column(name = "image", length = 500)
	private String image;
	
	@Column(name = "status_user", nullable = false)
	private Integer status;
}
