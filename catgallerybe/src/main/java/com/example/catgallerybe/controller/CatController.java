package com.example.catgallerybe.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.catgallerybe.model.Cat;
import com.example.catgallerybe.service.CatService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/cats")
@AllArgsConstructor
public class CatController {

    private CatService catService;

    @GetMapping
    public List<Cat> getAllCats() {
        return catService.getAllCats();
    }

    @PostMapping
    public Cat createCat(@RequestBody Cat cat) {
        return catService.saveCat(cat);
    }

    @PostMapping("/bulk")
    public List<Cat> createMultipleCats(@RequestBody List<Cat> cats) {
        return catService.saveAllCats(cats);
    }

    @DeleteMapping("/{id}")
    public void deleteCat(@PathVariable String id) {
        catService.deleteCat(id);
    }

    @PostMapping("/upload")
    public String uploadCatImage(@RequestParam("file") MultipartFile file) throws IOException {
        return catService.uploadImage(file);
    }

}
