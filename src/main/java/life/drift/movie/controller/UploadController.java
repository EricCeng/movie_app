package life.drift.movie.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@RestController
public class UploadController {

    @GetMapping("/upload")
    public String upload(){
        return "/upload";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("avatar_url")MultipartFile file){

        if (file != null && file.getOriginalFilename() != null){
            //获取文件拓展名
            String originalFilename = file.getOriginalFilename();
            String fileExtendName = originalFilename.substring(originalFilename.lastIndexOf("."));
            //重新生成唯一的文件名
            String newFileName = UUID.randomUUID().toString();
        }

        return "/upload";
    }
}
