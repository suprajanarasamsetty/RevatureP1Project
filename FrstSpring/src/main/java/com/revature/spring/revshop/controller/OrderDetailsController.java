package com.revature.spring.revshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.revature.spring.revshop.dto.OrderDetailsRequest;
import com.revature.spring.revshop.dto.OrderDetailsResponse;
import com.revature.spring.revshop.service.OrderDetailsService;

@RestController
@RequestMapping("/orderdetails/")
public class OrderDetailsController {

    private final OrderDetailsService orderDetailsService;

    @Autowired
    public OrderDetailsController(OrderDetailsService orderDetailsService) {
        this.orderDetailsService = orderDetailsService;
    }

    @PostMapping
    public boolean createOrderDetails(@RequestBody OrderDetailsRequest orderDetailsRequest) {
        try {
            return orderDetailsService.createOrderDetails(orderDetailsRequest);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @GetMapping
    public OrderDetailsResponse getOrderDetailsById(@RequestParam long id) {
        return orderDetailsService.getOrderDetailsById(id);
    }

    @PutMapping
    public OrderDetailsResponse updateOrderDetailsById(@RequestBody OrderDetailsRequest orderDetailsRequest, @RequestParam long id) {
        try {
            return orderDetailsService.updateOrderDetailsById(orderDetailsRequest, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @DeleteMapping
    public boolean deleteOrderDetailsById(@RequestParam long id) {
        return orderDetailsService.deleteOrderDetailsById(id);
    }

    @GetMapping("/by-order")
    public List<OrderDetailsResponse> getOrderDetailsByOrderId(@RequestParam long orderId) {
        return orderDetailsService.getOrderDetailsByOrderId(orderId);
    }

    @GetMapping("/by-product")
    public List<OrderDetailsResponse> getOrderDetailsByProductId(@RequestParam long productId) {
        return orderDetailsService.getOrderDetailsByProductId(productId);
    }
}