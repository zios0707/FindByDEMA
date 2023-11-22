package com.findbydema.domain.board.controller;

import com.findbydema.domain.board.controller.dto.request.CreateBoardRequest;
import com.findbydema.domain.board.controller.dto.request.ModifyBoardRequest;
import com.findbydema.domain.board.controller.dto.response.BoardResponse;
import com.findbydema.domain.board.controller.dto.response.GetBoardResponse;
import com.findbydema.domain.board.service.CreateBoardService;
import com.findbydema.domain.board.service.DeleteBoardService;
import com.findbydema.domain.board.service.ModifyBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardController {

    private final CreateBoardService createBoardService;
    private final ModifyBoardService modifyBoardService;
    private final DeleteBoardService deleteBoardService;

    @PostMapping("/post")
    public BoardResponse CreateBoard(@RequestBody CreateBoardRequest createBoardRequest) {
        return createBoardService.execute(createBoardRequest);
    }

    @PatchMapping("/{viewId}")
    public BoardResponse ModifyBoard(@PathVariable String viewId, @RequestBody ModifyBoardRequest modifyBoardRequest) {
        return modifyBoardService.execute(modifyBoardRequest, viewId);
    }

    @GetMapping("/{viewId}")
    public GetBoardResponse getBoard(@PathVariable String viewId) {
        return
    }

    @DeleteMapping("/{viewId}")
    public void DeleteBoard(@PathVariable String viewId) {
        deleteBoardService.execute(viewId);
    }
}
