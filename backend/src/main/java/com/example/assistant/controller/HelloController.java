package com.example.assistant.controller;

import com.example.assistant.dto.PersonalDetailsResponse;
import com.example.assistant.service.MyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {
    private final MyService ser;
    public HelloController(MyService ser){
        this.ser=ser;
    }
    @GetMapping("/hello")
    public String Hello(){

        ser.MySer();
    return "Hello World";
    }

    @GetMapping("/person")

    public PersonalDetailsResponse person(){
        return new PersonalDetailsResponse(
            "Niharika","Singh","9876545678"
        );
    }
}
