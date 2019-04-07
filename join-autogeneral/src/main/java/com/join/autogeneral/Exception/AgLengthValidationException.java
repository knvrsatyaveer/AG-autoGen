package com.join.autogeneral.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by satyaveerkrovvidi on 6/4/19.
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AgLengthValidationException extends  RuntimeException{

    public AgLengthValidationException(String message, Throwable ex){
        super(message, ex);
    }
}
