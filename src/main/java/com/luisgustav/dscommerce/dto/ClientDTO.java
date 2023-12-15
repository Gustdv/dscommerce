package com.luisgustav.dscommerce.dto;

import com.luisgustav.dscommerce.entities.User;

public class ClientDTO {
  //Atributos

    private  Long id;
    private String name;

    //Construtor


    public ClientDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ClientDTO(User entity) {
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
