package com.revature.spring.revshop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.spring.revshop.dao.ProductDAOImpl;
import com.revature.spring.revshop.dto.ProductRequest;
import com.revature.spring.revshop.dto.ProductResponse;
import com.revature.spring.revshop.model.Product;

@Service
public class ProductService {

    private ProductDAOImpl productDao;

    @Autowired
    public ProductService(ProductDAOImpl productDao) {
        this.productDao = productDao;
    }

    // Create Product
    public boolean createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }

    // Get Product by ID
    public ProductResponse getProductById(long id) {
        return productDao.getProductById(id);
    }

    // Update Product by ID
    public ProductResponse updateProductById(ProductRequest productRequest, long id) {
        return productDao.updateProductById(productRequest, id);
    }

    // Delete Product by ID
    public boolean deleteProductById(long id) {
        return productDao.deleteProductById(id);
    }
//    public List<ProductResponse> getAllProducts() {
//        List<ProductResponse> productResponses = new ArrayList<>();
//        for (Product product : productList) {
//            productResponses.add(new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice()));
//        }
//return productResponses;
//    }

    // Get Product by Name
    public ProductResponse getProductByName(String name) {
        return productDao.getProductByName(name);
    }
}