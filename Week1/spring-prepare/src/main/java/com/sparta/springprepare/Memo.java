package com.sparta.springprepare;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor // - 요구되는 필드(final)를 갖고 있는 생성자 생성
//@AllArgsConstructor - 모든 필드들을 갖고 있는 생성자 생성
//@NoArgsConstructor - 기본생성자를 만들어줌
public class Memo {
    private final String username;
    private String contents;
}

class Main{
    public static void main(String[] args) {
        Memo memo = new Memo("Robbert");

        System.out.println(memo.getUsername());
    }
}