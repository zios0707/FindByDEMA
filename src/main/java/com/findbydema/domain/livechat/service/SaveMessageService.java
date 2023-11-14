package com.findbydema.domain.livechat.service;

import com.findbydema.domain.livechat.controller.dto.request.MessageRequest;
import com.findbydema.domain.livechat.entity.ChatRecord;
import com.findbydema.domain.livechat.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveMessageService {

    private final RecordRepository recordRepository;

    public void execute(MessageRequest message) {
        ChatRecord chatRecord = ChatRecord.builder()
                .writerId(message.getWriter())
                .content(message.getContent())
                .roomId(message.getRoomId())
                .build();

        recordRepository.save(chatRecord);
    }
}
