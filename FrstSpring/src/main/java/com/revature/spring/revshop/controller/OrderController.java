package com.revature.spring.revshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.revature.spring.revshop.dto.OrderRequest;
import com.revature.spring.revshop.dto.OrderResponse;
import com.revature.spring.revshop.service.OrderService;

@RestController
@RequestMapping("/order/")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public boolean createOrder(@RequestBody OrderRequest orderRequest) {
        try {
            return orderService.createOrder(orderRequest);
        } catch (Exception e) {
            // Log the exception and return a failure response
            e.printStackTrace();
            return false;
        }
    }

    @GetMapping
    public OrderResponse getOrderById(@RequestParam long id) {
        try {
            return orderService.getOrderById(id);
        } catch (Exception e) {
            // Log the exception and return a failure response
            e.printStackTrace();
            return null;
        }
    }

    @PutMapping
    public OrderResponse updateOrderById(@RequestBody OrderRequest orderRequest, @RequestParam long id) {
        try {
            return orderService.updateOrderById(orderRequest, id);
        } catch (Exception e) {
            // Log the exception and return a failure response
            e.printStackTrace();
            return null;
        }
    }

    @DeleteMapping
    public boolean deleteOrderById(@RequestParam long id) {
        try {
            return orderService.deleteOrderById(id);
        } catch (Exception e) {
            // Log the exception and return a failure response
            e.printStackTrace();
            return false;
        }
    }

    @GetMapping("details")
    public OrderResponse getOrderDetails(@RequestParam long userId) {
        try {
            return orderService.getOrderDetails(userId);
        } catch (Exception e) {
            // Log the exception and return a failure response
            e.printStackTrace();
            return null;
        }
    }
}