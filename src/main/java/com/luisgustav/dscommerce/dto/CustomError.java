package com.luisgustav.dscommerce.dto;

import java.time.Instant;

public class CustomError {

    //Atributos

    private Instant timestamp;
    private Integer status;
    private String error;
    private String path;


    //Construtor
    public CustomError(Instant timestamp, Integer status, String error, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.path = path;
    }

    //Getters e Setters
    public Instant getTimestamp() {
        return timestamp;
    }
    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getPath() {
        return path;
    }


}
