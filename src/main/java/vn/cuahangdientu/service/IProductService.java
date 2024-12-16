package vn.cuahangdientu.service;

import java.util.List;

import vn.cuahangdientu.entity.Product;

public interface IProductService {

	// Phương thức lưu sản phẩm
	Product saveProduct(Product product);
//-------- thu hằng thêm
	void deleteProduct(Integer id_product);

	List<Product> getAllProducts();

	Product getProductById(Integer id_product);
	
	List<Product> searchProductsByName(String keyword);

}
