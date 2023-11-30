package com.findbydema.domain.boardFunc.like.controller;

import com.findbydema.domain.boardFunc.like.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/board/{viewId}")
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    @GetMapping("/like")
    public void Like(@PathVariable String viewId) {
        likeService.execute(viewId);
    }
}
