package com.join.autogeneral.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

/**
 * Created by satyaveerkrovvidi on 6/4/19.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class AutoGenErrResponse {

    List<AutoGenErrDetails> details;
    String name;

    public AutoGenErrResponse(List<AutoGenErrDetails> details, String name) {
        this.details = details;
        this.name = name;
    }

    public List<AutoGenErrDetails> getDetails() {
        return details;
    }

    public void setDetails(List<AutoGenErrDetails> details) {
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AutoGenErrResponse{" +
                "details=" + details +
                ", name='" + name + '\'' +
                '}';
    }
}
