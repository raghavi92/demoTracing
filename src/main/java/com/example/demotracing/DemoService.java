package com.example.demotracing;

import org.springframework.stereotype.Service;

@Service
public class DemoService {
    public String test() {
        throw new RuntimeException("oops");
    }
}
