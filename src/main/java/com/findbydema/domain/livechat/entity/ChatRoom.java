package com.findbydema.domain.livechat.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.findbydema.domain.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_room_id")
    private Long id;

    private String roomId;

    private String roomName;

    @JsonIgnore
    @ManyToMany
    private List<User> join_users;

    public ChatRoom(String roomName, String roomId) {
        this.roomName = roomName;
        this.roomId = roomId;
    }

}
