package com.sirji;

import com.sirji.dto.ProductRequest;
import com.sirji.dto.ProductResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {
    @LocalServerPort
    private int port;

    private String baseUrl = "http://localhost";

    private static RestTemplate restTemplate;

    @Autowired
    private TestH2Repository repository;

    @BeforeAll
    public static void init(){
        restTemplate = new RestTemplate();
    }

    @BeforeEach
    public void setUp(){
        baseUrl = baseUrl.concat(":").concat(port+"").concat("/api/product");
    }

    @Test
    public void testCreateProduct(){
        ProductResponse response = restTemplate
                .postForObject(baseUrl, getProductRequest(), ProductResponse.class);

        assertEquals("iphone 13", response.getName());
        assertEquals(1, repository.findAll().size());
    }

    private ProductRequest getProductRequest() {
        return ProductRequest
                .builder()
                .name("iphone 13")
                .description("description")
                .price(Long.valueOf(1234))
                .build();
    }

}
