package com.fairuz.shortify.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class UrlResponse {
    private String shortUrl;
    private String originalUrl;
    private LocalDateTime createdAt;
    private Integer visitCount;
}
