package vn.cuahangdientu.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @GetMapping("/admin/homeAd")
    public String adminHome() {
        return "admin/homeAd"; // Tên file JSP (không cần đuôi .jsp)
    }
  
   
}
