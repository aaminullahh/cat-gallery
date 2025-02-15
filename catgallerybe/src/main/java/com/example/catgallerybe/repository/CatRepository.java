package com.example.catgallerybe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catgallerybe.model.Cat;

public interface CatRepository extends JpaRepository<Cat, String> {}
