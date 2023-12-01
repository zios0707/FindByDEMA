package com.findbydema.domain.livechat.service.chat.send;

import com.findbydema.domain.livechat.controller.dto.request.MessageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageFacade {
    private final SimpMessagingTemplate template; // Broker

    public void sendMessage(MessageRequest message) {
        template.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
    }
}
