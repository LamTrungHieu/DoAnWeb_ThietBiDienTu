package vn.cuahangdientu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import vn.cuahangdientu.entity.Order;
import vn.cuahangdientu.entity.OrderDetail;
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

	@Override
	public Page<Order> getOrders(int page, int size) {
		Page<Order> ordersPage = orderRepository.findAll(PageRequest.of(page, size));

	    // Tính tổng tiền cho từng đơn hàng
		 ordersPage.getContent().forEach(order -> {
		        order.calculateAndSetTotal();
		        saveOrder(order);
		    });
	    return ordersPage;
	}

	@Override
	public Page<Order> searchOrders(String status, int page, int size) {
		 return orderRepository.findByStatusOrderContaining(status, PageRequest.of(page, size));
	}

	@Override
	public Order findOrderById(Integer orderId) {
		return orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy đơn hàng với ID: " + orderId));
	}

	@Override
	public Order saveOrder(Order order) {
		order.calculateAndSetTotal();

	    // Lưu vào cơ sở dữ liệu
	    return orderRepository.save(order);
	}

	@Override
	public void deleteOrder(Integer orderId) {
		if (orderRepository.existsById(orderId)) {
            orderRepository.deleteById(orderId);
        } else {
            throw new RuntimeException("Không thể xóa. Không tìm thấy đơn hàng với ID: " + orderId);
        }
    }
	
	
	
	

}
