package vn.cuahangdientu.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.cuahangdientu.entity.Order;
import vn.cuahangdientu.service.IOrderService;

@Controller
@RequestMapping("/admin/orders")
public class AdminOrderController {
	@Autowired
    private IOrderService orderService;
	@GetMapping
    public String listOrders(
    						@RequestParam(value = "page", defaultValue = "0") int page,
                             @RequestParam(value = "size", defaultValue = "10") int size,
                             Model model) {
        Page<Order> ordersPage = orderService.getOrders(page, size);
        
        model.addAttribute("orderList", ordersPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", ordersPage.getTotalPages());
        return "admin/orders/list";
    }

    // Xem chi tiết đơn hàng
    @GetMapping("/{id}")
    public String orderDetails(@PathVariable Integer id, Model model) {
        Order order = orderService.findOrderById(id);
        Double total = order.calculateTotal();

        // Thêm thông tin vào Model
        model.addAttribute("order", order);
        model.addAttribute("total", total);
        return "admin/orders/details";
    }

    // Tìm kiếm đơn hàng theo trạng thái
    @GetMapping("/search")
    public String searchOrders(@RequestParam("status") String status,
                               @RequestParam(value = "page", defaultValue = "0") int page,
                               @RequestParam(value = "size", defaultValue = "10") int size,
                               Model model) {
        Page<Order> ordersPage = orderService.searchOrders(status, page, size);

        model.addAttribute("orderList", ordersPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", ordersPage.getTotalPages());
        model.addAttribute("searchTerm", status);
        return "admin/orders/list";
    }

    // Xóa đơn hàng
    @PostMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Integer id) {
        orderService.deleteOrder(id);
        return "redirect:/admin/orders";
    }
}
