package com.fairuz.shortify.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UrlRequest {
    @NotBlank(message = "Original URL cannot be blank")
    private String originalUrl;
}
