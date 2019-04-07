package com.join.autogeneral.response;

/**
 * Created by satyaveerkrovvidi on 6/4/19.
 */
public class BracketsResponse {
    String text;
    String isBalanced;

    public BracketsResponse() {
    }

    public BracketsResponse(String text, String isBalanced) {
        this.text = text;
        this.isBalanced = isBalanced;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIsBalanced() {
        return isBalanced;
    }

    public void setIsBalanced(String isBalanced) {
        this.isBalanced = isBalanced;
    }
}
