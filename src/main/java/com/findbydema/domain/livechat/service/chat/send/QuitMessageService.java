package com.findbydema.domain.livechat.service.chat.send;

import com.findbydema.domain.livechat.controller.dto.request.MessageRequest;
import com.findbydema.domain.livechat.service.chat.SaveMessageService;
import com.findbydema.domain.user.service.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class QuitMessageService {

    private final UserFacade userFacade;
    private final MessageFacade messageFacade;
    private final SaveMessageService saveMessageService;
    public void execute(MessageRequest message) {;
        message.setContent(userFacade.findBySid(message.getWriterSid()).getNickname() + "님이 채팅방에서 나갔습니다.");
        saveMessageService.execute(message);
        messageFacade.sendMessage(message);
    }
}
