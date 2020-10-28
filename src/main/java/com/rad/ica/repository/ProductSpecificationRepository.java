package com.rad.ica.repository;

import com.rad.ica.domain.ProductSpecification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductSpecificationRepository extends MongoRepository<ProductSpecification,String > {
}
