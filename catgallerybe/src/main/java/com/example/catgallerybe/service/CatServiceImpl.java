package com.example.catgallerybe.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.catgallerybe.model.Cat;
import com.example.catgallerybe.repository.CatRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CatServiceImpl implements CatService {

    private CatRepository catRepository;
    private static final String UPLOAD_DIR = "uploads/";

    @Override
    public List<Cat> getAllCats() {
        return catRepository.findAll();
    }

    @Override
    public Cat saveCat(Cat cat) {
        return catRepository.save(cat);
    }

    @Override
    public List<Cat> saveAllCats(List<Cat> cats) {
        return catRepository.saveAll(cats);
    }

    @Override
    public void deleteCat(String id) {
        catRepository.deleteById(id);
    }

    @Override
    public void uploadImage(MultipartFile file) throws IOException {
        String fileName = UUID.randomUUID().toString();
        Path filePath = Paths.get(UPLOAD_DIR + fileName + ".jpg");
        Files.createDirectories(filePath.getParent());
        Files.write(filePath, file.getBytes());
        
        final Cat newCat = new Cat();
        newCat.setId(fileName);
        newCat.setWidth(500);
        newCat.setHeight(500);
        newCat.setUrl("http://localhost:8080/uploads/" + fileName + ".jpg");

        catRepository.save(newCat);
    }

}
