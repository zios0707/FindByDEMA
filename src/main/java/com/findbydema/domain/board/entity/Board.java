package com.findbydema.domain.board.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.findbydema.domain.boardFunc.comment.entity.Comment;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Board {
    @Id
    private String id;

    private String viewId;

    private String writerSid;

    private String title;

    private String subtitle;

    private Date date;

    @Column(name = "num_of_comments")
    private Long comment = 0L;

    @JsonIgnore
    @OneToMany(mappedBy = "comment_board")
    private List<Comment> comments = new ArrayList<>();

    @Column(name = "views", nullable = false)
    private Long views = 0L;

    @Column(name = "likes", nullable = false)
    private Long likes = 0L;

//    @JsonIgnore
//    @OneToMany(mappedBy = "like_board")
//    private List<LikeBoards> likeBoards = new ArrayList<>();

    @Column(name = "modified", nullable = false)
    private Boolean modified = false;

    @Builder
    public Board(Date date, String title, String subtitle, String writerSid, String path) {
        this.date = date;
        this.title = title;
        this.subtitle = subtitle;
        this.writerSid = writerSid;
        this.viewId = path;
    }

    public void modify(String title, String subtitle) {
        this.title = title;
        this.subtitle = subtitle;
        this.modified = true;
    }
}
