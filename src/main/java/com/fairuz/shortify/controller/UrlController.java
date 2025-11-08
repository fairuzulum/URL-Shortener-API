package com.fairuz.shortify.controller;

import com.fairuz.shortify.model.dto.UrlRequest;
import com.fairuz.shortify.model.dto.UrlResponse;
import com.fairuz.shortify.service.UrlService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
@RestController
@RequiredArgsConstructor
public class UrlController {

    private final UrlService urlService;

    @PostMapping("/api/shorten")
    public ResponseEntity<UrlResponse> shortenUrl(@RequestBody @Valid UrlRequest request) {
        UrlResponse response = urlService.createShortUrl(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/s/{code}")
    public void redirectToOriginalUrl(@PathVariable String code, HttpServletResponse response) throws IOException {
        String originalUrl = urlService.getOriginalUrl(code);
        response.sendRedirect(originalUrl);
    }

    @GetMapping("/api/info/{code}")
    public ResponseEntity<UrlResponse> getUrlInfo(@PathVariable String code) {
        UrlResponse response = urlService.getUrlInfo(code);
        return ResponseEntity.ok(response);
    }
}
