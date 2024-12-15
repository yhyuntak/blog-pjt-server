package com.bboddo.blog_pjt_be.example.repository;

import com.bboddo.blog_pjt_be.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
