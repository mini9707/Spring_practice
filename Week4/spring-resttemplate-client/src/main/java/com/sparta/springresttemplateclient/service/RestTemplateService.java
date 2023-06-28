package com.sparta.springresttemplateclient.service;

import com.sparta.springresttemplateclient.dto.ItemDto;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class RestTemplateService {

    private final RestTemplate restTemplate;

    public RestTemplateService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build(); //restTemplate 반환 해주는 build()
    }

    public ItemDto getCallObject(String query) {
        // 요청 URL 만들기
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:7070") //서버 입장의 서버의 주소
                .path("/api/server/get-call-obj")
                .queryParam("query", query)
                .encode()
                .build()
                .toUri();
        log.info("uri = " + uri);

        ResponseEntity<ItemDto> responseEntity = restTemplate.getForEntity(uri, ItemDto.class);
        //(GET 방식으로 해당 uri 서버에 요청, 서버에서 넘어올 데이터를 받을 때 ItemDto.class(변환이 될 타입)로 객체형태로 받음)
        //http 관련 데이터를 response(응답) 할 때 사용

        log.info("statusCode = " + responseEntity.getStatusCode()); // statusCode : 2xx. 3xx 등의 코드

        return responseEntity.getBody();
        //getBody() : responseEntity 에 ItemDto 값을 반환
    }

    public List<ItemDto> getCallList() {
        // 요청 URL 만들기
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:7070")
                .path("/api/server/get-call-list")
                .encode()
                .build()
                .toUri();
        log.info("uri = " + uri);

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);

        log.info("statusCode = " + responseEntity.getStatusCode());
        log.info("Body = " + responseEntity.getBody());

        return fromJSONtoItems(responseEntity.getBody());
    }

    public ItemDto postCall(String query) {
        return null;
    }

    public List<ItemDto> exchangeCall(String token) {
        return null;
    }

//    { json 형태로 되어있는 string, 이런식으로 넘어옴
//        "items":[
//        {"title" : "Mac", "price" : 3888000},
//        {"title" : "iPad", "price" : 1230000},
//        {"title" : "iPhone", "price" : 1550000},
//        {"title" : "Watch", "price" : 450000},
//        {"title" : "AirPods", "price" : 350000}
//        ]
//    }

    public List<ItemDto> fromJSONtoItems(String responseEntity) { //json 형태로 되어있는 string 을 받아옴
        JSONObject jsonObject = new JSONObject(responseEntity);
        JSONArray items  = jsonObject.getJSONArray("items");
        List<ItemDto> itemDtoList = new ArrayList<>();

        for (Object item : items) {
            ItemDto itemDto = new ItemDto((JSONObject) item);
            itemDtoList.add(itemDto);
        }

        return itemDtoList;
    }
}