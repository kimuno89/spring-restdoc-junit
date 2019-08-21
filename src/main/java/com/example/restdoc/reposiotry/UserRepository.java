package com.example.restdoc.reposiotry;

import com.example.restdoc.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * com.example.restdoc.reposiotry
 *    |_ UserRepository
 *
 * </pre>
 *
 * @author : 김윤호
 * @version :
 * @date : 2019-08-16 11:02
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
