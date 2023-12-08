package com.luisgustav.dscommerce.services.exceptions;

public class ResourceNotFoundException extends RuntimeException { //excecoes customizadas

    public ResourceNotFoundException(String msg) {
        super(msg);
    }

}
