package com.u2hee.app.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@Entity
//@Table(name = "member")
//@ToString(exclude = "coupons")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = {"id", "email"})
public class Member {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @Column(name = "name", nullable = false)
    private String name;

//    @Column(name = "email", nullable = false)
    private String email;
    
    private String uuid;

//    @CreationTimestamp
//    @Column(name = "create_at", nullable = false, updatable = false)
    private LocalDateTime createAt;

//    @UpdateTimestamp
//    @Column(name = "update_at", nullable = false)
    private LocalDateTime updateAt;

//    @OneToMany
//    @JoinColumn(name = "coupon_id")
//    private List<Coupon> coupons = new ArrayList<>();

    @Builder
    public Member(String email, String name) {
    	this.uuid = UUID.randomUUID().toString();
    	this.name = name;
        this.email = email;
    }
}