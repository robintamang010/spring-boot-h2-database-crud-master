package com.users.spring.jpa.h2.repository;

import com.users.spring.jpa.h2.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}