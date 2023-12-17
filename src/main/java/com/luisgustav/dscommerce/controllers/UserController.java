package com.luisgustav.dscommerce.controllers;


import com.luisgustav.dscommerce.dto.UserDTO;
import com.luisgustav.dscommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(value = "/users")
public class UserController {

      //Injecao de dependecia

      @Autowired
      private UserService service;


       @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
       @GetMapping(value = "/me") //buscando user
       public ResponseEntity<UserDTO> getMe() {
           UserDTO dto = service.getMe();
           return ResponseEntity.ok(dto);

      }

}
