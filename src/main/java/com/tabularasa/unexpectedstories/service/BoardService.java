package com.tabularasa.unexpectedstories.service;

import com.tabularasa.unexpectedstories.controller.dto.request.BoardRequest;
import com.tabularasa.unexpectedstories.controller.dto.response.BoardResponse;
import com.tabularasa.unexpectedstories.domain.Board;
import com.tabularasa.unexpectedstories.domain.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public void save (BoardRequest request){
        Board board = Board.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .busstop(request.getBusStop())
                .build();
        boardRepository.save(board);
    }

    public List<BoardResponse> findAll(){
        return boardRepository.findAll().stream()
                .map(BoardResponse::new)
                .toList();
    }

    /*
    public Board findRandom1(){
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        List<BoardResponse> boards = findAll();
        int randomId = random.nextInt(boards.size());

        BoardResponse boardRandom = boards.get(randomId);
        Board board = boardRepository.findById(boardRandom.getTextId())
                .orElseThrow(() -> new IllegalArgumentException("Board not found"));

        return boardRandom.updateView(board);
    }
     */

    @Transactional
    public BoardResponse findRandom(){
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        List<BoardResponse> boards = findAll();
        int randomId = random.nextInt(boards.size());

        Board board = boardRepository.findById(boards.get(randomId).getTextId())
                .orElseThrow(() -> new IllegalArgumentException("Board not found"));
        board.updateView(board.getCountView());
        System.out.println(board.getCountView());

        return boards.get(randomId);
    }

    public BoardResponse findById(Long textId){
        Board board = boardRepository.findById(textId)
                .orElseThrow(() -> new IllegalArgumentException("Board not found"));

        return new BoardResponse(board);
    }

    @Transactional
    public void update(Long textId, BoardRequest request){
        Board board = boardRepository.findById(textId)
                .orElseThrow(() -> new IllegalArgumentException("Board not found"));
        board.update(request.getTitle(), request.getContent());
    }

    @Transactional
    public void updateLike(Long textId){
        Board board = boardRepository.findById(textId)
                .orElseThrow(() -> new IllegalArgumentException("Board not found"));
        board.updateLike(board.getFeelingLike());
    }

    @Transactional
    public void updateSad(Long textId){
        Board board = boardRepository.findById(textId)
                .orElseThrow(() -> new IllegalArgumentException("Board not found"));
        board.updateSad(board.getFeelingSad());
    }

    @Transactional
    public void updateLove(Long textId){
        Board board = boardRepository.findById(textId)
                .orElseThrow(() -> new IllegalArgumentException("Board not found"));
        board.updateLove(board.getFeelingLove());
    }

    @Transactional
    public void updateView(Long textId){
        Board board = boardRepository.findById(textId)
                .orElseThrow(() -> new IllegalArgumentException("Board not found"));
        board.updateView(board.getCountView());
    }

    public void delete(Long text_id){
        boardRepository.deleteById(text_id);
    }
}
