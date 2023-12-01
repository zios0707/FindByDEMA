package com.findbydema.domain.livechat.service.chat;

import com.findbydema.domain.livechat.collection.ChatRecordCollection;
import com.findbydema.domain.livechat.controller.dto.response.ChatRecordResponse;
import com.findbydema.domain.livechat.entity.ChatRecord;
import com.findbydema.domain.livechat.repository.RecordRepository;
import com.findbydema.domain.user.service.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetMessageListService {

    private final RecordRepository recordRepository;
    private final UserFacade userFacade;

    public List<ChatRecordResponse> execute(String roomId) {
        List<ChatRecord> list = recordRepository.findAllByRoomId(roomId);
        ChatRecordCollection collection = new ChatRecordCollection(list, userFacade);
        return collection.toResponse();
    }

}
