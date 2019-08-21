package com.example.restdoc.controller;

import java.util.Map;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Docs {

    Map<String, String> apiResponseCodes;

    @Builder
    public Docs(Map<String, String> apiResponseCodes) {
        this.apiResponseCodes = apiResponseCodes;
    }
}
