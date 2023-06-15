package com.sparta.springmvc.response;

import lombok.Getter;

@Getter
public class Star {
    String name;    // 필드명을 Json의 키값으로 반환
    int age;

    public Star(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Star() {}
}