package com.example.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(
        name = "https://demo-service",
        contextId = "com.example.demo.service.EchoService"
)
public interface EchoService {

    @PostMapping(
            path = "/echo.do",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    @ResponseBody
    String echo(@RequestParam("msg") String msg);

}
