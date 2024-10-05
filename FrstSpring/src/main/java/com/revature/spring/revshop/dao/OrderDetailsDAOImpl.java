package com.revature.spring.revshop.dao;

import com.revature.spring.revshop.dao.OrderDetailsDAO;
import com.revature.spring.revshop.dto.OrderDetailsRequest;
import com.revature.spring.revshop.dto.OrderDetailsResponse;
import com.revature.spring.revshop.model.Order;
import com.revature.spring.revshop.model.OrderDetails;
import com.revature.spring.revshop.model.Product;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

import java.util.List;

@Repository
public class OrderDetailsDAOImpl implements OrderDetailsDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public boolean createOrderDetails(OrderDetailsRequest orderDetailsRequest) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        try {
            OrderDetails orderDetails = OrderDetails.builder()
                    .order(session.get(Order.class, orderDetailsRequest.getOrderId()))
                    .product(session.get(Product.class, orderDetailsRequest.getProductId()))
                    .build();

            session.save(orderDetails);
            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public OrderDetailsResponse getOrderDetailsById(long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        try {
            OrderDetails orderDetails = session.get(OrderDetails.class, id);
            if (orderDetails != null) {
                return OrderDetailsResponse.builder()
                        .id(orderDetails.getId())
                        .orderId(orderDetails.getOrder().getId())
                        .productId(orderDetails.getProduct().getId())
                        .build();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return null;
    }

    @Override
    public OrderDetailsResponse updateOrderDetailsById(OrderDetailsRequest orderDetailsRequest, long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        try {
            OrderDetails orderDetails = session.get(OrderDetails.class, id);
            if (orderDetails != null) {
                orderDetails.setOrder(session.get(Order.class, orderDetailsRequest.getOrderId()));
                orderDetails.setProduct(session.get(Product.class, orderDetailsRequest.getProductId()));

                session.saveOrUpdate(orderDetails);
                tx.commit();

                return OrderDetailsResponse.builder()
                        .id(orderDetails.getId())
                        .orderId(orderDetails.getOrder().getId())
                        .productId(orderDetails.getProduct().getId())
                        .build();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return null;
    }

    @Override
    @Transactional
    public boolean deleteOrderDetailsById(long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        try {
            OrderDetails orderDetails = session.get(OrderDetails.class, id);
            if (orderDetails != null) {
                session.delete(orderDetails);
                tx.commit();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return false;
    }

    @Override
    public List<OrderDetailsResponse> getOrderDetailsByOrderId(long orderId) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        try {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<OrderDetails> cq = cb.createQuery(OrderDetails.class);
            Root<OrderDetails> root = cq.from(OrderDetails.class);
            cq.select(root).where(cb.equal(root.get("order").get("id"), orderId));

            List<OrderDetails> results = session.createQuery(cq).getResultList();

            tx.commit();
            return results.stream()
                    .map(orderDetails -> OrderDetailsResponse.builder()
                            .id(orderDetails.getId())
                            .orderId(orderDetails.getOrder().getId())
                            .productId(orderDetails.getProduct().getId())
                            .build())
                    .toList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return null;
    }

    @Override
    public List<OrderDetailsResponse> getOrderDetailsByProductId(long productId) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        try {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<OrderDetails> cq = cb.createQuery(OrderDetails.class);
            Root<OrderDetails> root = cq.from(OrderDetails.class);
            cq.select(root).where(cb.equal(root.get("product").get("id"), productId));

            List<OrderDetails> results = session.createQuery(cq).getResultList();

            tx.commit();
            return results.stream()
                    .map(orderDetails -> OrderDetailsResponse.builder()
                            .id(orderDetails.getId())
                            .orderId(orderDetails.getOrder().getId())
                            .productId(orderDetails.getProduct().getId())
                            .build())
                    .toList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return null;
    }
}