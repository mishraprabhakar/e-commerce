package com.sirji.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class ProductRequest {
    @NotBlank(message = "name should not be blank")
    private String name;
    @NotEmpty(message = "description should not be empty")
    private String description;
    @NotNull(message = "Price cannot be blank")
    private Long price;
}
