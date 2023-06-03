package com.study.board.service;

import com.study.board.entity.Board;
import com.study.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 이건 controller가 다시 사용한다.
@Service
public class BoardService {

    @Autowired //의존성 주입. 객체 생성자 필요없이 바로 주입한다.
    private BoardRepository boardRepository;


    //글 작성
    public void write(Board board) {
        //board 변수를 넣어준다.
        boardRepository.save(board);
    }


    //게시글 리스트 처리
    public List<Board> boardList() {
        return boardRepository.findAll();
    }

    // 특정 게시글 불러오기
    public Board boardView(Integer id) {

        return boardRepository.findById(id).get();
    }

    // 특정 게시글 삭제
    public void boardDelete(Integer id) {
        // 게시글 번호 들어오면 Id 값에 해당하는 글을 삭제한다.
        boardRepository.deleteById(id);
    }
}
