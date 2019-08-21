package com.example.restdoc.service;

import com.example.restdoc.domain.User;
import com.example.restdoc.reposiotry.UserRepository;
import com.example.restdoc.response.ApiResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <pre>
 * com.example.restdoc.service
 *    |_ UserService
 *
 * </pre>
 *
 * @author : 김윤호
 * @version :
 * @date : 2019-08-16 14:14
 */
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

}
