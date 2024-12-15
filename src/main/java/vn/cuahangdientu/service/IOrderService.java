package vn.cuahangdientu.service;

import java.util.List;

import vn.cuahangdientu.entity.Order;
import vn.cuahangdientu.entity.Shop;
import vn.cuahangdientu.entity.User;

public interface IOrderService {
	String addOrder(Integer userId, Integer productId, Integer productColorId, Integer quantity);

    List<Order> getOrdersByUser(User user);

    List<Order> getOrdersByShop(Shop shop);

    Order save(Order order);

    Order findById(Integer id);
}
