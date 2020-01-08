package com.example.demo;

import com.example.demo.service.EchoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class WebFeignEchoController {

    @Autowired
    private EchoService echoService;

    @GetMapping("/echo.do")
    @ResponseBody
    public Object echo(String msg){
        log.info("web feign 接收到 {}", msg);
        return echoService.echo(msg);
    }

}
