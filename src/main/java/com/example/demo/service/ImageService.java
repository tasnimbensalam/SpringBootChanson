package com.example.demo.service;

import java.io.IOException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.Image;

public interface ImageService {
 Image uplaodImage(MultipartFile file) throws IOException;
 Image getImageDetails(Long id) throws IOException;
 ResponseEntity<byte[]> getImage(Long id) throws IOException;
 void deleteImage(Long id) ;
}