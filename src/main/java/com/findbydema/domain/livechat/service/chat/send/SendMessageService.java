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
public class SendMessageService {

    private final MessageFacade messageFacade;
    private final SaveMessageService saveMessageService;
    public void execute(MessageRequest message) {
        saveMessageService.execute(message);
        messageFacade.sendMessage(message);
    }
}
