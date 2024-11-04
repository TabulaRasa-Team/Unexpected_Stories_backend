package com.tabularasa.unexpectedstories.controller;

import com.tabularasa.unexpectedstories.controller.dto.request.BoardRequest;
import com.tabularasa.unexpectedstories.controller.dto.response.BoardDetailResponse;
import com.tabularasa.unexpectedstories.controller.dto.response.BoardResponse;
import com.tabularasa.unexpectedstories.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/board")
@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Long save(@RequestBody BoardRequest request){
        System.out.println("Received request: " + request); // 요청 데이터 로그 확인
        return boardService.save(request);
    }

    @GetMapping()
    public List<BoardResponse> findAll(){
        return boardService.findAll();
    }

    @GetMapping("/{text_id}")
    public BoardDetailResponse findByText_id(@PathVariable Long text_id){
        return boardService.findByText_id(text_id);
    }

    @GetMapping(value = "/count")
    public Map<String, Integer> countAll(){
        Map<String, Integer> counting = new HashMap<>();
        counting.put("count", boardService.countAll());
        return counting;
    }
/*
    @GetMapping(value = "/count", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Integer> countAll() {
        Integer count = boardService.countAll();
        Map<String, Integer> response = new HashMap<>();
        response.put("count", count);
        return response;
    }
 */
    @PutMapping(value = "/{text_id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long text_id, @RequestBody BoardRequest request){
        boardService.update(text_id, request);
    }

    @DeleteMapping("/{text_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long text_id){
        boardService.delete(text_id);
    }
}