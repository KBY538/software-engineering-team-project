package com.smu.camping.util;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Repository
public class FileUtil {
    public static String saveFile(MultipartFile multipartFile) throws Exception{
        String oringinalFilename = multipartFile.getOriginalFilename();
        String savePath = "c:/tmp/" + oringinalFilename;

        File convFile = new File(savePath);
        multipartFile.transferTo(convFile);

        return savePath;
    }
}
