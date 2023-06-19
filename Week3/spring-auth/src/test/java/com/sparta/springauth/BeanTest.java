package com.sparta.springauth;

import com.sparta.springauth.food.Food;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BeanTest {

//    @Autowired -> 빈의 타입을 기준으로 DI를 지원
//    Food food; -> food 가 chicken과 pizza 타입이 두개기 때문에 주입이 안됨

//    @Autowired
//    Food food; // 같은 타입이 두개일 때 @Primary 애너테이션이 설정된 타입을 주입

    @Autowired
    @Qualifier("pizza")
    Food food;
    // Qualifier vs Primary 중 우선순위가 Qualifier 가 더 높다
    // 좁은 범위의 설정을 우선순위가 더 높게 설정된다 ****
    // 같은타입 빈이 여러개일 때 : 범용적 사용 빈(사용빈도가 높을 때) primary / 지역적 사용 빈 qualifier


    @Test
    @DisplayName("테스트")
    void test1(){
        food.eat();
    }
}
