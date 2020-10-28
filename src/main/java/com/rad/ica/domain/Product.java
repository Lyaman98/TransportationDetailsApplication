package com.rad.ica.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
public class Product {

    @Id
    private String id;
    private String name;
    private Code code;
    private LocalDate expiration;
    private String unitSpecification;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public LocalDate getExpiration() {
        return expiration;
    }

    public void setExpiration(LocalDate expiration) {
        this.expiration = expiration;
    }

    public String getUnitSpecification() {
        return unitSpecification;
    }

    public void setUnitSpecification(String unitSpecification) {
        this.unitSpecification = unitSpecification;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", code=" + code +
                ", expiration=" + expiration +
                ", unitSpecification='" + unitSpecification + '\'' +
                '}';
    }
}
