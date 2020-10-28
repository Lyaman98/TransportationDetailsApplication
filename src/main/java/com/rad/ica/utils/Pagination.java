package com.rad.ica.utils;

import com.rad.ica.domain.ProductSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public class Pagination {

    public static Page returnPage(List<ProductSpecification> productSpecifications, int page, int size) {
        int start = (int) PageRequest.of(page, size).getOffset();
        int end = (start + PageRequest.of(page, size).getPageSize()) > productSpecifications.size() ? productSpecifications.size()
                : (start + PageRequest.of(page, size).getPageSize());

        return new PageImpl<>(productSpecifications.subList(start, end),
                PageRequest.of(page, size), productSpecifications.size());
    }
}
