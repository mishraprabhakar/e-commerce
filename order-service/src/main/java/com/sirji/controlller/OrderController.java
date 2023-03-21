package com.sirji.controlller;

import com.sirji.dto.OrderRequest;
import com.sirji.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest){

        service.placeOrder(orderRequest);
        return "Order Placed Successfully";
    }
}
