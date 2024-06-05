package ra.mvcconfig.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import ra.mvcconfig.model.Category;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    private Integer id;
    private String name;
    private Double price;
    private String description;
    private MultipartFile file ;
    private Integer stock;
    private Integer categoryId;

}
