package com.revature.spring.revshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.spring.revshop.dao.OrderDAO;
import com.revature.spring.revshop.dto.OrderRequest;
import com.revature.spring.revshop.dto.OrderResponse;

@Service
public class OrderService {

    private final OrderDAO orderDAO;

    @Autowired
    public OrderService(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public boolean createOrder(OrderRequest orderRequest) {
        return orderDAO.createOrder(orderRequest);
    }

    public OrderResponse getOrderById(long id) {
        return orderDAO.getOrderById(id);
    }

    public OrderResponse updateOrderById(OrderRequest orderRequest, long id) {
        return orderDAO.updateOrderById(orderRequest, id);
    }

    public boolean deleteOrderById(long id) {
        return orderDAO.deleteOrderById(id);
    }

    public OrderResponse getOrderDetails(long userId) {
        return orderDAO.getOrderDetails(userId);
    }
}