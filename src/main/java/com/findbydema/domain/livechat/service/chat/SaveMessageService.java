package com.findbydema.domain.livechat.service.chat;

import com.findbydema.domain.livechat.controller.dto.request.MessageRequest;
import com.findbydema.domain.livechat.entity.ChatRecord;
import com.findbydema.domain.livechat.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SaveMessageService {

    private final RecordRepository recordRepository;

    public void execute(MessageRequest message) {
        ChatRecord chatRecord = ChatRecord.builder()
                .writerSid(message.getWriterSid())
                .content(message.getContent())
                .roomId(message.getRoomId())
                .sendDate(LocalDateTime.now())
                .build();

        recordRepository.save(chatRecord);
    }
}
