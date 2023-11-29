package com.findbydema.domain.board.controller;

import com.findbydema.domain.board.controller.dto.request.CreateBoardRequest;
import com.findbydema.domain.board.controller.dto.request.ModifyBoardRequest;
import com.findbydema.domain.board.controller.dto.response.BoardResponse;
import com.findbydema.domain.board.controller.dto.response.GetBoardResponse;
import com.findbydema.domain.board.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardController {

    private final CreateBoardService createBoardService;
    private final ModifyBoardService modifyBoardService;
    private final DeleteBoardService deleteBoardService;
    private final GetListBoardService getListBoardService;
    private final GetBoardService getBoardService;

    @PostMapping("/post")
    public BoardResponse CreateBoard(@RequestBody CreateBoardRequest createBoardRequest) {
        return createBoardService.execute(createBoardRequest);
    }

    @GetMapping("/page/{offset}")
    public List<BoardResponse> GetListBoard(@PathVariable Long offset) {
        return getListBoardService.execute(offset);
    }

    @PatchMapping("/{viewId}")
    public BoardResponse ModifyBoard(@PathVariable String viewId, @RequestBody ModifyBoardRequest modifyBoardRequest) {
        return modifyBoardService.execute(modifyBoardRequest, viewId);
    }

    @GetMapping("/{viewId}")
    public GetBoardResponse getBoard(@PathVariable String viewId) {
        return getBoardService.execute(viewId);
    }

    @DeleteMapping("/{viewId}")
    public void DeleteBoard(@PathVariable String viewId) {
        deleteBoardService.execute(viewId);
    }
}
