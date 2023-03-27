package com.sirji.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventoryResponse {
//    private String skuCode;
//    private boolean isInStock;

    private Map<String,Boolean> inventories;
}
