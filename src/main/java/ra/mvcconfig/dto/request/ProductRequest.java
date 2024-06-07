package ra.mvcconfig.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    // Các annotaion dựng ẵn
//    @NotNull // ko được null
//    @NotEmpty // ko được để trống (null) ,phải có chứa phàn tử
//    @NotBlank // kiểu chuỗi : ko null và ko đc ""

//    @Pattern()  // so khớp theo regex
//    @Email // email
//    @Size (min =  , max = ) // kích thước số phần tử của danh sách
//    @Min() // giá trị nhor nhất
//    @Max() // gia trị lớn nhất
private Integer id;
    @NotBlank(message = "Khong duoc de trong")
    @Pattern(regexp = "^\\w{6,}$", message = "ít nhất 6 kí tự, ko đc có kí đặc biệt")
    private String name;
    @NotNull
    @Min(value = 0)
    private Double price;
    @NotBlank
    private String description;
    @NotNull
    private MultipartFile file;
    @Min(value = 0, message = "ko duoc nhỏ hon 0")
    private Integer stock;
    //    @NotNull
    private Integer categoryId;
}
