package com.jongyeon.springbootcommunityweb.web.repository;

import com.jongyeon.springbootcommunityweb.web.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String s);
}
