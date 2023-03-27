package com.sirji.controller;

import com.sirji.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Map<String, Boolean>> isInStock(@RequestParam List<String> skuCode) {
        return service.isInStock(skuCode);
    }
}
