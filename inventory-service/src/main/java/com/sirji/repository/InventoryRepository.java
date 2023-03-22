package com.sirji.repository;

import com.sirji.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    List<Inventory> findBySkuCodeIn(Set<String> skuCode);

    boolean existsBySkuCode(String skuCode);
}

