package com.syscall.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by harley on 19/06/2017.
 */
@Service
public class UploadService {



    public  String  process(MultipartFile file) {

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(System.getProperty("user.dir")
                + File.separator + "src"+ File.separator +"main" + File.separator + "resources" + File.separator +
                "static"+ File.separator + "assets" + File.separator + "img" + File.separator + "users"+File.separator
                + file.getOriginalFilename());
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return !file.getOriginalFilename().isEmpty() ? file.getOriginalFilename() : "" ;
    }

}
