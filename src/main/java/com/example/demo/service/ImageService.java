package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.Image;

public interface ImageService {
 Image uplaodImage(MultipartFile file) throws IOException;
 Image getImageDetails(Long id) throws IOException;
 ResponseEntity<byte[]> getImage(Long id) throws IOException;
 void deleteImage(Long id) ;
 Image uploadImageChan(MultipartFile file,Long idChan)throws IOException;
 List<Image> getImagesParChan(Long chanId);
}