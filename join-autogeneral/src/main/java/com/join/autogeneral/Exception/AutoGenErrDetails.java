package com.join.autogeneral.Exception;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by satyaveerkrovvidi on 6/4/19.
 */
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class AutoGenErrDetails {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    String location;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    String param;

    String msg;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    String value;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "AutoGenErrDetails{" +
                "location='" + location + '\'' +
                ", param='" + param + '\'' +
                ", msg='" + msg + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
