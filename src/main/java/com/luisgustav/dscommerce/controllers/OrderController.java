package com.luisgustav.dscommerce.controllers;

import com.luisgustav.dscommerce.dto.OrderDTO;
import com.luisgustav.dscommerce.dto.ProductDTO;
import com.luisgustav.dscommerce.dto.ProductMinDTO;
import com.luisgustav.dscommerce.services.OrderService;
import com.luisgustav.dscommerce.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping(value = "/orders")
public class OrderController {

      //Injecao de dependecia

      @Autowired
      private OrderService service;


       @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
       @GetMapping(value = "/{id}") //buscando os produtos por id
       public ResponseEntity<OrderDTO> findById(@PathVariable Long id) {
           OrderDTO dto = service.findById(id);
           return ResponseEntity.ok(dto);

      }


}
