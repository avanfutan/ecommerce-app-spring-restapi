package com.avanfutan.ecommerce.restapi.mappers;

import com.avanfutan.ecommerce.restapi.dtos.ProductDto;
import com.avanfutan.ecommerce.restapi.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "category.id", target = "categoryId")
    public ProductDto toDto(Product product);
}
