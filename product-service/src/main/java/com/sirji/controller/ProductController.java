package com.sirji.controller;

import com.sirji.dto.ProductRequest;
import com.sirji.dto.ProductResponse;
import com.sirji.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody @Valid ProductRequest productRequest){
        productService.createProduct(productRequest);
    }

     @GetMapping
     public List<ProductResponse> getAllProducts(){
        return productService.getAllProducts();
     }
}
