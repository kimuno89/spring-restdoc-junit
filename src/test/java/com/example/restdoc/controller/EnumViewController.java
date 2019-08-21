package com.example.restdoc.controller;

import com.example.restdoc.response.ApiResponseCode;
import com.example.restdoc.response.ApiResponseDto;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnumViewController {

    @GetMapping("/docs")
    @SuppressWarnings("unchecked")
    public ApiResponseDto<Docs> findAll() {

        Map<String, String> apiResponseCodes = Arrays.stream(ApiResponseCode.values())
                .collect(Collectors.toMap(ApiResponseCode::name, ApiResponseCode::getText));
        ApiResponseDto responseDto =  ApiResponseDto.createOK(
            Docs.builder()
                .apiResponseCodes(apiResponseCodes)
                .build()
        );
        return responseDto;
    }
}
