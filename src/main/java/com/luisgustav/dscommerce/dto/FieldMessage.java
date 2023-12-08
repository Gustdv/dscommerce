package com.luisgustav.dscommerce.dto;

public class FieldMessage {

   //Atributos

    private String fieldName;

    private String message;

    //Construtor


    public FieldMessage(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    //Getters


    public String getFieldName() {
        return fieldName;
    }

    public String getMessage() {
        return message;
    }
}
