package com.example.assignment.repository;

import com.example.assignment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public static final String login = "SELECT password FROM users WHERE user_name=?1";
    @Query(value = login, nativeQuery = true)
    public String login(@Param("userName") String userName);
}
