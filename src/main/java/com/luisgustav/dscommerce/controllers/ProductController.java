package com.luisgustav.dscommerce.controllers;

import com.luisgustav.dscommerce.dto.ProductDTO;

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
import java.util.List;


@RestController
@RequestMapping(value = "/products")
public class ProductController {

      //Injecao de dependecia

      @Autowired
      private ProductService service;


       @GetMapping(value = "/{id}") //buscando os produtos por id
       public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
           ProductDTO dto = service.findById(id);
           return ResponseEntity.ok(dto);

      }

       @GetMapping
       public ResponseEntity<Page<ProductDTO>> findAll(@RequestParam(name = "name", defaultValue = "") String name, Pageable pageable) { //buscando os produtos por paginacao
        Page<ProductDTO> dto = service.findAll(name,pageable);
        return ResponseEntity.ok(dto);
      }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<ProductDTO> insert(@Valid @RequestBody ProductDTO dto) { //inserindo um novo produto
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);

       }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PutMapping(value = "/{id}") //Atualizando o produto
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @Valid @RequestBody ProductDTO dto) {
         dto = service.update(id, dto);
         return ResponseEntity.ok(dto);

    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @DeleteMapping (value = "/{id}") //Atualizando o produto
    public ResponseEntity<Void>  delete(@PathVariable Long id) {
           service.delete(id);
           return ResponseEntity.noContent().build();
    }

}
