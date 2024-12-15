package vn.cuahangdientu.service;

import org.springframework.data.domain.Page;

import vn.cuahangdientu.entity.Order;

public interface IOrderService {
	Page<Order> getOrdersByUserId(Integer userId, int page, int size);
}
