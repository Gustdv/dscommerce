package com.luisgustav.dscommerce.services;

import com.luisgustav.dscommerce.entities.User;
import com.luisgustav.dscommerce.services.exceptions.ForbiddenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService { //controle de acesso
    //Injeção de dependencia

    @Autowired
    private UserService userService;

     public void validateSelfOrAdmin(Long userId) {
         User me = userService.authenticated();
         if (!me.hasRole("ROLE_ADMIN") && !me.getId().equals(userId)) {
             throw new ForbiddenException("Acess denid");
         }
     }

}
