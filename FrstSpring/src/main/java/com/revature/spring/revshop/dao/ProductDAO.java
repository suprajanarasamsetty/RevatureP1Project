package com.revature.spring.revshop.dao;

import com.revature.spring.revshop.dto.ProductRequest;
import com.revature.spring.revshop.dto.ProductResponse;

public interface ProductDAO {
    boolean createProduct(ProductRequest productRequest);
    ProductResponse getProductById(long id);
    ProductResponse updateProductById(ProductRequest productRequest, long id);
    boolean deleteProductById(long id);
    ProductResponse getProductByName(String name);
}