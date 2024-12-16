package vn.cuahangdientu.controller.admin;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import vn.cuahangdientu.entity.Product;
import vn.cuahangdientu.repository.ProductRepository;
import vn.cuahangdientu.service.IProductService;


	@Controller
public class ProductController {

	    private IProductService productService;

	    public ProductController(IProductService productService) {
	        this.productService = productService;
	    }


	    @GetMapping("admin/products")
	    public String listProducts(Model model) {
	        model.addAttribute("products", productService.getAllProducts());
	        return "admin/products/product-list";
	    }
	    // Xử lý thêm sản phẩm mới
	    @PostMapping("/products")
	    public String saveProduct(@ModelAttribute Product product) {
	        product.setUpdatedAt(LocalDateTime.now());
	        if (product.getCreatedAt() == null) {
	            product.setCreatedAt(LocalDateTime.now());
	        }
	        productService.saveProduct(product);
	        return "redirect:/admin/products";
	    }

		
		/*
		 * @GetMapping("/products/delete/{id}") public String
		 * deleteProduct(@PathVariable Long id) { productService.deleteProduct(id);
		 * return "redirect:/products"; }
		 */
	    @PostMapping("/delete/{id_product}")
	    public String deleteProduct(@PathVariable Integer id_product) {
	        productService.deleteProduct(id_product);
	        return "redirect:/admin/products";
	    }

	    @GetMapping("admin/products/product-form")
	    public String newProductForm(Model model) {
	        model.addAttribute("product", new Product());
	        return "admin/products/product-form";
	    }
	    // Hiển thị form sửa sản phẩm
	    @GetMapping("/edit/{id_product}")
	    public String editProductForm(@PathVariable Integer id_product, Model model) {
	        Product product = productService.getProductById(id_product);
	        if (product != null) {
	            model.addAttribute("product", product);
	            return "admin/products/product-form";
	        } else {
	            return "redirect:/admin/products";
	        }
	    }

	    // Xử lý cập nhật sản phẩm
	    @PostMapping("/update")
	    public String updateProduct(@ModelAttribute Product product) {
	        product.setUpdatedAt(LocalDateTime.now());
	        productService.saveProduct(product);
	        return "redirect:/products";
	    }
	    @Autowired
	    private ProductRepository productRepository;
	    
		/*
		 * @GetMapping("/search") public String searchProducts(@RequestParam("keyword")
		 * String keyword, Model model) { List<Product> products; if (keyword != null &&
		 * !keyword.isEmpty()) { products =
		 * productService.searchProductsByName(keyword); } else { products =
		 * productService.getAllProducts(); } model.addAttribute("products", products);
		 * return "admin/products/product-list"; }
		 */
	    // Hiển thị danh sách sản phẩm hoặc kết quả tìm kiếm
		/*
		 * @GetMapping("/products") public String listProducts(@RequestParam(value =
		 * "keyword", required = false) String keyword, Model model) { if (keyword !=
		 * null && !keyword.isEmpty()) { model.addAttribute("products",
		 * productService.searchProductsByName(keyword)); } else {
		 * model.addAttribute("products", productService.getAllProducts()); } return
		 * "redirect:/admin/products"; // Tên file JSP }
		 */
	    @GetMapping("/search")
	    public String searchProducts(@RequestParam("keyword") String keyword, Model model) {
	        List<Product> products = productService.searchProductsByName(keyword);
	        model.addAttribute("products", products);
	        model.addAttribute("keyword", keyword);
	        return "redirect:/products/search";
	    }

	    
	    
	    
		@Autowired
		private ProductRepository ProductRepository;
		
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        List<Product> products = ProductRepository.findAll();
	        request.setAttribute("products", products);
	        request.getRequestDispatcher("/product-list.jsp").forward(request, response);
	    }



	    @Transactional
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String name = request.getParameter("name");
	        String imageProduct = request.getParameter("imageProduct");
	        double price = Double.parseDouble(request.getParameter("price"));

	        Product product = new Product();
	        product.setName(name);
	        product.setImageProduct(imageProduct);
	        product.setPrice(price);

	        productRepository.save(product);

	        response.sendRedirect("/products");
	    }


	    
	}



