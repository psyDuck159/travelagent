package com.nashintern.travelagent.repository;

import com.nashintern.travelagent.model.User;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories
@EntityScan
public interface UserRepository extends JpaRepository<User, Long> {

//    @Query("SELECT u FROM users WHERE u.email = ?1")
    User findByEmail(String email);
}
