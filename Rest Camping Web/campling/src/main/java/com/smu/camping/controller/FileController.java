package com.smu.camping.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class FileController {
    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        String oringinalFilename = multipartFile.getOriginalFilename();
        String savePath = "c:/tmp/" + oringinalFilename;

        File convFile = new File(savePath);
        multipartFile.transferTo(convFile);
        return savePath;
    }
}
