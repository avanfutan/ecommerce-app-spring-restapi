package com.avanfutan.ecommerce.restapi.controllers;

import com.avanfutan.ecommerce.restapi.dtos.ProductDto;
import com.avanfutan.ecommerce.restapi.entities.Product;
import com.avanfutan.ecommerce.restapi.mappers.ProductMapper;
import com.avanfutan.ecommerce.restapi.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @GetMapping
    public List<ProductDto> getProducts(@RequestParam(required = false, name = "categoryId") Byte categoryId) {
        List<Product> products;
        if (categoryId != null) {
            products = productRepository.findByCategoryId(categoryId);
        } else {
            products = productRepository.findAllWithCategory();
        }
       return products
               .stream()
               .map(productMapper::toDto)
               .toList();
    }
}
