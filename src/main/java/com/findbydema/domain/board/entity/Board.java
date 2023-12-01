package com.findbydema.domain.board.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.findbydema.domain.boardFunc.comment.entity.Comment;
import com.findbydema.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String viewId;

    private String writerSid;

    private String title;

    private String subtitle;

    private Date date;

    @JsonIgnore
    @OneToMany(mappedBy = "commentboard")
    private List<Comment> comments;

    @Column(name = "views", nullable = false)
    private Long views = 0L;

    @JsonIgnore
    @ManyToMany
    private List<User> like_users;

    @Column(name = "modified", nullable = false)
    private Boolean modified = false;

    @Builder
    public Board(Date date, String title, String subtitle, String writerSid, String viewId) {
        this.date = date;
        this.title = title;
        this.subtitle = subtitle;
        this.writerSid = writerSid;
        this.viewId = viewId;
        this.modified = false;
    }

    public void modify(String title, String subtitle) {
        this.title = title;
        this.subtitle = subtitle;
        this.modified = true;
    }
}
