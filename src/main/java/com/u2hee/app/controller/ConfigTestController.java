package com.u2hee.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.u2hee.app.model.Member;
import com.u2hee.app.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RefreshScope
@RequiredArgsConstructor
@RestController
@RequestMapping("/test")
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
    
    private final MemberRepository memberRepository;
    
    @PostMapping("/member")
    public void save() {
    	log.info("!!");
    	
    	Member member = Member.builder().name(UUID.randomUUID().toString()).email(UUID.randomUUID().toString()).build();
    	log.info(member.toString());
    	memberRepository.save(member);
    	log.info(member.toString());
    }
    
    @GetMapping("/member")
    public List<Member> findAll() {
    	log.info("!!");
    	return memberRepository.findAll();
    }

    @GetMapping("/member/{id}")
    public Member findById(@PathVariable(name = "id") long id) {
    	log.info("!!");
    	return memberRepository.findById(id).orElse(null);
    }
}

