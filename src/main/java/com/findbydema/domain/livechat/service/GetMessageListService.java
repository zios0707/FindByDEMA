package com.findbydema.domain.livechat.service;

import com.findbydema.domain.livechat.entity.ChatRecord;
import com.findbydema.domain.livechat.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetMessageListService {

    private final RecordRepository recordRepository;

    public List<ChatRecord> execute(String roomId) {
        return recordRepository.findAllByRoomId(roomId);
    }

}
