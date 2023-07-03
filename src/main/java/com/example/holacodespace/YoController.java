package com.example.holacodespace;

import java.lang.String;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(path="")
public class YoController {
    @GetMapping(path="/")
    public String completo(){
        return "AT70867816-FRANK";
    }
    @GetMapping(path="/idat/codigo")
    public String codigo(){
        return "AT70867816";
    }
    @GetMapping(path = "/idat/nombre-completo")
    public String nombre(){
        return "ALANYA PEREZ FRANK JERRY";
    }
}