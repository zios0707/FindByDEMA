package com.findbydema.domain.livechat.controller;

import com.findbydema.domain.livechat.entity.DTO.ChatRoomDTO;
import com.findbydema.domain.livechat.entity.ChatRoom;
import com.findbydema.domain.livechat.repository.ChatRoomRepository;
import com.findbydema.domain.livechat.service.CreateRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/chat/")
public class RoomController {

    private final ChatRoomRepository chatRoomRepository;

    @GetMapping("/")
    public Iterable<ChatRoom> getRooms() {
        return chatRoomRepository.findAll();
    }

}
