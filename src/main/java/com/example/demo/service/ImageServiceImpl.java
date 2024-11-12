package com.example.demo.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.Chanson;
import com.example.demo.entities.Image;
import com.example.demo.repos.ChansonRepository;
import com.example.demo.repos.ImageRepository;

@Service
public class ImageServiceImpl implements ImageService{
 @Autowired
 ImageRepository imageRepository;
 @Autowired
ChansonService chansonService;
 @Autowired
ChansonRepository chansonRepository;
 @Override
 public Image uplaodImage(MultipartFile file) throws IOException {
 /*Ce code commenté est équivalent au code utilisant le design pattern Builder
 * Image image = new Image(null, file.getOriginalFilename(),
 file.getContentType(), file.getBytes(), null);
 return imageRepository.save(image);*/
 return imageRepository.save(Image.builder()
 .name(file.getOriginalFilename())
 .type(file.getContentType())
 .image(file.getBytes()).build() );
 }
 @Override
 public Image getImageDetails(Long id) throws IOException{
 final Optional<Image> dbImage = imageRepository.findById(id);
 return Image.builder()
 .idImage(dbImage.get().getIdImage())
 .name(dbImage.get().getName())
 .type(dbImage.get().getType())
 .image(dbImage.get().getImage()).build() ;
 }@Override
 public ResponseEntity<byte[]> getImage(Long id) throws IOException{
 final Optional<Image> dbImage = imageRepository.findById(id);
 return ResponseEntity
 .ok()
 .contentType(MediaType.valueOf(dbImage.get().getType()))
 .body(dbImage.get().getImage());
 }
 @Override
	public void deleteImage(Long id) {
		imageRepository.deleteById(id);
	}
 @Override
	public Image uploadImageChan(MultipartFile file, Long idChan) throws IOException  {
	Chanson p = new Chanson();
	p.setIdChanson(idChan);
	return imageRepository.save(Image.builder()
	 .name(file.getOriginalFilename())
	 .type(file.getContentType())
	 .image(file.getBytes())
	 .chanson(p).build() );
	}
 @Override
	public List<Image> getImagesParChan(Long prodId) {
	
	Chanson p = chansonRepository.findById(prodId).get();
	return p.getImages();
	}

}