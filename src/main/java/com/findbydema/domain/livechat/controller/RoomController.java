package com.findbydema.domain.livechat.controller;

import com.findbydema.domain.livechat.entity.DTO.ChatRoomDTO;
import com.findbydema.domain.livechat.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/chat/room")
public class RoomController {

    private final ChatRoomRepository chatRoomRepository;

    @GetMapping(value = "/")
    public List<ChatRoomDTO> getRooms() {
        return chatRoomRepository.findAllRooms();
    }

}
