package com.tabularasa.unexpectedstories.controller;

import com.tabularasa.unexpectedstories.controller.dto.request.BoardRequest;
import com.tabularasa.unexpectedstories.controller.dto.response.BoardResponse;
import com.tabularasa.unexpectedstories.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/board")
@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

    // Create
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Long save(@RequestBody BoardRequest request){
        System.out.println("Received request: " + request); // 요청 데이터 로그 확인
        return boardService.save(request);
    }

    // Get - all
    @GetMapping()
    public List<BoardResponse> findAll(){
        return boardService.findAll();
    }

    // random 하면 리스트를 받아와서 그 길이 중에서 랜덤함수로 그 번째 리스트 값을 보낸다
    @GetMapping("/random")
    public BoardResponse findRandom(){
        return boardService.findRandom();
    }

    // Put
    @PutMapping("/{text_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long text_id, @RequestBody BoardRequest request){
        boardService.update(text_id, request);
    }

    // Delete
    @DeleteMapping("/{text_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long text_id){
        boardService.delete(text_id);
    }
}