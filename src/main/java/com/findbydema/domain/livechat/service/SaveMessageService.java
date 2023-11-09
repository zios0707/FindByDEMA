package com.findbydema.domain.livechat.service;

import com.findbydema.domain.livechat.entity.ChatRecord;
import com.findbydema.domain.livechat.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveMessageService {

    private final RecordRepository recordRepository;

    public void execute(ChatRecord chatRecord) {
        recordRepository.save(chatRecord);
    }
}
