package com.example.spring_boot_application.controller;

import com.example.spring_boot_application.constant.ApiConstant;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = ApiConstant.HOME_API)
public class HomeController {

    @RequestMapping(value = ApiConstant.SLASH)
    public ResponseEntity<?> home() {
        return ResponseEntity.ok("Welcome Home");
    }
}
