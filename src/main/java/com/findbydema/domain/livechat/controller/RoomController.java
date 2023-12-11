package com.findbydema.domain.livechat.controller;

import com.findbydema.domain.livechat.controller.dto.request.CreateRoomRequest;
import com.findbydema.domain.livechat.controller.dto.response.ChatRoomIdResponse;
import com.findbydema.domain.livechat.controller.dto.response.ChatRoomResponse;
import com.findbydema.domain.livechat.service.room.CreateRoomService;
import com.findbydema.domain.livechat.service.room.GetRoomsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/chat/")
public class RoomController {

    private final GetRoomsService getRoomsService;
    private final CreateRoomService createRoomService;

    @GetMapping("/")
    public List<ChatRoomResponse> getRooms() {
        return getRoomsService.execute();
    }

    @PostMapping("/")
    public ChatRoomIdResponse createRoom(@RequestBody CreateRoomRequest createRoomRequest) {
        return createRoomService.execute(createRoomRequest);
    }

}
