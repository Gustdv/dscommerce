package com.luisgustav.dscommerce.dto;



import com.luisgustav.dscommerce.entities.User;
import org.springframework.security.core.GrantedAuthority;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDTO {
  //Atributos

    private Long id;

    private String name;


    private String email;

    private String phone;

    private LocalDate BirthDate;



    private List<String> roles = new ArrayList<>();

    //Construtores


    public UserDTO(User entity) {
        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();
        phone = entity.getPhone();
        BirthDate = entity.getBirthDate();
        for (GrantedAuthority role : entity.getRoles()) {
            roles.add(role.getAuthority());
        }
    }

    //Getters e Setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDate getBirthDate() {
        return BirthDate;
    }

    public List<String> getRoles() {
        return roles;
    }
}
