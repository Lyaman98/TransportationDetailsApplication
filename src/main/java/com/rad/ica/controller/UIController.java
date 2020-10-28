package com.rad.ica.controller;

import com.rad.ica.domain.ProductSpecification;
import com.rad.ica.domain.TransportRequest;
import com.rad.ica.service.TransportRequestService;
import com.rad.ica.utils.Pagination;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/api")
public class UIController {

    private TransportRequestService transportRequestService;

    public UIController(TransportRequestService transportRequestService) {
        this.transportRequestService = transportRequestService;
    }

    @GetMapping("/transport-requests")
    public String returnTransportRequests(HttpServletRequest request, Model model){

        int page = 0;
        int size = 10;

        if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()){
            page = Integer.parseInt(request.getParameter("page")) - 1;
        }

        Page<TransportRequest> transportRequests =
                transportRequestService.findAllWithPagination(PageRequest.of(page,size));


        model.addAttribute("transportRequests",transportRequests);
        model.addAttribute("counter", 0);
        return "/customerSupport/main";
    }





}
