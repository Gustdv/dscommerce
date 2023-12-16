package com.luisgustav.dscommerce.services.exceptions;

public class ForbiddenException extends RuntimeException { //excecoes customizadas

    public ForbiddenException(String msg) {

        super(msg);
    }

}
