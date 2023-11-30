package com.findbydema.domain.livechat.controller.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ChattingRoomRequest {
    private String roomId;
}
