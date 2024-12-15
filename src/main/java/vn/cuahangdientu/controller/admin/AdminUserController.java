package vn.cuahangdientu.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import vn.cuahangdientu.entity.Order;
import vn.cuahangdientu.entity.User;
import vn.cuahangdientu.service.IOrderService;
import vn.cuahangdientu.service.IUserService;

@Controller
@RequestMapping("/admin/users")
public class AdminUserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IOrderService orderService;
    @GetMapping
    public String listUsers(@RequestParam(value = "search", required = false) String searchTerm,
                            @RequestParam(value = "page", defaultValue = "0") int page,
                            Model model, HttpSession session) {

        // Setting pagination with a page size of 10
        Pageable pageable = PageRequest.of(page, 10);
        Page<User> users;

        // If searchTerm is provided, search users
        if (searchTerm != null && !searchTerm.isEmpty()) {
            users = userService.searchUsers(searchTerm, pageable);
        } else {
            // Otherwise, get all users (paginated)
            users = userService.getUsers(pageable);
        }

        // Add attributes to the model for rendering in the view
        model.addAttribute("users", users);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", users.getTotalPages());
        model.addAttribute("searchTerm", searchTerm);

        // Return the view to display the users list
        return "admin/user/list";  // This should correspond to /WEB-INF/views/admin/user/list.jsp
    }
    @GetMapping("/{userId}")
    public String showCustomerDetails(@PathVariable("userId") Integer userId,
                                      @RequestParam(value = "page", defaultValue = "0") int page,
                                      @RequestParam(value = "size", defaultValue = "10") int size,
                                      Model model) {
        // Fetch user details
        User customer = userService.findById(userId);

        // Fetch paginated order history for this user
        Page<Order> ordersPage = orderService.getOrdersByUserId(userId, page, size);

        // Add data to the model
        model.addAttribute("customer", customer);
        model.addAttribute("orderList", ordersPage.getContent()); // Current page orders
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", ordersPage.getTotalPages());

        // Return the JSP page
        return "admin/user/customer-details";
    }
}
