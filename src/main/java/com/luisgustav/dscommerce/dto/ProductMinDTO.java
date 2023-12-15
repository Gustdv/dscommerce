package com.luisgustav.dscommerce.dto;

import com.luisgustav.dscommerce.entities.Product;


public class ProductMinDTO {

    //Atributos
    private Long id;


    private String name;


    private String description;


    private Double price;

    private String imgUrl;

    //Construtor

    public ProductMinDTO(Long id, String name, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public ProductMinDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        price = entity.getPrice();
        imgUrl = entity.getImgUrl();
    }

    //Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public Double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
