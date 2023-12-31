package com.findbydema.domain.board.controller;

import com.findbydema.domain.board.controller.dto.request.CreateBoardRequest;
import com.findbydema.domain.board.controller.dto.request.GetListBoardRequest;
import com.findbydema.domain.board.controller.dto.request.ModifyBoardRequest;
import com.findbydema.domain.board.controller.dto.response.BoardViewIdResponse;
import com.findbydema.domain.board.controller.dto.response.GetBoardResponse;
import com.findbydema.domain.board.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
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

    @PostMapping("/")
    private BoardViewIdResponse CreateBoard(@RequestBody CreateBoardRequest createBoardRequest) {
        return createBoardService.execute(createBoardRequest);
    }

    @GetMapping("/page/{offset}")
    private List<GetBoardResponse> GetListBoard(@PathVariable Long offset, @RequestBody GetListBoardRequest getListBoardRequest) {
        return getListBoardService.execute(offset, getListBoardRequest);
    }

    @PatchMapping("/{viewId}")
    private BoardViewIdResponse ModifyBoard(@PathVariable String viewId, @RequestBody ModifyBoardRequest modifyBoardRequest) {
        return modifyBoardService.execute(modifyBoardRequest, viewId);
    }

    @GetMapping("/{viewId}")
    private GetBoardResponse getBoard(@PathVariable String viewId, @CookieValue(name = "viewCount", required = false) String lookList, HttpServletResponse response) {
        return getBoardService.execute(viewId, response, lookList);
    }

    @DeleteMapping("/{viewId}")
    private void DeleteBoard(@PathVariable String viewId) {
        deleteBoardService.execute(viewId);
    }
}
