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
public class OrderDetailsRequest {
    
    private Long orderId;    // Assuming order ID is passed as Long
    private Long productId;  // Assuming product ID is passed as Long

}