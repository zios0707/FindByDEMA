package com.findbydema.domain.boardFunc.comment.controller.dto.response;

import com.findbydema.domain.boardFunc.comment.entity.Comment;
import com.findbydema.domain.user.controller.dto.response.UserResponse;
import com.findbydema.domain.user.service.UserFacade;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CommentResponse {
    private UserResponse ownUser;
    private String subtitle;
    private String viewId;
    private Date date;
    private Boolean modified;
    private Boolean deleted;
    private Boolean isYour;

    public CommentResponse(Comment comment, UserFacade userFacade) {
        this.ownUser = userFacade.sidToResponse(comment.getWriterSid());
        this.subtitle = comment.getSubtitle();
        this.viewId = comment.getViewId();
        this.date = comment.getDate();
        this.modified = comment.getModified();
        this.deleted = comment.getDeleted();
        this.isYour = userFacade.findBySid(comment.getWriterSid())
                .equals(userFacade.getInfo());
    }
}
