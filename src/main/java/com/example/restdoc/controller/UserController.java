package com.example.restdoc.controller;

import com.example.restdoc.domain.User;
import com.example.restdoc.response.ApiResponseDto;
import com.example.restdoc.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <pre>
 * com.example.restdoc.controller
 *    |_ UserController
 *
 * </pre>
 *
 * @author : 김윤호
 * @version :
 * @date : 2019-08-16 10:59
 */
@RestController
@RequestMapping(path = {"/api"}, produces = "application/json; charset=utf-8")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/allUsers")
    public ApiResponseDto findAllUser() {
        return ApiResponseDto.createOK(userService.findAll());
    }
}
