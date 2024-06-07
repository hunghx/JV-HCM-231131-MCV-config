package ra.mvcconfig.service;

import ra.mvcconfig.dto.request.ProductRequest;
import ra.mvcconfig.dto.response.ProductResponse;
import ra.mvcconfig.model.Product;

import java.util.List;

public interface IProductService {
    List<ProductResponse> findAll();
    List<Product> findByPagination(Integer page ,Integer limit);
    List<ProductResponse> searchByName(String keyword);
    ProductResponse findById(Integer id);
    void save(ProductRequest request);  // vừa thêm moi vưa cap nhap
    void deleteById(Integer id);
    long getTotalsElement();
    boolean existByName(String name);
}
