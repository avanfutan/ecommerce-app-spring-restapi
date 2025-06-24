package com.avanfutan.ecommerce.restapi.controllers;

import com.avanfutan.ecommerce.restapi.dtos.ProductDto;
import com.avanfutan.ecommerce.restapi.entities.Product;
import com.avanfutan.ecommerce.restapi.mappers.ProductMapper;
import com.avanfutan.ecommerce.restapi.repositories.CategoryRepository;
import com.avanfutan.ecommerce.restapi.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryRepository categoryRepository;

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

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(
            @RequestBody ProductDto productDto,
            UriComponentsBuilder builder) {
        var category = categoryRepository.findById(productDto.getCategoryId()).orElse(null);
        if (category == null) {
            return ResponseEntity.badRequest().build();
        }

        var product = productMapper.toEntity(productDto);
        product.setCategory(category);
        productRepository.save(product);
        productDto.setId(product.getId());
        var uriBuilder = builder.path("/products/{id}").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(uriBuilder).body(productDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(
            @PathVariable(name = "id") Long id,
            @RequestBody ProductDto productDto) {
        var category = categoryRepository.findById(productDto.getCategoryId()).orElse(null);
        if (category == null) {
            return ResponseEntity.badRequest().build();
        }


        var product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return ResponseEntity.badRequest().build();
        }

        product.setCategory(category);
        productMapper.update(productDto, product);
        productRepository.save(product);
        productDto.setId(product.getId());
        return ResponseEntity.ok(productDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable(name = "id") Long id) {
        var product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return ResponseEntity.badRequest().build();
        }

        productRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
