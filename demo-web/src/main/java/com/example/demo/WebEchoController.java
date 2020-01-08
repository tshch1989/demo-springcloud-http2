package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Slf4j
@RestController
public class WebEchoController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/echo.do")
    @ResponseBody
    public Object echo(String msg){
        log.info("web 接收到 {}", msg);
        RequestEntity<?> entity = RequestEntity
                .post(URI.create("https://demo-service/echo.do"))
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body("msg="+msg);
        return restTemplate.exchange(entity, Object.class);
    }

}
