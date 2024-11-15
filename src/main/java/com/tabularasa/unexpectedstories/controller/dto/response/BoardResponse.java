package com.tabularasa.unexpectedstories.controller.dto.response;

import com.tabularasa.unexpectedstories.domain.Board;
import lombok.Getter;

// 전체 보기 할때 사용
@Getter
public class BoardResponse {
    private Long text_id;
    private String title;
    private String content;
    private String date;
    private String busstop;

    public BoardResponse(Board board) {
        this.text_id = board.getText_id();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.date = board.getDate();
        this.busstop = board.getBusstop();
    }
}
