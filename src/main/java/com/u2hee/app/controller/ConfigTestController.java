package com.u2hee.app.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RefreshScope
public class ConfigTestController {

    @Value("${kasha.hello}")
    private String hello;

    @GetMapping("/config")
    public String configTest() {
        return hello;
    }
    
    @Value("${CF_INSTANCE_IP:127.0.0.1}")
    private String ip;

    @GetMapping("/redis")
    public Map<String, Object> redisTest(HttpSession session){
        UUID uid = Optional.ofNullable(UUID.class.cast(session.getAttribute("uid"))).orElse(UUID.randomUUID());
        session.setAttribute("uid", uid);

        Map<String, Object> map = new HashMap<>();
        map.put("instance_ip", this.ip);
        map.put("uuid", uid.toString());
        return map;
    }    
}

