package com.sparta.junit5practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RepeatTest {
    @RepeatedTest(value = 5, name = "반복 테스트 {currentRepetition} / {totalRepetitions}") // value=5 -> 반복 5번 , totalRepetitions -> 5, currentRepetition -> 1부터~5까지
                                                                                            // test 코드계의 for문..?
    void repeatTest(RepetitionInfo info) {
        System.out.println("테스트 반복 : " + info.getCurrentRepetition() + " / " + info.getTotalRepetitions());
    }

    @DisplayName("파라미터 값 활용하여 테스트 하기")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9}) // value 갯수만큼 반복 -> 9번
    void parameterTest(int num) {
        System.out.println("5 * num = " + 5 * num);
    }
}
