package com.join.autogeneral.controller;

import com.join.autogeneral.Exception.AgLengthValidationException;
import com.join.autogeneral.response.AutoGenResponse;
import com.join.autogeneral.Exception.AutoGenNotFoundException;
import com.join.autogeneral.entity.AutoGen;
import com.join.autogeneral.repository.AutoGenRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


/**
 * Created by satyaveerkrovvidi on 6/4/19.
 */

@RestController
public class agCrudController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AutoGenRepository autoGenRepository;

    @GetMapping("/todos")
    public List<AutoGen> getAutoGenToDos() {
        logger.info(" get all autogen todos  ");
        return autoGenRepository.findAll();


    }

    @GetMapping("/todo/{id}")
    public Resource<AutoGen> getAutoGenToDo(@PathVariable int id) {
        logger.debug(" entering getAutoGenToDo ");
        Optional<AutoGen> autoGen = autoGenRepository.findById(id);
        if (!autoGen.isPresent()) {
            throw new AutoGenNotFoundException("Item with "+id+" not found", new Throwable("NotFoundError"));
        }
        Resource<AutoGen> resource = new Resource<AutoGen>(autoGen.get());
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAutoGenToDos());
        resource.add(linkTo.withRel("all-todos"));
        logger.debug(" exiting getAutoGenToDo ");
        return resource;
    }

    @PostMapping("/todo")
    public ResponseEntity<Object> createAutoGenToDo(@RequestBody AutoGen autoGen){
        logger.debug(" entering createAutoGenToDo ");
        if(autoGen != null && autoGen.getText()!=null && (autoGen.getText().trim().length()<1 || autoGen.getText().trim().length()>50)){
            throw new AgLengthValidationException("Must be between 1 and 50 chars long", new Throwable("ValidationError"));
        }

        AutoGenResponse autoGenResponse = new AutoGenResponse();
        if(autoGen!=null && (autoGen.getIsCompleted() == null || "".equals(autoGen.getIsCompleted()))){
            autoGen.setIsCompleted("false");
        }
        autoGen.setCreatedAt(new Date());

        try{
            AutoGen autoGenCreated = autoGenRepository.save(autoGen);
            return ResponseEntity.ok(autoGenCreated);
        }catch (Exception e){
            autoGenResponse.setMessage(" Error creating a Todo");
            logger.error("error creating a todo ");
        }
        logger.debug(" exiting createAutoGenToDo ");
       return  ResponseEntity.ok(autoGenResponse);
    }


    @PatchMapping("/todo/{id}")
    public ResponseEntity<Object> updateAutoGenToDo(@PathVariable int id , @RequestBody AutoGen autoGen){
        logger.debug(" entering updateAutoGenToDo ");
        if(autoGen != null && autoGen.getText()!=null && (autoGen.getText().trim().length()<1 || autoGen.getText().trim().length()>50)){
            throw new AgLengthValidationException("Must be between 1 and 50 chars long", new Throwable("ValidationError"));
        }
        Optional<AutoGen> autoGenById = autoGenRepository.findById(id);
        if (!autoGenById.isPresent()) {
            throw new AutoGenNotFoundException("Item with "+id+" not found", new Throwable("NotFoundError"));
        }

        if(autoGen!= null && autoGen.getCreatedAt() != null){
            autoGenById.get().setCreatedAt(autoGen.getCreatedAt());
        }
        if(autoGen!= null && autoGen.getText() != null){
            autoGenById.get().setText(autoGen.getText() );
        }
        if(autoGen!=null && autoGen.getIsCompleted() != null && !"".equals(autoGen.getIsCompleted())){
            autoGenById.get().setIsCompleted(autoGen.getIsCompleted() );
        }

        AutoGen autoGenResponse = autoGenRepository.saveAndFlush(autoGenById.get());
        logger.debug(" exiting updateAutoGenToDo ");
        return ResponseEntity.ok(autoGenResponse);
    }

}