package com.sirji.service;

import com.sirji.dto.InventoryResponse;
import com.sirji.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository repository;

    @Transactional(readOnly = true)
    public List<Map<String, Boolean>> isInStock(List<String> skuCodes) {

        List<Map<String, Boolean>> inventories = new ArrayList<>();

        Set<String> skuCode = new HashSet<>();


        for (String s: skuCodes) {
            if (repository.existsBySkuCode(s)){
                skuCode.add(s);
            }else{
                inventories.add(Map.of(s, false));
            }
        }

        List<InventoryResponse> inventoryResponses =
                repository
                        .findBySkuCodeIn(skuCode)
                        .stream()
                        .map(inventory -> InventoryResponse
                                .builder()
                                .inventories(Map.of(inventory.getSkuCode(), inventory.getQuantity()>0))
                                .build())
                        .toList();

        for (InventoryResponse i: inventoryResponses) {
            inventories.add(i.getInventories());
        }
        return inventories;

    }
}
