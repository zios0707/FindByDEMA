package com.findbydema.domain.livechat.controller.dto.response;

import com.findbydema.domain.livechat.entity.ChatRecord;
import com.findbydema.domain.user.controller.dto.response.UserResponse;
import com.findbydema.domain.user.service.UserFacade;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ChatRecordResponse {
    public String roomId;
    public UserResponse writer;
    public String content;
    public LocalDateTime sendDate;

    public ChatRecordResponse(ChatRecord chatRecord, UserFacade userFacade) {
        this.roomId = chatRecord.getRoomId();
        this.writer = userFacade.sidToResponse(chatRecord.getWriterSid());
        this.content = chatRecord.getContent();
        this.sendDate = chatRecord.getSendDate();
    }
}
