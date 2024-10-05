package com.revature.spring.revshop.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
	@GetMapping("/index")
	 public String indexJsp(){
	        return "index";
	    }
	 @GetMapping("/login")
	 public String loginJsp(){
	        return "login";
	    }
 @GetMapping("/register")
	 public String registerJsp(){
	        return "register";
    }
 @GetMapping("/profile")
 public String profile() {
     return "profile";
 }
 @GetMapping("/updateProduct")
 public String updateProduct() {
     return "updateProduct";
 }
 
 @GetMapping("/buyer-dashboard")
 public String buyerDashboard() {
     return "buyer-dashboard";
 }
 @GetMapping("/view-all-products")
 public String viewProducts() {
     return "view-all-products";
 }
 @GetMapping("/addProduct")
 public String addProduct() {
     return "addProduct";
 }


 @GetMapping("/seller-dashboard")
 public String sellerDashboard() {
     return "seller-dashboard";
 }

}