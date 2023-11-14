package com.findbydema.domain.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.findbydema.domain.livechat.entity.ChatRoom;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String nickname;// 사용할 닉네임

    private String sid;     // X(학년)X(반)XX(번호) 형식으로 저장 예) 1101 -> 1학년 1반 1번

    private String email;   // 이메일

    @JsonIgnore
    private String password;// 비밀번호

    private String img;     // 이미지 링크

    //private Date makeDate;  // 계정 생성일

    @ManyToMany(mappedBy = "users")
    private List<ChatRoom> chatRooms;

    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Builder
    public User(String nickname, String sid, String email, String password, String img) {
        this.nickname = nickname;
        this.sid = sid;
        this.email = email;
        this.password = password;
        this.img = img;
    }
}
