package com.findbydema.domain.livechat.controller.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Builder
public class ChattingRoomRequest {
    private String roomId;
}
