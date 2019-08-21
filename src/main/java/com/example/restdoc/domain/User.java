package com.example.restdoc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * <pre>
 * com.example.restdoc.domain
 *    |_ User
 *
 * </pre>
 *
 * @author : 김윤호
 * @version :
 * @date : 2019-08-16 10:58
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String loginId;
    private String number;
    private int age;

    @Builder
    public User(Long id, String name, String loginId, String number, int age) {
        this.id = id;
        this.name = name;
        this.loginId = loginId;
        this.number = number;
        this.age = age;
    }
}
