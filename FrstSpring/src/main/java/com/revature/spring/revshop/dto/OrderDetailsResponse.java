package com.revature.spring.revshop.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class OrderDetailsResponse {

    private Long id;           // ID of the OrderDetails
    private Long orderId;      // ID of the associated Order
    private Long productId;    // ID of the associated Product

}