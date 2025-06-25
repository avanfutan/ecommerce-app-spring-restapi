package com.avanfutan.ecommerce.restapi.dtos;

import lombok.Data;

@Data
public class AddItemToCartRequest {
    private Long productId;
}
