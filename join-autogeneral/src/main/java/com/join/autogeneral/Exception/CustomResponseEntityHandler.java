package com.join.autogeneral.Exception;

import com.join.autogeneral.entity.AutoGen;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Created by satyaveerkrovvidi on 6/4/19.
 */

@ControllerAdvice
@RestController
public class CustomResponseEntityHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        AutoGenErrResponse autoGenErrResponse = new AutoGenErrResponse(prepareAutoGenErrDetailsList(ex),ex.getCause().getMessage());
        autoGenErrResponse.setName(ex.getCause().getMessage());
        return new ResponseEntity(autoGenErrResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(AutoGenNotFoundException.class)
    public final ResponseEntity<Object> autoGenNotFoundException(AutoGenNotFoundException ex, WebRequest request){
        AutoGenErrResponse autoGenErrResponse =
                new AutoGenErrResponse(prepareAutoGenErrDetailsList(ex),ex.getCause().getMessage());
        autoGenErrResponse.setName(ex.getCause().getMessage());
        return new ResponseEntity(autoGenErrResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AgLengthValidationException.class)
    public final ResponseEntity<Object> autoGenLengthValidationException(Exception ex, WebRequest request){
        AutoGenErrResponse autoGenErrResponse =
                new AutoGenErrResponse(prepareAutoGenErrDetailsList(ex),ex.getCause().getMessage());
        autoGenErrResponse.setName(ex.getCause().getMessage());
        return new ResponseEntity(autoGenErrResponse, HttpStatus.BAD_REQUEST);

    }

    private List<AutoGenErrDetails> prepareAutoGenErrDetailsList(Exception ex){
        AutoGenErrDetails autoGenErrDetails = new AutoGenErrDetails();
        List<AutoGenErrDetails> autoGenErrDetailsList = new ArrayList<AutoGenErrDetails>();
        autoGenErrDetails.setMsg(ex.getMessage());
        if("ValidationError".equals(ex.getCause().getMessage())){
            autoGenErrDetails.setParam("text");
            autoGenErrDetails.setLocation("params");
        }
        autoGenErrDetails.setValue("");
        autoGenErrDetailsList.add(autoGenErrDetails);
        return autoGenErrDetailsList;
    }

}
