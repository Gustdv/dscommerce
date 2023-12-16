package com.luisgustav.dscommerce.services;

import com.luisgustav.dscommerce.dto.OrderDTO;
import com.luisgustav.dscommerce.dto.OrderItemDTO;
import com.luisgustav.dscommerce.entities.*;
import com.luisgustav.dscommerce.repositories.OrderItemRepository;
import com.luisgustav.dscommerce.repositories.OrderRepository;
import com.luisgustav.dscommerce.repositories.ProductRepository;
import com.luisgustav.dscommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class OrderService {
    //Injeção de dependencias
    @Autowired
    private OrderRepository repository;

    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserService userService;


    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        Order order = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado!"));
        return new OrderDTO(order);

    }
    @Transactional
    public OrderDTO insert(OrderDTO dto) {
        Order order = new Order();
        order.setMoment(Instant.now());
        order.setStatus(OrderStatus.WAITING_PAYMENT);

        User user = userService.authenticated();
        order.setClient(user);

        //varreduras de items
        for(OrderItemDTO itemDTO : dto.getItems()) {
          Product product = productRepository.getReferenceById(itemDTO.getProductId());
            OrderItem item = new OrderItem(order,product, itemDTO.getQuantity(), product.getPrice());
            order.getItens().add(item);
        }
       repository.save(order);
       orderItemRepository.saveAll(order.getItens());
       return  new OrderDTO(order);
    }
}
