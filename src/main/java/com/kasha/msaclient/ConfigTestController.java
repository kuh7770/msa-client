package com.kasha.msaclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@RestController
@RefreshScope
public class ConfigTestController {

    @Value("${kasha.hello}")
    private String str;

    @GetMapping("/test")
    public String test() {
        return str;
    }
}

