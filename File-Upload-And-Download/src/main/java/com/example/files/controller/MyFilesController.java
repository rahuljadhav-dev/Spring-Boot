package com.example.files.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.files.service.MyFileService;

@RestController
@RequestMapping("/files/api")
public class MyFilesController {
	@Autowired
	private MyFileService service;
	
	 // Upload File API
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        String message = service.uploadFile(file);
        return ResponseEntity.ok(message);
    }
    
    // Download File API
    @GetMapping("/download/{fileName}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileName) {
        return service.downloadFile(fileName);
    }
    @GetMapping("/msg")
    public String msg() {
    	return ("<h1>Welcome</h1>");
    	
    }

}
