package com.fairuz.shortify.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UrlResponse {
    private String shortUrl;
    private String originalUrl;
}
