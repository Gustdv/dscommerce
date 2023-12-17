package com.luisgustav.dscommerce.services;

import com.luisgustav.dscommerce.dto.CategoryDTO;
import com.luisgustav.dscommerce.dto.ProductDTO;
import com.luisgustav.dscommerce.dto.ProductMinDTO;
import com.luisgustav.dscommerce.entities.Category;
import com.luisgustav.dscommerce.entities.Product;
import com.luisgustav.dscommerce.repositories.CategoryRepository;
import com.luisgustav.dscommerce.repositories.ProductRepository;
import com.luisgustav.dscommerce.services.exceptions.DatabaseException;
import com.luisgustav.dscommerce.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CategoryService {

    //Injecao de dependencua

    @Autowired
    private CategoryRepository repository;


    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() {
         List<Category> result = repository.findAll();
         return result.stream().map(x -> new CategoryDTO(x)).toList();

    }

}
