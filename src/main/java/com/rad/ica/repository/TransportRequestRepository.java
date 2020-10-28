package com.rad.ica.repository;

import com.rad.ica.domain.ProductSpecification;
import com.rad.ica.domain.TransportRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TransportRequestRepository extends MongoRepository<TransportRequest,String> {


    Optional<TransportRequest> findByOrOrderID(String orderId);
    Page<TransportRequest> findAll(Pageable pageable);
}
