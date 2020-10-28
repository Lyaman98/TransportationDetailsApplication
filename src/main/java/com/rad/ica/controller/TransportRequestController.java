package com.rad.ica.controller;

import com.rad.ica.domain.ProductSpecification;
import com.rad.ica.domain.TransportRequest;
import com.rad.ica.exceptions.PageNotFoundException;
import com.rad.ica.service.ProductSpecificationService;
import com.rad.ica.service.TransportRequestService;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/api")
public class TransportRequestController {

    private TransportRequestService transportRequestService;
    private ProductSpecificationService productSpecificationService;

    public TransportRequestController(TransportRequestService transportRequestService, ProductSpecificationService productSpecificationService) {
        this.transportRequestService = transportRequestService;
        this.productSpecificationService = productSpecificationService;
    }


    @GetMapping("/new/request")
    public String getNewForm(Model model){

        TransportRequest transportRequest = new TransportRequest();
        String uuid = UUID.randomUUID().toString();
        transportRequest.setOrderID(uuid.substring(0, 8));
        model.addAttribute("transportRequest",transportRequest);

        return "customerSupport/customerDetails";
    }

    @PostMapping("/update/{orderId}/product/{productId}")
    public String updateProduct(@ModelAttribute("productSpecification") ProductSpecification productSpecification,
                                @PathVariable("orderId") String orderId,  @PathVariable("productId") String productId){

        Optional<TransportRequest> optional = transportRequestService.findByOrderId(orderId);
        if (optional.isPresent()){
            TransportRequest result = optional.get();
            productSpecificationService.findById(productId).ifPresent(oldData ->{
                productSpecification.setId(oldData.getId());
                productSpecificationService.save(productSpecification);
            });
            result.getProductList().add(productSpecification);
            transportRequestService.save(result);

        }
        return "redirect:/api/product/" + orderId + "/details";
    }

    @PostMapping("/update/customer")
    public String updateCustomer(@ModelAttribute("transportRequest") TransportRequest transportRequest){

        productSpecificationService.saveAll(transportRequest.getProductList());
        transportRequestService.save(transportRequest);
        return "redirect:/api/customer/details/" + transportRequest.getOrderID();
    }

    @GetMapping("/customer/details/{orderId}")
    public String getRequestDetails(Model model, @PathVariable(value = "orderId") String orderId){

        Optional<TransportRequest> transportRequest = transportRequestService.findByOrderId(orderId);
        if (transportRequest.isPresent()){
            model.addAttribute("transportRequest", transportRequest.get());
            return "customerSupport/customerDetails";
        }

        throw  new PageNotFoundException("Page not found");
    }

    @GetMapping("/product/{orderId}/details")
    public String productSpecification(Model model, @PathVariable(value = "orderId") String orderId){

        Optional<TransportRequest> transportRequest = transportRequestService.findByOrderId(orderId);
        if (transportRequest.isPresent()){

            List<ProductSpecification> productList = transportRequest.get().getProductList();
            if (productList.size() == 1){
                model.addAttribute("productSpecification", new ProductSpecification());
            }else {
                System.out.println("here");
                model.addAttribute("productSpecification", transportRequest.get().getProductList().get(0));
                model.addAttribute("productId",transportRequest.get().getProductList().get(0).getId());

            }
            model.addAttribute("orderId",orderId);
            return "customerSupport/productSpecificationDetails";
        }

        throw  new PageNotFoundException("Page not found");
    }



}
