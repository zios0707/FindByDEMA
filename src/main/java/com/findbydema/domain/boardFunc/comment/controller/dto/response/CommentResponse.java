package com.findbydema.domain.boardFunc.comment.controller.dto.response;

import com.findbydema.domain.user.controller.dto.response.UserResponse;
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

    public CommentResponse(UserResponse ownUser, String subtitle, String viewId, Date date, Boolean modified) {
        this.ownUser = ownUser;
        this.subtitle = subtitle;
        this.viewId = viewId;
        this.date = date;
        this.modified = modified;
    }
}
