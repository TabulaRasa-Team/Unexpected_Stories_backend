package com.tabularasa.unexpectedstories.controller.dto.response;

import com.tabularasa.unexpectedstories.domain.Board;
import lombok.Getter;

// 전체 보기 할때 사용
@Getter
public class BoardResponse {
    private Long textId;
    private String title;
    private String content;
    private String date;
    private String busStop;
    private Integer like;
    private Integer sad;
    private Integer love;
    private Integer view;

    public BoardResponse(Board board) {
        this.textId = board.getTextId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.date = board.getDate();
        this.busStop = board.getBusStop();
        this.like = board.getFeelingLike();
        this.sad = board.getFeelingSad();
        this.love = board.getFeelingLove();
        this.view = board.getCountView();
    }

    public Board updateView(Board board) {
        board.updateView(this.view);
        return board;
    }
}
