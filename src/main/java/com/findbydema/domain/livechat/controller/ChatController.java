package com.findbydema.domain.livechat.controller;

import com.findbydema.domain.livechat.controller.dto.request.MessageRequest;
import com.findbydema.domain.livechat.entity.ChatRecord;
import com.findbydema.domain.livechat.service.GetMessageListService;
import com.findbydema.domain.livechat.service.SaveMessageService;
import com.findbydema.domain.user.service.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/chat/{roomId}")
public class ChatController {

    private final SimpMessagingTemplate template; // Broker
    private final GetMessageListService getMessageListService;

    private final EnterMessageService enterMessageService;

    //Client 가 SEND 할 수 있는 경로
    //stompConfig 에서 설정한 applicationDestinationPrefixes 와 @MessageMapping 경로가 병합됨
    //"/pub/chat/enter"

    // 메시지 관련 API

    @MessageMapping(value = "/chat/enter")
    public void enter(MessageRequest message) {
        enterMessageService.execute(message);
    }

    @MessageMapping(value = "/chat/message")
    public void message(@PathVariable String roomId, MessageRequest message) {
        message.setRoomId(roomId);
        message.setWriter(userFacade.getInfo().getSid());
        saveMessageService.execute(message);

        template.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
    }

    @MessageMapping(value = "/chat/quit")
    public void quit(@PathVariable String roomId, MessageRequest message) {
        message.setRoomId(roomId);
        message.setWriter(userFacade.getInfo().getSid());
        message.setContent(message.getWriter() + "님이 채팅방에서 나갔습니다.");
        saveMessageService.execute(message);

        template.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
    }


    @GetMapping(value = "/records")
    public List<ChatRecord> getRecord(@PathVariable String roomId) {
        return getMessageListService.execute(roomId);
    }


}
