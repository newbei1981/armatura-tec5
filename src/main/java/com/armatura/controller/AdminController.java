package com.armatura.controller;

import com.armatura.io.CreationDbFromFiles;
import com.armatura.repository.ValvesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Controller
public class AdminController {

    private final ValvesRepository valvesRepository;
    private final CreationDbFromFiles createDB;

    @Autowired
    AdminController(ValvesRepository valvesRepository, CreationDbFromFiles createDB){
        this.valvesRepository=valvesRepository;
        this.createDB=createDB;
    }

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/adminn")
    public String showPanel(){
        return "/admin";
    }

    @PostMapping("/adminn")
    public String someOperationWithData(
            @RequestParam String act,
            @RequestParam("file") MultipartFile file
            ) throws IOException{
        switch (act){
            case "Удалить базу" : valvesRepository.deleteAll();break;
            case "Создать базу" : createDB.createDB(); break;
            case "Добавить файл" :{
                String newFileName = uploadPath + file.getOriginalFilename();
                copyFileUsingStream(file.getInputStream(),newFileName);
             break;
           }
        }
        return "/admin";
    }

    private void copyFileUsingStream(InputStream is, String dest) throws IOException {
        OutputStream os = null;
        try {
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            if (os!=null) os.close();
        }
    }
}
