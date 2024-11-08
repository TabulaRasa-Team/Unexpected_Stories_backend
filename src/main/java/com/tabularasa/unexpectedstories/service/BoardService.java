package com.tabularasa.unexpectedstories.service;

import com.tabularasa.unexpectedstories.controller.dto.request.BoardRequest;
import com.tabularasa.unexpectedstories.controller.dto.response.BoardResponse;
import com.tabularasa.unexpectedstories.domain.Board;
import com.tabularasa.unexpectedstories.domain.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public Long save (BoardRequest request){
        Board board = Board.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .busstop(request.getBusstop())
                .build();
        Board save = boardRepository.save(board);
        return save.getText_id();
    }

    public List<BoardResponse> findAll(){
        return boardRepository.findAll().stream()
                .map(BoardResponse::new)
                .toList();
    }

    public BoardResponse findRandom(){
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        List<BoardResponse> boards = findAll();
        int random_id = random.nextInt(boards.size());

        return boards.get(random_id);
    }

    @Transactional
    public void update(Long text_id, BoardRequest request){
        Board board = boardRepository.findById(text_id)
                .orElseThrow(() -> new IllegalArgumentException("Board not found"));
        board.update(request.getTitle(), request.getContent());
    }

    public void delete(Long text_id){
        boardRepository.deleteById(text_id);
    }
}
