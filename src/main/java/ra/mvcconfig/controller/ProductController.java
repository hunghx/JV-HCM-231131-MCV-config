package ra.mvcconfig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ra.mvcconfig.model.Product;
import ra.mvcconfig.service.ProductService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping({"/product"})
public class ProductController {
    @Autowired
    private ProductService productService ;

    //@GetMapping
    @RequestMapping(value = {"/list/{id}"}, method = RequestMethod.GET)
//    public String list(Model model){
    public ModelAndView list(@PathVariable("id") Integer id){
        System.out.println("id: "+id);
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("name","hung");
        return modelAndView;
    }
    // các annotation lấy tham số từ request
    //  @RequestParam : annhs xá tham số gửi trong request theo name
    //  @PathVariable : ánh xạ thành phần của đường dẫn
    //  @ModelAttribute : ánh xạ đối tượng model
    @PostMapping("/add")
    public  String add(@ModelAttribute Product product){
        System.out.println(product);
        return "home";
    }
}
