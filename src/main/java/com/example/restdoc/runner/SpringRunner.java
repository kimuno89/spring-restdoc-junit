package com.example.restdoc.runner;

import com.example.restdoc.domain.User;
import com.example.restdoc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <pre>
 * com.example.restdoc.runner
 *    |_ SpringRunner
 *
 * </pre>
 *
 * @author : 김윤호
 * @version :
 * @date : 2019-08-16 14:21
 */
@Component
public class SpringRunner implements ApplicationRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user = User.builder()
                .loginId("yh_kim")
                .name("김윤호")
                .number("010-6261-5283")
                .age(31)
                .build();

        User a = userService.saveUser(user);

        List<User> userList = userService.findAll();
    }
}
