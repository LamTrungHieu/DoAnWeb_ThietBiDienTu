package vn.cuahangdientu.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.cuahangdientu.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByEmail(String email);

	Optional<User> findByUsername(String username);
	List<User> findAllByRole(String role);
	List<User> findAll();
	@Query("""
		select u from User u where u.username = :name or u.email = :name
	""")
	Optional<User> findByUsernameOrEmail(@Param("name") String name);

	@Modifying
	@Transactional
	@Query("""
    UPDATE User u 
    SET u.fullName = :fullName, u.phone = :phone, u.role = :role, u.address = :address, u.status = :status 
    WHERE u.email = :email
""")
	void updateUserByEmail(
			@Param("email") String email,
			@Param("fullName") String fullName,
			@Param("phone") String phone,
			@Param("role") String role,
			@Param("address") String address,
			@Param("status") int status
	);
	// Tìm kiếm user theo tên hoặc email, phân trang
    Page<User> findByFullNameContainingOrEmailContaining(String fullName, String email, Pageable pageable);
    Optional<User> findById(Integer id);
}