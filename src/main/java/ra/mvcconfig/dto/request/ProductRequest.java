package ra.mvcconfig.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
@Getter
@Setter
public class ProductRequest {
    private Integer id;
    private String name;
    private Double price;
    private String description;
    private MultipartFile file ;
    private Integer stock;

}
