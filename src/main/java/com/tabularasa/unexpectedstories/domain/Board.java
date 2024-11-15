package com.tabularasa.unexpectedstories.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@NoArgsConstructor
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long text_id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 2000)
    private String content;

    @CreatedDate// 엔티티가 생성될때 자동으로 기록됨
    @Column(updatable = false) // 한번 올라가면 수정 불가
    //private LocalDateTime date; // LocalDate 이용해 날짜 지정
    private String date;

    @Column(nullable = false)
    private String busstop;

    @Builder
    public Board(String title, String content, String busstop) {
        this.title = title;
        this.content = content;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd.HH.mm");
        this.date = LocalDateTime.now().format(formatter);
        this.busstop = busstop;

    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
