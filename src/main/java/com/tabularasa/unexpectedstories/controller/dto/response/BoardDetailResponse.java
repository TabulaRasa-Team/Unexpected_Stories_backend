package com.tabularasa.unexpectedstories.controller.dto.response;

import com.tabularasa.unexpectedstories.domain.Board;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

// 자세히 보기 할때 사용
@Getter
public class BoardDetailResponse {
    private Long text_id;
    private String title;
    private String content;
    private String date;
    //private LocalDateTime date;

    public BoardDetailResponse(Board board) {
        this.text_id = board.getText_id();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.date = board.getDate();
    }
}