package com.avanfutan.ecommerce.restapi.mappers;

import com.avanfutan.ecommerce.restapi.dtos.ProductDto;
import com.avanfutan.ecommerce.restapi.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "category.id", target = "categoryId")
    ProductDto toDto(Product product);

    Product toEntity(ProductDto dto);
    @Mapping(target = "id", ignore = true)
    void update(ProductDto dto, @MappingTarget Product product);
}
