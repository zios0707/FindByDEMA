package com.findbydema.domain.livechat.controller;

import com.findbydema.domain.livechat.controller.dto.request.CreateRoomRequest;
import com.findbydema.domain.livechat.controller.dto.response.ChattingRoomRequest;
import com.findbydema.domain.livechat.entity.ChatRoom;
import com.findbydema.domain.livechat.repository.ChatRoomRepository;
import com.findbydema.domain.livechat.service.CreateRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/chat/")
public class RoomController {

    private final ChatRoomRepository chatRoomRepository;
    private final CreateRoomService createRoomService;

    @GetMapping("/")
    public Iterable<ChatRoom> getRooms() {
        return chatRoomRepository.findAll();
    }

    @PostMapping("/")
    public ChattingRoomRequest createRoom(@RequestBody CreateRoomRequest createRoomRequest) {
        return createRoomService.execute(createRoomRequest);
    }

}
