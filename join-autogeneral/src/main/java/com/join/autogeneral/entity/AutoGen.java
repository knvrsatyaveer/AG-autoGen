package com.join.autogeneral.entity;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by satyaveerkrovvidi on 6/4/19.
 */
@Entity
@Table(name = "AUTOGEN")
public class AutoGen {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;


    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @ApiModelProperty(notes="The date text is created")
    @Column(name = "CREATED_AT")
    private Date createdAt;


    @ApiModelProperty(notes="Is operation complted successfully")
    @Column(name="IS_COMPLETED")
    private String isCompleted;

    @Size(min=1,max = 50, message="Must be between  1 and 50 characters ")
    @ApiModelProperty(notes="Text must be between  1 and 50 characters ")
    @Column(name = "TEXT")
    private String text;

    public AutoGen(){

    }

    public AutoGen(Date createdAt, String isCompleted, String text) {
        this.createdAt = createdAt;
        this.isCompleted = isCompleted;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(String isCompleted) {
        this.isCompleted = isCompleted;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "AutoGen{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", isCompleted='" + isCompleted + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
