package com.findbydema.domain.livechat.repository;

import com.findbydema.domain.livechat.entity.ChatRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepository extends CrudRepository<ChatRecord, String> {
    Iterable<ChatRecord> findAllByRoomId(String roomId);

}
