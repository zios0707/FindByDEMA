package com.findbydema.domain.livechat.entity;

import lombok.*;
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
    @Column(name = "record_id")
    private Long id;

    @Indexed // 이거 안해주면 findAllByRoomId 작동을 안함
    private String roomId;

    private String writerSid;

    private String content;

    private LocalDateTime sendDate;

    public ChatRecord(String roomId, String writerSid, String content) {
        this.roomId = roomId;
        this.writerSid = writerSid;
        this.content = content;
        this.sendDate = LocalDateTime.now();
    }

}
