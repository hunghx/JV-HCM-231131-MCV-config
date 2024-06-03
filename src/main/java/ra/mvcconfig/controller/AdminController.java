package ra.mvcconfig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.mvcconfig.service.IProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private IProductService productService;
    @GetMapping
    public String admin() {
        return "admin/index"; // tên view
    }
    @GetMapping("/category")
    public String category() {
        return "admin/category";
    }
    @GetMapping("/product")  // prooduct list
    public String product(Model model) {
        model.addAttribute("products",productService.findAll());
        return "admin/product"; // tên view
    }
    @GetMapping("/user")
    public String user() {
        return "admin/user";
    }


    // product mananger

}
