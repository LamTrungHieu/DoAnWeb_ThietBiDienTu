package vn.cuahangdientu.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import vn.cuahangdientu.entity.Product;
import vn.cuahangdientu.entity.Shop;


public interface ProductRepository extends JpaRepository<Product, Integer> {
	@Query("SELECT p FROM Product p WHERE p.name LIKE %:name%")
	Page<Product> findProductByNameContaining(@Param("name") String name, Pageable pageable);

	@Query("SELECT p FROM Product p WHERE p.shop.id_shop = :idShop")
	Page<Product> findProductsByShopId(@Param("idShop") Integer idShop, Pageable pageable);
	@Query("SELECT p FROM Product p " +
			"JOIN p.category c " +
			"JOIN p.shop s " +
			"WHERE (:categoryId IS NULL OR p.category.id_category = :categoryId) " +
			"AND (:keyword IS NULL OR p.name LIKE %:keyword%) " +
			"AND (:minPrice IS NULL OR p.price >= :minPrice) " +
			"AND (:maxPrice IS NULL OR p.price <= :maxPrice) ")
	Page<Product> searchProducts(@Param("categoryId") Integer categoryId,
								 @Param("keyword") String keyword,
								 @Param("minPrice") Double minPrice,
								 @Param("maxPrice") Double maxPrice,
								 Pageable pageable);

	List<Product> findByShop(Shop shop);
}
