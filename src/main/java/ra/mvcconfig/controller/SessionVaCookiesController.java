package ra.mvcconfig.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import ra.mvcconfig.model.Product;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.HttpCookie;

@Controller

public class SessionVaCookiesController {
//    @Autowired
//    HttpSession session;
    // Session --Server- Storage - phụ thuộc trình duyệt
    @GetMapping("/session")
    // httpServletRequest
    public String session(HttpSession session){
        // lấy ra từ request
//        HttpSession session = request.getSession();
        // lưu thng tin vào session

        session.setAttribute("product",new Product(1,"hfd",12.4,null,null,null,null,null,null,null));
        return "home";
    }

    // Cookie - Storage - 2kb - tự động thêm vào request khi gửi lên
    @GetMapping("/cookie")
    // HttpServletResponse
    public String cookies(@CookieValue(value = "count",defaultValue = "0") Integer count,HttpSession session, HttpServletResponse response, Model model){
        Product p = (Product) session.getAttribute("product");
       // tạo 1 cookie
        Cookie cookie = new Cookie("name","NguyenvanA");
        cookie.setMaxAge(60); // seconds

        response.addCookie(cookie);


        // đếm số lần truy cập
        count += 1;
        Cookie cookie1 = new Cookie("count",count.toString());
        response.addCookie(cookie1);
        model.addAttribute("count",count);
        return "home";
    }

    @GetMapping("/get-cookie")
    public String get(@CookieValue(value = "name" ) String value){
        System.out.println(value);
        return "home";
    }

}
