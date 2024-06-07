package ra.mvcconfig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ra.mvcconfig.dao.IProductDao;
import ra.mvcconfig.dto.request.ProductRequest;
import ra.mvcconfig.dto.response.ProductResponse;
import ra.mvcconfig.model.Product;
import ra.mvcconfig.service.IProductService;
import sun.awt.image.ImageWatched;

import java.util.List;

@Controller
public class Tets {
    @Autowired
    private IProductService productService;

    @GetMapping
    public String test() {
        List<ProductResponse> products = productService.findAll();
//        ProductRequest p = new ProductRequest(null,"áodai",10.0,null,null,99,null);
//        productService.save(p);
        return "home";
    }
}
