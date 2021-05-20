package com.u2hee.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.u2hee.app.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
    
}