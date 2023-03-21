package com.sirji;

import com.sirji.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestH2Repository extends JpaRepository<Product, Integer> {
}
