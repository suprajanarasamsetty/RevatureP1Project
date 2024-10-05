package com.revature.spring.revshop.dao;

import java.util.List;

import com.revature.spring.revshop.dto.OrderDetailsRequest;
import com.revature.spring.revshop.dto.OrderDetailsResponse;

public interface OrderDetailsDAO {

    boolean createOrderDetails(OrderDetailsRequest orderDetailsRequest);

    OrderDetailsResponse getOrderDetailsById(long id);

    OrderDetailsResponse updateOrderDetailsById(OrderDetailsRequest orderDetailsRequest, long id);

    boolean deleteOrderDetailsById(long id);

    List<OrderDetailsResponse> getOrderDetailsByOrderId(long orderId);

    List<OrderDetailsResponse> getOrderDetailsByProductId(long productId);
}