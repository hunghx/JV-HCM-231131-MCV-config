package ra.mvcconfig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {
    @Autowired
    private ServletContext servletContext;

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file, Model model) {
        final String uploadAbsolute = "C:\\Users\\AD\\Desktop\\mvc-config\\src\\main\\webapp\\uploads";
        // laaysy vị trí thư mujc lưu trên server
        String uploadPath =servletContext.getRealPath("/uploads");
        File uploadFolder = new File(uploadPath);
        if (!uploadFolder.exists()) {
            uploadFolder.mkdirs();
        }

        String fileName = "/uploads/"+file.getOriginalFilename();
        // xử lí upload
        try {
            FileCopyUtils.copy(file.getBytes(),new File(uploadPath+File.separator+file.getOriginalFilename()));
            FileCopyUtils.copy(file.getBytes(),new File(uploadAbsolute+File.separator+file.getOriginalFilename()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        model.addAttribute("fileName", fileName);
        return  "image";

    }
}
