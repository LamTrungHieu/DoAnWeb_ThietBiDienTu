package vn.cuahangdientu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String password;
	private String email;
	private String roles;
	private Integer otp;
    private boolean enabled = false;
	
	@OneToOne(mappedBy = "user")
	private ForgotPassword forgotpassword;
}