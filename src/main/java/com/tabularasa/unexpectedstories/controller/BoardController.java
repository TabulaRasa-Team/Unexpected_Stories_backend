package com.tabularasa.unexpectedstories.controller;

import com.tabularasa.unexpectedstories.controller.dto.request.BoardRequest;
import com.tabularasa.unexpectedstories.controller.dto.response.BoardResponse;
import com.tabularasa.unexpectedstories.domain.Board;
import com.tabularasa.unexpectedstories.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/board")
@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

    // Create
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody BoardRequest request){
        System.out.println("Received request: " + request); // 요청 데이터 로그 확인
        boardService.save(request);
    }

    // Get - all
    @GetMapping()
    public List<BoardResponse> findAll(){
        return boardService.findAll();
    }

    // random 하면 리스트를 받아와서 그 길이 중에서 랜덤함수로 그 번째 리스트 값을 보낸다
    @GetMapping("/random")
    // @PatchMapping("/random")
    public BoardResponse findRandom(){ return boardService.findRandom(); }

    @GetMapping("/{textId}")
    public BoardResponse findById(@PathVariable Long textId){ return boardService.findById(textId); }

    // Put
    @PutMapping("/{textId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long textId, @RequestBody BoardRequest request) { boardService.update(textId, request); }

    // patch
    @PatchMapping("/like/{textId}")
    public void updateLike(@PathVariable Long textId){ boardService.updateLike(textId); }

    @PatchMapping("/sad/{textId}")
    public void updateSad(@PathVariable Long textId){ boardService.updateSad(textId); }

    @PatchMapping("/love/{textId}")
    public void updateLove(@PathVariable Long textId){ boardService.updateLove(textId); }

    @PatchMapping("/view/{textId}")
    public void updateView(@PathVariable Long textId){ boardService.updateView(textId); }

    // Delete
    @DeleteMapping("/{textId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long textId){
        boardService.delete(textId);
    }
}