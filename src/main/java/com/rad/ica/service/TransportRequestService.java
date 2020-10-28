package com.rad.ica.service;

import com.rad.ica.domain.TransportRequest;
import com.rad.ica.repository.TransportRequestRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TransportRequestService {

    private TransportRequestRepository transportRequestRepository;

    public TransportRequestService(TransportRequestRepository transportRequestRepository) {
        this.transportRequestRepository = transportRequestRepository;
    }

    public void save(TransportRequest transportRequest){

        transportRequestRepository.save(transportRequest);
    }

    public List<TransportRequest> findAll(){
        return transportRequestRepository.findAll();
    }

    public Page<TransportRequest> findAllWithPagination(Pageable pageable){
        return transportRequestRepository.findAll(pageable);
    }

    public Optional<TransportRequest> findByOrderId(String orderId){
        return transportRequestRepository.findByOrOrderID(orderId);
    }
}
