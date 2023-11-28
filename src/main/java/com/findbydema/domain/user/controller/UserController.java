package com.findbydema.domain.user.controller;

import com.findbydema.domain.user.controller.dto.request.PatchUserRequest;
import com.findbydema.domain.user.controller.dto.response.UserResponse;
import com.findbydema.domain.user.entity.User;
import com.findbydema.domain.user.service.PatchUserService;
import com.findbydema.domain.user.service.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final PatchUserService patchUserService;
    private final UserFacade userFacade;

    // COMMON

    @GetMapping("/")
    public UserResponse getMyPage() {
        User user = userFacade.getInfo();

        return UserResponse.builder()
                .nickname(user.getNickname())
                .sid(user.getSid())
                .img(user.getImg())
                .makeDate(new Date())
                .build();
    }

    @GetMapping("/{SID}")
    public UserResponse getFromSID(@PathVariable String SID) {
        User user = userFacade.findBySid(SID);

        return UserResponse.builder()
                .nickname(user.getNickname())
                .sid(user.getSid())
                .img(user.getImg())
                .makeDate(new Date())
                .build();
    }

    @PatchMapping("/patch")
    public void patch(@RequestBody PatchUserRequest patchUserRequest) {
        patchUserService.execute(patchUserRequest);
    }




}
