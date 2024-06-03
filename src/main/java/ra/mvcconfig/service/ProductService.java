package ra.mvcconfig.service;

import org.springframework.stereotype.Service;
import ra.mvcconfig.model.Product;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    List<Product> products = new ArrayList<>();
}
