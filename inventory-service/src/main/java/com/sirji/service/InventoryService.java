package com.sirji.service;

import com.sirji.dto.InventoryResponse;
import com.sirji.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository repository;

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCodes) {

        return repository.findBySkuCodeIn(skuCodes)
                .stream()
                .map(inventory -> InventoryResponse
                        .builder()
                        .skuCode(inventory.getSkuCode())
                        .isInStock(inventory.getQuantity() > 0)
                        .build())
                .toList();


    }
}
