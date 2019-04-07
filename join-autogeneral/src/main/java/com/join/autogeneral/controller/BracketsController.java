package com.join.autogeneral.controller;

import com.join.autogeneral.Exception.AgLengthValidationException;
import com.join.autogeneral.beans.BracketsBean;
import com.join.autogeneral.response.BracketsResponse;
import com.join.autogeneral.service.AutoGenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;


/**
 * Created by satyaveerkrovvidi on 6/4/19.
 */

@RestController
public class BracketsController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    AutoGenService autoGenService;

    @GetMapping("/tasks/validateBrackets")
    public ResponseEntity<Object> validateBracketsInput(@PathParam("input") String input) {
        logger.debug("inside validate Brackets method");
        if (null != input && !"".equals(input.trim())) {
            if (input.length() < 1 || input.length() > 50) {
                throw new AgLengthValidationException("Must be between 1 and 50 chars long", new Throwable("ValidationError"));
            } else {
                boolean isValidInput = autoGenService.isValidInput(input);
                BracketsResponse bracketsResponse = autoGenService.prepareBracketsResponse(input,String.valueOf(isValidInput));
                return ResponseEntity.ok(bracketsResponse);

            }
        }else{
            throw new AgLengthValidationException("Must be between 1 and 50 chars long", new Throwable("ValidationError"));
        }
    }
    @PostMapping("/tasks/validateBrackets")
    public ResponseEntity<Object> validateBrackets(@RequestBody BracketsBean bracketsBean) {
        logger.debug("inside validate Brackets method");
        if (null != bracketsBean.getInput() && !"".equals(bracketsBean.getInput())) {
            String inputString = bracketsBean.getInput().trim();
            if (inputString.length() < 1 || inputString.length() > 50) {
                throw new AgLengthValidationException("Must be between 1 and 50 chars long", new Throwable("ValidationError"));
            } else {
                boolean isValidInputString = autoGenService.isValidInput(inputString);
                BracketsResponse bracketsResponse = autoGenService.prepareBracketsResponse(bracketsBean,String.valueOf(isValidInputString));
                return ResponseEntity.ok(bracketsResponse);

            }
        }else{
            throw new AgLengthValidationException("Must be between 1 and 50 chars long", new Throwable("ValidationError"));
        }
    }

}
