package com.findbydema.domain.livechat.repository;

import com.findbydema.domain.livechat.entity.ChatRoom;
import com.findbydema.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom, String> {
    Optional<ChatRoom> findByRoomId(String s);

    List<ChatRoom> findAllByJoin_users(User user);

}
