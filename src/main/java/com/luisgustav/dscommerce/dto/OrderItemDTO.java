package com.luisgustav.dscommerce.dto;

import com.luisgustav.dscommerce.entities.OrderItem;

public class OrderItemDTO {
  //Atributos

    private Long productId;
    private String name;
    private Double price;
    private Integer quantity;

    //Construtor


    public OrderItemDTO(Long productId, String name, Double price, Integer quantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public OrderItemDTO(OrderItem entity) {
        productId = entity.getProduct().getId();
        name = entity.getProduct().getName();
        price = entity.getPrice();
        quantity = entity.getQuantity();
    }

    //Getters

    public Long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    //Subtotal
    public Double getSubTotal() {
        return  price * quantity;
    }
}
