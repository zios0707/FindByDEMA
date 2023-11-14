package com.findbydema.domain.livechat.repository;

import com.findbydema.domain.livechat.entity.ChatRoom;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@RedisHash
@Repository
public interface ChatRoomRepository extends CrudRepository<ChatRoom, String> {

    Optional<ChatRoom> findById(String s);
    Optional<ChatRoom> findByRoomId(String s);
}
