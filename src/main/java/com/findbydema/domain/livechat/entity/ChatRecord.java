package com.findbydema.domain.livechat.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import javax.persistence.*;
import java.time.LocalDateTime;

@RedisHash(value = "record", timeToLive = 25)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ChatRecord {

    @Id
    private String id;

    @Indexed // 이거 안해주면 findAllByRoomId 작동을 안함
    private String roomId;

    private String writerId;

    private String content;

    private LocalDateTime sendDate;

    public ChatRecord(String roomId, String writerId, String content) {
        this.roomId = roomId;
        this.writerId = writerId;
        this.content = content;
        this.sendDate = LocalDateTime.now();
    }

}
