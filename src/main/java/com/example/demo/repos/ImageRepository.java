package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {

}