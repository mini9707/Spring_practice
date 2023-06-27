package com.sparta.springauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration      //@Bean 으로 등록할 메서드가 속해있는 클래스 위에 @Configuration 애너테이션을 달아준다, 스프링 서버가 뜰때 IoC 컨테이너에 빈으로 등록 !
public class PasswordConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}