package com.luisgustav.dscommerce.dto;

import com.luisgustav.dscommerce.entities.Category;

public class CategoryDTO {
   //Atributos

    private Long id;
    private String name;

    //Construtor


    public CategoryDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryDTO(Category entity) {
        id = entity.getId();
        name = entity.getName();
    }

   //Getters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
