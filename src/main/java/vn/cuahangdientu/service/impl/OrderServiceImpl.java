package vn.cuahangdientu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import vn.cuahangdientu.entity.Order;
import vn.cuahangdientu.repository.OrderRepository;
import vn.cuahangdientu.service.IOrderService;
@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Page<Order> getOrdersByUserId(Integer userId, int page, int size) {
		 return orderRepository.findByUserId(userId, PageRequest.of(page, size));
	}

}
