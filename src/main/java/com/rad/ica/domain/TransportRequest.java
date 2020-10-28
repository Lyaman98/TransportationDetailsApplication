package com.rad.ica.domain;

import com.rad.ica.domain.enumeration.Status;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Document
public class TransportRequest {

    @Id
    private String id;
    private String orderID;
    private String status;
    private LocalDate createdDate;
    private Employee createdBy;
    private Employee editedBy;
    private Employee employee;
    private Customer customer;

    @DBRef
    private List<ProductSpecification> productList = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Employee getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Employee createdBy) {
        this.createdBy = createdBy;
    }

    public Employee getEditedBy() {
        return editedBy;
    }

    public void setEditedBy(Employee editedBy) {
        this.editedBy = editedBy;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<ProductSpecification> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductSpecification> productList) {
        this.productList = productList;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }


    @Override
    public String toString() {
        return "TransactionRequest{" +
                "id='" + id + '\'' +
                ", orderID='" + orderID + '\'' +
                ", status=" + status +
                ", createdBy=" + createdBy +
                ", editedBy=" + editedBy +
                ", employee=" + employee +
                ", customer=" + customer +
                ", productList=" + productList +
                '}';
    }
}
