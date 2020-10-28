package com.rad.ica.domain;

import com.rad.ica.domain.enumeration.TransportationWays;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.time.LocalDate;
import java.util.List;

@Document
public class ProductSpecification {

    @Id
    private ObjectId id;
    private Integer amount;
    private AddressDetails deliveryAddress;
    private AddressDetails loadingAddress;
    private LocalDate deliveryDateTime;
    private LocalDate loadingDateTime;
    private String remarks;
    private Product product;
    private String transportationWays;
    private TransportProvider transportProvider;


    public TransportProvider getTransportProvider() {
        return transportProvider;
    }

    public void setTransportProvider(TransportProvider transportProvider) {
        this.transportProvider = transportProvider;
    }

    public String getTransportationWays() {
        return transportationWays;
    }

    public void setTransportationWays(String transportationWays) {
        this.transportationWays = transportationWays;
    }

    public LocalDate getLoadingDateTime() {
        return loadingDateTime;
    }

    public void setLoadingDateTime(LocalDate loadingDateTime) {
        this.loadingDateTime = loadingDateTime;
    }

    public void setDeliveryAddress(AddressDetails deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public AddressDetails getLoadingAddress() {
        return loadingAddress;
    }

    public void setLoadingAddress(AddressDetails loadingAddress) {
        this.loadingAddress = loadingAddress;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public AddressDetails getDeliveryAddress() {
        return deliveryAddress;
    }

    public LocalDate getDeliveryDateTime() {
        return deliveryDateTime;
    }

    public void setDeliveryDateTime(LocalDate deliveryDateTime) {
        this.deliveryDateTime = deliveryDateTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductSpecification{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", deliveryDateTime=" + deliveryDateTime +
                ", remarks='" + remarks + '\'' +
                ", product='" + product + '\'' +
                ", loadingAddress='" + loadingAddress + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +

                '}';
    }
}
