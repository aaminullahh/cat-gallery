package com.example.catgallerybe.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cats")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cat {

    @Id
    private String id;
    private String url;
    private int width;
    private int height;

}
