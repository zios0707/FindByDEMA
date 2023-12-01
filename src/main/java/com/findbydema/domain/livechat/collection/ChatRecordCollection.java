package com.findbydema.domain.livechat.collection;

import com.findbydema.domain.livechat.controller.dto.response.ChatRecordResponse;
import com.findbydema.domain.livechat.entity.ChatRecord;
import com.findbydema.domain.user.service.UserFacade;

import java.util.List;

public class ChatRecordCollection {
    private final List<ChatRecord> chatRecords;
    private final UserFacade userFacade;

    public ChatRecordCollection(List<ChatRecord> chatRecords, UserFacade userFacade) {
        this.chatRecords = chatRecords;
        this.userFacade = userFacade;
    }

    public List<ChatRecordResponse> toResponse() {
        return chatRecords.stream()
                .map(chatRecord -> new ChatRecordResponse(chatRecord, userFacade))
                .toList();
    }
}
