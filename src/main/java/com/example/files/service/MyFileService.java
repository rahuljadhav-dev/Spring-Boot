package com.example.files.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.files.model.MyFiles;
import com.example.files.repository.FileRepo;

@Service
public class MyFileService {
	@Autowired
	private FileRepo fileRepo;

	   // Upload File Method
    public String uploadFile(MultipartFile file) throws IOException {
        MyFiles fileEntity = new MyFiles(
                file.getOriginalFilename(),
                file.getContentType(),
                file.getBytes()
        );
        fileRepo.save(fileEntity);
        return "File uploaded successfully: " + file.getOriginalFilename();
    }
    
    // Download File Method
    public ResponseEntity<ByteArrayResource> downloadFile(String fileName) {
        Optional<MyFiles> fileOptional = fileRepo.findByFileName(fileName);

        if (fileOptional.isPresent()) {
            MyFiles file = fileOptional.get();
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFileName() + "\"")
                    .body(new ByteArrayResource(file.getData()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    


}
