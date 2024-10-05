package com.revature.spring.revshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.spring.revshop.dao.OrderDetailsDAO;
import com.revature.spring.revshop.dto.OrderDetailsRequest;
import com.revature.spring.revshop.dto.OrderDetailsResponse;

@Service
public class OrderDetailsService {

    private final OrderDetailsDAO orderDetailsDAO;

    @Autowired
    public OrderDetailsService(OrderDetailsDAO orderDetailsDAO) {
        this.orderDetailsDAO = orderDetailsDAO;
    }

    public boolean createOrderDetails(OrderDetailsRequest orderDetailsRequest) {
        return orderDetailsDAO.createOrderDetails(orderDetailsRequest);
    }

    public OrderDetailsResponse getOrderDetailsById(long id) {
        return orderDetailsDAO.getOrderDetailsById(id);
    }

    public OrderDetailsResponse updateOrderDetailsById(OrderDetailsRequest orderDetailsRequest, long id) {
        return orderDetailsDAO.updateOrderDetailsById(orderDetailsRequest, id);
    }

    public boolean deleteOrderDetailsById(long id) {
        return orderDetailsDAO.deleteOrderDetailsById(id);
    }

    public List<OrderDetailsResponse> getOrderDetailsByOrderId(long orderId) {
        return orderDetailsDAO.getOrderDetailsByOrderId(orderId);
    }

    public List<OrderDetailsResponse> getOrderDetailsByProductId(long productId) {
        return orderDetailsDAO.getOrderDetailsByProductId(productId);
    }
}