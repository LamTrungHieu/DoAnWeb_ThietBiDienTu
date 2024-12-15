package vn.cuahangdientu.service;

import java.util.List;

import vn.cuahangdientu.entity.Product;
import vn.cuahangdientu.entity.User;

public interface IHistoryProductService {
	List<Product> getProductsViewedByUser(User user);
}
