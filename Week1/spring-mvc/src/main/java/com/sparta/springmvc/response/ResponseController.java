package com.sparta.springmvc.response;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// @Controller 를 달고 있을 때 반환타입이 String인 메서드에
// @ReponseBody 를 안달아주면 html 파일을 return한다고 인식하기 때문에 @ReponseBody 를 꼭 달아준다
@Controller
@RequestMapping("/response")
public class ResponseController {
    // [Response header]
    //   Content-Type: text/html
    // [Response body]
    //   {"name":"Robbie","age":95}
    @GetMapping("/json/string")
    @ResponseBody
    public String helloStringJson() {
        return "{\"name\":\"Robbie\",\"age\":95}";
    }

    // [Response header]
    //   Content-Type: application/json
    // [Response body]
    //   {"name":"Robbie","age":95}
    // Spring은 자동으로 Java의 객체를 JSON타입으로 바꾼다 -> Content-Type을 자동으로 바꿔준다 !
    @GetMapping("/json/class")
    @ResponseBody
    public Star helloClassJson(){
        return new Star("Robbie", 95);
    }
}
