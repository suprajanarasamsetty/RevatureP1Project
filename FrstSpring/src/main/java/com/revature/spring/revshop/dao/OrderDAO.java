package com.revature.spring.revshop.dao;

import com.revature.spring.revshop.dto.OrderRequest;
import com.revature.spring.revshop.dto.OrderResponse;

public interface OrderDAO {
    boolean createOrder(OrderRequest orderRequest);
    OrderResponse getOrderById(long id);
    OrderResponse updateOrderById(OrderRequest orderRequest, long id);
    boolean deleteOrderById(long id);
    OrderResponse getOrderDetails(long userId);
}