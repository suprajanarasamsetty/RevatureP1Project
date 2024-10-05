package com.revature.spring.revshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.revature.spring.revshop.dto.ProductRequest;
import com.revature.spring.revshop.dto.ProductResponse;
import com.revature.spring.revshop.service.ProductService;

import ch.qos.logback.core.model.Model;

@RestController
@RequestMapping("/product/")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Create a new product
    //@PostMapping("/add")
//    public boolean createProduct(@RequestBody ProductRequest productRequest) {
//        try {
//            return productService.createProduct(productRequest);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//    @PostMapping("/add")
//    public String createProduct(@RequestParam String name, @RequestParam String description, @RequestParam double price, RedirectAttributes redirectAttributes) {
//        try {
//            ProductRequest productRequest = new ProductRequest();
//            productRequest.setName(name);
//            productRequest.setDescription(description);
//            productRequest.setPrice(price);
//            boolean isCreated = productService.createProduct(productRequest);
//            if (isCreated) {
//                redirectAttributes.addFlashAttribute("message", "Product added successfully!");
//            } else {
//                redirectAttributes.addFlashAttribute("message", "Failed to add product.");
//            }
//            return "redirect:/seller-dashboard";
//        } catch (Exception e) {
//            e.printStackTrace();
//            redirectAttributes.addFlashAttribute("message", "An error occurred while adding the product.");
//            return "redirect:/seller-dashboard";
//        }
//    }
    
    @PostMapping("/add")
    public String createProduct(@RequestParam String name, @RequestParam String description, @RequestParam double price, @RequestParam Long userId, RedirectAttributes redirectAttributes) {
        try {
            ProductRequest productRequest = new ProductRequest();
            productRequest.setName(name);
            productRequest.setDescription(description);
            productRequest.setPrice(price);
            productRequest.setUserId(userId); // Set the userId
            boolean isCreated = productService.createProduct(productRequest);
            if (isCreated) {
                redirectAttributes.addFlashAttribute("message", "Product added successfully!");
            } else {
                redirectAttributes.addFlashAttribute("message", "Failed to add product.");
            }
            return "redirect:/seller-dashboard";
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "An error occurred while adding the product.");
            return "redirect:/seller-dashboard";
        }
    }

    
    // Get a product by ID
    @GetMapping("/{id}")
    public ProductResponse getProductById(@RequestParam long id) {
        return productService.getProductById(id);
    }

    // Update a product by ID
    @PutMapping("/update")
    public ProductResponse updateProductById(@RequestBody ProductRequest productRequest, @RequestParam long id) {
        try {
            return productService.updateProductById(productRequest, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Delete a product by ID
    @DeleteMapping("/delete")
    public boolean deleteProductById(@RequestParam long id) {
        return productService.deleteProductById(id);
    }
//    @GetMapping("/view")
//    public String viewProducts(Model model) {
//        List<ProductResponse> products = productService.getAllProducts();
//        model.addAttribute("products", products);
//        return "viewProducts"; // Return the viewProducts.jsp page
//    }
    // Get a product by name
    @GetMapping("by-name")
    public ProductResponse getProductByName(@RequestParam String name) {
        return productService.getProductByName(name);
    }
}