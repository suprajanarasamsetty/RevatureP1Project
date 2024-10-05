package com.revature.spring.revshop.controller;

//package com.revature.EcommerceWebP1.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.revature.EcommerceWebP1.dto.UserRequest;
//import com.revature.EcommerceWebP1.dto.UserResponse;
//import com.revature.EcommerceWebP1.model.Role;
//import com.revature.EcommerceWebP1.service.UserService;
//
//import jakarta.servlet.http.HttpSession;
//
//@Controller
//@RequestMapping("/user")
//public class UserController {
//	
//	
//	@Autowired
//	private UserService userService;
//	
//	@GetMapping("/{id}")
//	
//	public UserResponse getUserById(@PathVariable long id) {
//		
//		return userService.getUserById(id);
//		
//		
//	}
//
//	@PostMapping("/register")
//	public String createUser(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String password, @RequestParam String role) {
//	    try {
//	        UserRequest userRequest = new UserRequest();
//	        userRequest.setFirstName(firstName);
//	        userRequest.setLastName(lastName);
//	        userRequest.setEmail(email);
//	        userRequest.setPassword(password);
//	        //userRequest.setRole(role);
//	        userRequest.setRole(Role.valueOf(role.toUpperCase()));
//	        boolean isCreated = userService.createUser(userRequest);
//          if (isCreated) {
//              return "redirect:/login"; // Redirect to login page after successful registration
//          } else {
//              return "register"; // Stay on the registration page if creation fails
//          }
//      } catch (Exception e) {
//          return "register"; // Stay on the registration page if an exception occurs
//      }
//	}
//
//	@PostMapping("/login")
//  public String login(@RequestParam String email, @RequestParam String password, HttpSession session) {
//      UserResponse userResponse = userService.login(email, password);
//      if (userResponse != null) {
//          session.setAttribute("user", userResponse);
//          if (userResponse.getRole() == Role.BUYER) { // Enum for Buyer
//              return "redirect:/buyer-dashboard";
//          } else if (userResponse.getRole() == Role.SELLER) { // Enum for Seller
//              return "redirect:/seller-dashboard";
//          } else {
//              return "login"; // Redirect to login page if role is unknown
//          }
//      } else {
//          return "login"; // Return to login page if authentication fails
//      }
//	}
//
//	
//
//}

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.servlet.http.HttpSession;

import com.revature.spring.revshop.dto.UserRequest;
import com.revature.spring.revshop.dto.UserResponse;
import com.revature.spring.revshop.model.Role;
import com.revature.spring.revshop.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/{id}")
  public UserResponse getUserById(@PathVariable long id) {
      return userService.getUserById(id);
  }

  @PostMapping("/register")
  public String createUser(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String password, @RequestParam String role) {
      try {
          UserRequest userRequest = new UserRequest();
          userRequest.setFirstName(firstName);
          userRequest.setLastName(lastName);
          userRequest.setEmail(email);
          userRequest.setPassword(password);
          userRequest.setRole(Role.valueOf(role.toUpperCase()));
          boolean isCreated = userService.createUser(userRequest);
          if (isCreated) {
              return "redirect:/login"; // Redirect to login page after successful registration
          } else {
              return "register"; // Stay on the registration page if creation fails
          }
      } catch (Exception e) {
          return "register"; // Stay on the registration page if an exception occurs
      }
  }

  @PostMapping("/login")
  public String login(@RequestParam String email, @RequestParam String password, HttpSession session) {
      UserResponse userResponse = userService.login(email, password);
      if (userResponse != null) {
          session.setAttribute("user", userResponse);
          if (userResponse.getRole() == Role.BUYER) {
              System.out.println("Redirecting to buyer dashboard");
              return "redirect:/buyer-dashboard";
          } else if (userResponse.getRole() == Role.SELLER) {
              System.out.println("Redirecting to seller dashboard");
              return "redirect:/seller-dashboard";
          } else {
              System.out.println("Unknown role, staying on login page");
              return "login";
          }
      } else {
          System.out.println("Authentication failed, staying on login page");
          return "login";
      }
  }
  @GetMapping("/logout")
  public String logout(HttpSession session) {
      session.invalidate(); // Invalidate the session
      return "redirect:/login"; // Redirect to login page
  }
}