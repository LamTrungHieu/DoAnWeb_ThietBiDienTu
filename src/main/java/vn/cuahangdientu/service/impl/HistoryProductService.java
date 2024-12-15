package vn.cuahangdientu.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import vn.cuahangdientu.entity.HistoryProduct;
import vn.cuahangdientu.entity.Product;
import vn.cuahangdientu.entity.User;
import vn.cuahangdientu.repository.HistoryProductRepository;
import vn.cuahangdientu.service.IHistoryProductService;

public class HistoryProductService implements IHistoryProductService {
	@Autowired
    private HistoryProductRepository historyProductRepository;
    @Autowired
    private ProductService productService; // Để lấy thông tin sản phẩm nếu cần

    @Override
    public List<Product> getProductsViewedByUser(User user) {
        // Lấy danh sách HistoryProduct theo user
        List<HistoryProduct> historyProducts = historyProductRepository.findByUser(user);

        // Lấy danh sách sản phẩm tương ứng
        List<Product> products = new ArrayList<>();
        for (HistoryProduct historyProduct : historyProducts) {
            products.add(historyProduct.getProduct());
        }
        return products;
    }

    public void saveHistoryProduct(HistoryProduct historyProduct) {
        // Kiểm tra xem bản ghi đã tồn tại chưa
        Optional<HistoryProduct> existingHistory = historyProductRepository.findByUserAndProduct(
                historyProduct.getUser(), historyProduct.getProduct());

        // Nếu bản ghi đã tồn tại, không lưu lại
        if (existingHistory.isPresent()) {
            System.out.println("This product has already been viewed by the user.");
        } else {
            // Nếu chưa có bản ghi, thực hiện lưu mới
            historyProductRepository.save(historyProduct);
            System.out.println("Product history saved successfully.");
        }
    }
}
