package com.study.board.service;

import com.study.board.entity.Board;
import com.study.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 이건 controller가 다시 사용한다.
@Service
public class BoardService {

    @Autowired //의존성 주입. 객체 생성자 필요없이 바로 주입한다.
    private BoardRepository boardRepository;

    public void write(Board board) {
        //board 변수를 넣어준다.
        boardRepository.save(board);
    }
}
