package com.findbydema.domain.boardFunc.comment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.findbydema.domain.board.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Comment extends Board {
    @Id
    @JsonIgnore
    private Long id;

    private String writerSid;

    private String subtitle;

    private String viewId;

    private Date date;

    private Boolean modified;

    @ManyToOne
    @JsonIgnore
    private Board comment_board;

    @Builder
    public Comment(String writerSid, String subtitle, String viewId, Date date, Board comment_board) {
        this.writerSid = writerSid;
        this.subtitle = subtitle;
        this.viewId = viewId;
        this.date = date;
        this.comment_board = comment_board;
        modified = false;
    }

    public void Modify(String subtitle) {
        this.subtitle = subtitle;
        modified = true;
    }

}
