package com.revature.spring.revshop.dao;

import com.revature.spring.revshop.dto.OrderRequest;
import com.revature.spring.revshop.dto.OrderResponse;
import com.revature.spring.revshop.model.Order;
import com.revature.spring.revshop.model.Product;
import com.revature.spring.revshop.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public boolean createOrder(OrderRequest orderRequest) {
        try {
            Order order = Order.builder()
                    .user(entityManager.find(User.class, orderRequest.getUserId()))
                    .totalPrice(orderRequest.getTotalPrice())
                    .address(orderRequest.getAddress())
                    .payment(orderRequest.getPayment())
                    .date(java.time.LocalDateTime.now()) // Setting current date
                    .build();

            entityManager.persist(order);

            // If product IDs are provided, you need to fetch the products and add to order
            if (orderRequest.getProductIds() != null && !orderRequest.getProductIds().isEmpty()) {
                List<Product> products = entityManager.createQuery("SELECT p FROM Product p WHERE p.id IN :ids", Product.class)
                        .setParameter("ids", orderRequest.getProductIds())
                        .getResultList();

                for (Product product : products) {
                    // Assuming you have a way to add products to the order
                    // This part will depend on how your Order entity handles products
                    // You may need to update this based on the actual implementation
                }
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public OrderResponse getOrderById(long id) {
        try {
            Order order = entityManager.find(Order.class, id);
            return mapOrderToResponse(order);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    @Transactional
    public OrderResponse updateOrderById(OrderRequest orderRequest, long id) {
        try {
            Order order = entityManager.find(Order.class, id);
            if (order != null) {
                order.setTotalPrice(orderRequest.getTotalPrice());
                order.setAddress(orderRequest.getAddress());
                order.setPayment(orderRequest.getPayment());

                // Update the products if needed
                // Similar to the createOrder method, fetch and update products

                entityManager.merge(order);
                return mapOrderToResponse(order);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    @Transactional
    public boolean deleteOrderById(long id) {
        try {
            Order order = entityManager.find(Order.class, id);
            if (order != null) {
                entityManager.remove(order);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public OrderResponse getOrderDetails(long userId) {
        try {
            TypedQuery<Order> query = entityManager.createQuery("SELECT o FROM Order o WHERE o.user.id = :userId", Order.class);
            query.setParameter("userId", userId);
            Order order = query.getSingleResult();
            return mapOrderToResponse(order);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private OrderResponse mapOrderToResponse(Order order) {
        if (order == null) {
            return null;
        }

        return OrderResponse.builder()
                .id(order.getId())
                .userId(order.getUser() != null ? order.getUser().getId() : null)
                .totalPrice(order.getTotalPrice())
                .address(order.getAddress())
                .payment(order.getPayment())
                // Assuming products are handled elsewhere
                .productIds(null) // Set this if you have a way to retrieve product IDs
                .build();
    }
}
