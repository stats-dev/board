package com.study.board.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Board {

//    boardtable의 설정이라고 생각학게 만든다.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //title 멤버변수 선언
    private String title;

    private String content;
}
