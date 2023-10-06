package com.findbydema.domain.user.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickname;// 사용할 닉네임

    private String StudentID;// X(학년)X(반)XX(번호) 형식으로 저장 예) 1101 -> 1학년 1반 1번

    private String email;   // 이메일

    private String password;// 비밀번호

    private String img;     // 이미지 링크

    //private Date makeDate;  // 계정 생성일
}
