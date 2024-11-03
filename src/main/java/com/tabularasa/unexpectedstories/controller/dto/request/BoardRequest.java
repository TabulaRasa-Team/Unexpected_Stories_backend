package com.tabularasa.unexpectedstories.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Data
public class BoardRequest {

    private String title;

    private String content;
}