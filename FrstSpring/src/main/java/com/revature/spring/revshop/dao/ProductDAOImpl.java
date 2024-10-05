package com.revature.spring.revshop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.spring.revshop.dto.ProductRequest;
import com.revature.spring.revshop.dto.ProductResponse;
import com.revature.spring.revshop.model.Product;
import com.revature.spring.revshop.model.User;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

import org.hibernate.Transaction;

@Repository
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public boolean createProduct(ProductRequest productRequest) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        try {
            User user = session.get(User.class, productRequest.getUserId());

            Product product = Product.builder()
                    .name(productRequest.getName())
                    .description(productRequest.getDescription())
                    .price(productRequest.getPrice())
                    .user(user) // Assigning the User based on userId
                    .build();

            session.save(product);
            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return false;
    }
    
    

    @Override
    public ProductResponse getProductById(long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        try {
            Product product = session.get(Product.class, id);

            if (product != null) {
                return ProductResponse.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .description(product.getDescription())
                        .price(product.getPrice())
                        .userId(product.getUser().getId()) // Getting userId from User object
                        .build();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return null;
    }

    @Override
    public ProductResponse updateProductById(ProductRequest productRequest, long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        try {
            User user = session.get(User.class, productRequest.getUserId());
            Product product = session.get(Product.class, id);

            if (product != null) {
                product.setName(productRequest.getName());
                product.setDescription(productRequest.getDescription());
                product.setPrice(productRequest.getPrice());
                product.setUser(user); // Updating the user association

                session.update(product);
                tx.commit();

                return ProductResponse.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .description(product.getDescription())
                        .price(product.getPrice())
                        .userId(product.getUser().getId())
                        .build();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return null;
    }

    @Override
    public boolean deleteProductById(long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        try {
            Product product = session.get(Product.class, id);

            if (product != null) {
                session.delete(product);
                tx.commit();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return false;
    }

    @Override
    public ProductResponse getProductByName(String name) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        try {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Product> cq = cb.createQuery(Product.class);
            Root<Product> productRoot = cq.from(Product.class);

            cq.select(productRoot)
                    .where(cb.equal(productRoot.get("name"), name));

            Product product = session.createQuery(cq).getSingleResult();
            tx.commit();

            if (product != null) {
                return ProductResponse.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .description(product.getDescription())
                        .price(product.getPrice())
                        .userId(product.getUser().getId())
                        .build();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return null;
    }
}