package com.join.autogeneral.service;

import com.join.autogeneral.beans.BracketsBean;
import com.join.autogeneral.response.BracketsResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by satyaveerkrovvidi on 6/4/19.
 */
@Service
public class AutoGenServiceImpl implements AutoGenService {

    public  boolean isValidInput(String input) {
        HashMap<Character, Character> hMap = new HashMap<Character, Character>();
        hMap.put('(', ')');
        hMap.put('[', ']');
        hMap.put('{', '}');
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < input.length(); i++) {
            char curr = input.charAt(i);
            if (hMap.keySet().contains(curr)) {
                stack.push(curr);
            } else if (hMap.values().contains(curr)) {
                if (!stack.empty() && hMap.get(stack.peek()) == curr) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }
/*
    public AutoGenErrResponse prepareAutoGenErrorMessage(String msg, String errorType) {
        AutoGenErrResponse autoGenErrResponse = new AutoGenErrResponse();
        AutoGenErrDetails autoGenErrDetails = new AutoGenErrDetails();
        List<AutoGenErrDetails> autoGenErrDetailsList = new ArrayList<AutoGenErrDetails>();
        autoGenErrDetails.setMsg(msg);
        autoGenErrDetails.setParam("text");
        autoGenErrDetails.setLocation("paramse");
        autoGenErrDetailsList.add(autoGenErrDetails);
        autoGenErrResponse.setAutoGenErrDetailsList(autoGenErrDetailsList);
        autoGenErrResponse.setName(errorType);
        return autoGenErrResponse;
    } */

    public BracketsResponse prepareBracketsResponse(BracketsBean bracketsBean, String isValidInput) {

        return prepareBracketsResponse(bracketsBean.getInput(), isValidInput);

        /*BracketsResponse bracketsResponse = new BracketsResponse();
        bracketsResponse.setText(bracketsBean.getInput());
        bracketsResponse.setBalanced(isValidInput);
        return bracketsResponse;*/
    }

    @Override
    public BracketsResponse prepareBracketsResponse(String input, String isValidInput) {
        BracketsResponse bracketsResponse = new BracketsResponse();
        bracketsResponse.setText(input);
        bracketsResponse.setIsBalanced(isValidInput);
        return bracketsResponse;
    }

}
