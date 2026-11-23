package com.example.labsp.controllers;

import com.example.labsp.difexample.ClientComponent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final ClientComponent clientComponent;

    public HelloController(ClientComponent clientComponent) {
        this.clientComponent = clientComponent;
    }

    @GetMapping("/")
    public String sayHello() {
        return "Hello from ClientComponent = " + clientComponent;
    }
}