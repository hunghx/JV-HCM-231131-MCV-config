package ra.mvcconfig.model;

import lombok.*;
import org.springframework.stereotype.Service;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Product {
    private Integer id;
    private String name;
    private Double price;
    private String description;
    private String image ;
    private Integer stock;
    private Date createdAt;
    private Boolean isDeleted;
}
