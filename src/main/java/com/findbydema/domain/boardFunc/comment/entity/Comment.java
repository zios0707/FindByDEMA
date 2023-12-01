package com.findbydema.domain.boardFunc.comment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.findbydema.domain.board.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Comment extends Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String writerSid;

    private String subtitle;

    private String viewId;

    private Date date;

    private Boolean modified;

    private Boolean deleted;

    @ManyToOne
    @JsonIgnore
    private Board commentboard;

    public Comment(String writerSid, String subtitle, String viewId, Date date, Board commentboard) {
        this.writerSid = writerSid;
        this.subtitle = subtitle;
        this.viewId = viewId;
        this.date = date;
        this.commentboard = commentboard;
        modified = false;
        deleted = false;
    }

    public void Modify(String subtitle) {
        this.subtitle = subtitle;
        modified = true;
    }

    public void Delete() {
        deleted = true;
    }

}
