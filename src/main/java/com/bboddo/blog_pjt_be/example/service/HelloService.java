package com.bboddo.blog_pjt_be.example.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public String getGreeting() {
        return "hello!";
    }
}
