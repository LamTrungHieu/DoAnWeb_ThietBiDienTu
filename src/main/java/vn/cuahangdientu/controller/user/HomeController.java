package vn.cuahangdientu.controller.user;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import vn.cuahangdientu.entity.FollowShop;
import vn.cuahangdientu.entity.Order;
import vn.cuahangdientu.entity.Product;
import vn.cuahangdientu.repository.ProductRepository;
import vn.cuahangdientu.service.impl.FollowShopService;
import vn.cuahangdientu.service.impl.HistoryProductService;
import vn.cuahangdientu.service.impl.OrderService;

@Controller("userHomeController")
public class HomeController {
	@Autowired
	ProductRepository productRepository;
	@Autowired
	FollowShopService followShopService;
	@Autowired
	HistoryProductService historyProductService;
	@Autowired
	OrderService orderService;

	@GetMapping(value = {"/", "/user/home"})
	public String Home(Model model, Authentication authentication) {
		if (authentication != null) {
			model.addAttribute("username", authentication.getName()); // Lưu tên người dùng vào model
		}

		List<Product> products = productRepository.findAll();

		// Lấy 10 sản phẩm đầu tiên
		List<Product> products1 = products.stream().limit(10).collect(Collectors.toList());

		// Lấy 10 sản phẩm cuối cùng
		List<Product> products2 = products.size() > 10 ? products.subList(products.size() - 10, products.size()) : products;

		// Thêm vào model
		model.addAttribute("products1", products1);
		model.addAttribute("products2", products2);

		return "user/home";
	}


	@GetMapping("/user/follow-shop")
	public String followShop(HttpSession session, ModelMap model, Authentication authentication) {

		if (authentication != null) {
			model.addAttribute("username", authentication.getName()); // Lưu tên người dùng vào model
		}

		// Lấy thông tin người dùng từ session
		User user = (User) session.getAttribute("user");

		// Kiểm tra nếu người dùng chưa đăng nhập
		if (user == null) {
			return "redirect:/login"; // Redirect đến trang đăng nhập nếu chưa đăng nhập
		}
		// Lấy danh sách các shop mà người dùng đã follow
		List<FollowShop> followShops = followShopService.getShopsFollowedByUser(user.getId_user());

		model.addAttribute("followShops", followShops);
		return "user/follow-shop";
	}

	@GetMapping("/user/history")
	public String viewHistory(ModelMap model, HttpSession session, Authentication authentication) {

		if (authentication != null) {
			model.addAttribute("username", authentication.getName()); // Lưu tên người dùng vào model
		}

		// Lấy thông tin người dùng từ session
		User user = (User) session.getAttribute("user");

		// Kiểm tra nếu người dùng chưa đăng nhập
		if (user == null) {
			return "redirect:/login"; // Redirect đến trang đăng nhập nếu chưa đăng nhập
		}

		// Lấy các sản phẩm đã xem của người dùng
		List<Product> productsViewed = historyProductService.getProductsViewedByUser(user);

		// Thêm sản phẩm vào model
		model.addAttribute("productsViewed", productsViewed);

		return "user/product-history"; // Trả về view hiển thị sản phẩm đã xem
	}

	@GetMapping("/user/orders")
	public String listOrders(
			@RequestParam(value = "status", required = false) String status,
			@RequestParam(value = "sort", required = false) String sort,
			HttpSession session,
			Authentication authentication,
			Model model) {

		if (authentication != null) {
			model.addAttribute("username", authentication.getName()); // Lưu tên người dùng vào model
		}

		User user = (User) session.getAttribute("user");
		if (user == null) {
			return "redirect:/login";
		}

		List<Order> orders = orderService.getOrdersByUser(user);

		// Lọc theo trạng thái nếu có
		if (status != null && !status.isEmpty()) {
			orders = orders.stream()
					.filter(order -> status.contains(order.getStatusOrder()))
					.collect(Collectors.toList());
		}

		// Sắp xếp theo thời gian
		if ("newest".equals(sort)) {
			orders.sort((o1, o2) -> o2.getCreationTime().compareTo(o1.getCreationTime()));
		} else if ("oldest".equals(sort)) {
			orders.sort((o1, o2) -> o1.getCreationTime().compareTo(o2.getCreationTime()));
		}

		model.addAttribute("orders", orders);
		return "user/order-list"; // File JSP hiển thị danh sách
	}
}
