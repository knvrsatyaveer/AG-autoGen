package com.join.autogeneral.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by satyaveerkrovvidi on 6/4/19.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class AutoGenNotFoundException  extends RuntimeException{
    public AutoGenNotFoundException(String message, Throwable cause){
        super(message,cause);
    }
}
