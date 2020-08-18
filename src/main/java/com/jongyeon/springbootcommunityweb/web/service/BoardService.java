package com.jongyeon.springbootcommunityweb.web.service;

import com.jongyeon.springbootcommunityweb.web.domain.Board;
import com.jongyeon.springbootcommunityweb.web.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository){
        this.boardRepository=boardRepository;
    }

    public Page<Board> findBoardList(Pageable pageable){
        pageable= PageRequest.of(pageable.getPageNumber() <= 0? 0:pageable.getPageNumber()-1,pageable.getPageSize());
        return boardRepository.findAll(pageable);
    }
    public Board findBoardByIdx(Long idx){
        return boardRepository.findById(idx).orElse(new Board());
    }
}