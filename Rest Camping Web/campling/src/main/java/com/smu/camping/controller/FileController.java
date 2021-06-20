package com.smu.camping.controller;

import com.smu.camping.util.FileUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {
    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile multipartFile) throws Exception{
        return FileUtil.saveFile(multipartFile);
    }
}
