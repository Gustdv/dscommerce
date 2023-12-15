package com.luisgustav.dscommerce.dto;

import com.luisgustav.dscommerce.entities.Payment;

import java.time.Instant;

public class PaymentDTO {
   //Atributos
    private Long id;
    private Instant moment;

    //Construtor
    public PaymentDTO(Long id, Instant moment) {
        this.id = id;
        this.moment = moment;
    }

    public PaymentDTO(Payment entity) {
        id = entity.getId();
        moment = entity.getMoment();
    }

    //Getters

    public Long getId() {
        return id;
    }

    public Instant getMoment() {
        return moment;
    }
}
