package com.findbydema.domain.board.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Board {
    @Id
    private String id;

    private String viewId;

    private String title;

    private String subtitle;

    // 기타 내용은 스터디 레포에 있는 게시판 기능을 모두 갖고 오면 될 듯.

}
