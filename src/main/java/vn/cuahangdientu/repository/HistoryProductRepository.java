package vn.cuahangdientu.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.cuahangdientu.entity.HistoryProduct;
import vn.cuahangdientu.entity.Product;
import vn.cuahangdientu.entity.User;

public interface HistoryProductRepository extends JpaRepository<HistoryProduct, Integer> {
	// Các phương thức tìm kiếm tùy chỉnh nếu cần
    // Tìm tất cả các HistoryProduct theo user
    List<HistoryProduct> findByUser(User user);

    // Tìm kiếm lịch sử sản phẩm đã có trong bảng history_product
    Optional<HistoryProduct> findByUserAndProduct(User user, Product product);
}
