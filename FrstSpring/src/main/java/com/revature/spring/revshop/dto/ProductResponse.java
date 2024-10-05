package com.revature.spring.revshop.dto;

import com.revature.spring.revshop.model.Product;
import com.revature.spring.revshop.model.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ProductResponse {
	private Long id;
	private String name;
	private String description;
    private Long userId;
	private Double price;

}