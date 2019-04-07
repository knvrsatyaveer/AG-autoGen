package com.join.autogeneral.service;

import com.join.autogeneral.beans.BracketsBean;
import com.join.autogeneral.response.BracketsResponse;

/**
 * Created by satyaveerkrovvidi on 6/4/19.
 */
public interface AutoGenService {

//    public AutoGenErrResponse prepareAutoGenErrorMessage(String msg, String errorType) ;

    public BracketsResponse prepareBracketsResponse(BracketsBean bracketsBean, String isValidInput) ;
    public BracketsResponse prepareBracketsResponse(String input, String isValidInput) ;

    boolean isValidInput(String input);
}
