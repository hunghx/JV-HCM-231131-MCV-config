package ra.mvcconfig.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
// ánh xạ với bảng nào tron db
@Table(name = "Product")
@Entity // đây là 1 thực thể ánh xạ
public class Product {
    @Id // khóa chính
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Double price;
    private String description;
    private String image ;
    private Integer stock;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "is_deleted")
    private Boolean isDeleted;
}
