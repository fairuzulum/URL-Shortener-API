package com.fairuz.shortify.service;

import com.fairuz.shortify.model.Url;
import com.fairuz.shortify.model.dto.UrlRequest;
import com.fairuz.shortify.model.dto.UrlResponse;
import com.fairuz.shortify.repository.UrlRepository;
import com.fairuz.shortify.exception.UrlNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UrlService {

    private final UrlRepository urlRepository;

    @Value("${app.base-url:http://localhost:8080}")
    private String baseUrl;

    public UrlResponse createShortUrl(UrlRequest request) {
        String shortCode = RandomStringUtils.randomAlphanumeric(6);

        Url url = Url.builder()
                .originalUrl(request.getOriginalUrl())
                .shortCode(shortCode)
                .createdAt(LocalDateTime.now())
                .visitCount(0)
                .build();

        urlRepository.save(url);

        String fullShortUrl = baseUrl + "/s/" + shortCode;
        return new UrlResponse(fullShortUrl, request.getOriginalUrl());
    }

    public String getOriginalUrl(String shortCode) {
        Url url = urlRepository.findByShortCode(shortCode)
                .orElseThrow(() -> new UrlNotFoundException("Short code not found: " + shortCode));

        url.setVisitCount(url.getVisitCount() + 1);
        urlRepository.save(url);

        return url.getOriginalUrl();
    }
}
