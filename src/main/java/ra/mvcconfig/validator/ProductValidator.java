package ra.mvcconfig.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ra.mvcconfig.dto.request.ProductRequest;
import ra.mvcconfig.service.IProductService;

@Component
public class ProductValidator implements Validator {
    @Autowired
    private IProductService productService;
    @Override
    public boolean supports(Class<?> clazz) {
        return ProductRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductRequest p = (ProductRequest) target;
        if (productService.existByName(p.getName())){
            errors.rejectValue("name","ncjdhv","tên da tồn tại !");
        }
    }
}
