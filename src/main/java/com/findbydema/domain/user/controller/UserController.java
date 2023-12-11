package com.findbydema.domain.user.controller;

import com.findbydema.domain.user.controller.dto.request.PatchUserRequest;
import com.findbydema.domain.user.controller.dto.response.UserResponse;
import com.findbydema.domain.user.service.GetMyInfoService;
import com.findbydema.domain.user.service.PatchUserService;
import com.findbydema.domain.user.service.SearchBySidService;
import com.findbydema.domain.user.service.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final PatchUserService patchUserService;
    private final GetMyInfoService getMyInfoService;
    private final SearchBySidService searchBySidService;

    @GetMapping("/")
    public UserResponse getMyInfo() {
        return getMyInfoService.execute();
    }

    @GetMapping("/{SID}")
    public UserResponse getBySID(@PathVariable String SID) {
        return searchBySidService.execute(SID);
    }

    @PatchMapping("/")
    public void patch(@RequestBody PatchUserRequest patchUserRequest) {
        patchUserService.execute(patchUserRequest);
    }




}
