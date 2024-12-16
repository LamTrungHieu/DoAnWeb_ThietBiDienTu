package vn.cuahangdientu.repository;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.cuahangdientu.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByNameContainingIgnoreCase(String keyword); 
	 // Tìm kiếm sản phẩm theo tên (case-insensitive)
  

}