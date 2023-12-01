package com.findbydema.domain.livechat.controller.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageRequest {
    private String roomId;
    private String writerSid;
    private String content;
}
