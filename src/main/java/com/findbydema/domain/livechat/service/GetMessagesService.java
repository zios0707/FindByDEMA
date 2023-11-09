package com.findbydema.domain.livechat.service;

import com.findbydema.domain.livechat.entity.ChatRecord;
import com.findbydema.domain.livechat.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetMessagesService {

    private final RecordRepository recordRepository;

    public Iterable<ChatRecord> execute(String roomId) {
        return recordRepository.findAllByRoomId(roomId);
    }

}
