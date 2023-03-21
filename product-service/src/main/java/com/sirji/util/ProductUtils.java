package com.sirji.util;

import com.sirji.dto.ProductResponse;
import com.sirji.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductUtils {

    public ProductResponse mapToProductResponse(Product product){
        return ProductResponse
                .builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
