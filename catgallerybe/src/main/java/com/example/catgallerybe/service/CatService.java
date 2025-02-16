package com.example.catgallerybe.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.catgallerybe.model.Cat;

public interface CatService {

    public List<Cat> getAllCats();

    public Cat saveCat(Cat cat);

    public List<Cat> saveAllCats(List<Cat> cats);

    public void deleteCat(String id);

    public void uploadImage(MultipartFile file) throws IOException;
    
}
