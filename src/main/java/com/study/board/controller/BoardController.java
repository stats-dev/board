package com.study.board.controller;

import com.study.board.entity.Board;
import com.study.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/write") //localhost:8080/board/write에서 페이지 보여주겠다.
    public String boardWriteForm() {

        return "boardwrite";
    }

    @PostMapping("/board/writepro")
    public String boardWritePro(Board board) {

//        @Data를 통해 이 getTitle이 나타나게 된다. s
//        System.out.println(board.getTitle());
//        System.out.println("제목 : " + title);
//        System.out.println("내용 : " + content);

        //boardService 모르니 주입을 해야 한다.
        boardService.write(board);

        return "";
    }

    @GetMapping("/board/list")
    public String boardList(Model model) {

        model.addAttribute("list", boardService.boardList());

        return "boardlist";
    }

    @GetMapping("/board/view") // localhost:8080/board/view?id=1 이렇게 하면 1이 id 들어가서 게시글을 불러온다. parameter, get방식.
    public String boardView(Model model, Integer id) {


        model.addAttribute("board", boardService.boardView(id));
        return "boardview";
    }

    @GetMapping("/board/delete")
    public String boardDelete(Integer id) {
        boardService.boardDelete(id);
        //삭제 후 다시 목록(list) 페이지로 돌아간다.
        return "redirect:/board/list";
    }

    @GetMapping("/board/modify/{id}")
    public String boardModify(@PathVariable("id") Integer id, Model model) {

        model.addAttribute("board", boardService.boardView(id));

        return "boardmodify";
    }

    @PostMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable("id") Integer id, Board board) {

        //기존에 있던 글 검색
        Board boardTemp = boardService.boardView(id);
        //수정시 넘어온 데이터 가져옴. 그래서 덮어씌운다.
//        boardTemp.setTitle(board.getTitle());
//        boardTemp.setContent(board.getContent());

        return "redirect:/board/list";
    }

}
