package com.u2hee.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "member")
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = false)
public class Member extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;
//
//    @CreationTimestamp
//    @Column(name = "create_at", nullable = true, updatable = false)
//    private LocalDateTime createAt;
//
//    @UpdateTimestamp
//    @Column(name = "update_at", nullable = true)
//    private LocalDateTime updateAt;
    
    @Column(name = "is_deleted", nullable = true)
    private Boolean isDeleted;

    @Builder public Member(String email, String name) {
        this.name = name;
        this.email = email;
    }

    @PrePersist
    void prePersist(){
        this.isDeleted = false;
    }
    
    public void delete(){
        this.isDeleted = true;
    }
}