package com.rad.ica.service;

import com.rad.ica.domain.Product;
import com.rad.ica.domain.ProductSpecification;
import com.rad.ica.repository.ProductSpecificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductSpecificationService {

    private ProductSpecificationRepository productSpecificationRepository;

    public ProductSpecificationService(ProductSpecificationRepository productSpecificationRepository) {
        this.productSpecificationRepository = productSpecificationRepository;
    }

    public ProductSpecification save(ProductSpecification productSpecification){
        return  productSpecificationRepository.save(productSpecification);
    }

    public void saveAll(List<ProductSpecification> productSpecification){
        productSpecificationRepository.saveAll(productSpecification);
    }
    public Optional<ProductSpecification> findById(String id){
        return productSpecificationRepository.findById(id);
    }
}
