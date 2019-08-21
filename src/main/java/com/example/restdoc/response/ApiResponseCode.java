package com.example.restdoc.response;

import com.example.restdoc.utils.EnumType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public enum ApiResponseCode implements EnumType {
    OK("Success."),
    BAD_PARAMETER("invalid parameter."),
    NOT_FOUND("Not Found Resources."),
    UNAUTHORIZED("UNAUTHORIZED"),
    SERVER_ERROR("Internal Server Error");

    private final String message;

    public String getId() {
        return name();
    }

    @Override
    public String getText() {
        return message;
    }
}
