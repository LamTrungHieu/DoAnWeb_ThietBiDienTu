package vn.cuahangdientu.service;

import org.springframework.data.domain.Page;

import vn.cuahangdientu.entity.Order;

public interface IOrderService {
	Page<Order> getOrdersByUserId(Integer userId, int page, int size);
	
	Page<Order> getOrders(int page, int size);
	Page<Order> searchOrders(String status, int page, int size);
	Order findOrderById(Integer orderId);
	Order saveOrder(Order order);
	void deleteOrder(Integer orderId); 

}
