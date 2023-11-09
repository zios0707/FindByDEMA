package com.findbydema.domain.livechat.repository;

import com.findbydema.domain.livechat.entity.ChatRecord;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecordRepository extends CrudRepository<ChatRecord, String> {
    Iterable<ChatRecord> findAllByRoomId(String roomId);

}
