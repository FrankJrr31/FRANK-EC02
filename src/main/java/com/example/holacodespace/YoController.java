package com.example.holacodespace;

import java.lang.String;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(path="/idat")
public class YoController {
    @GetMapping(path="/")
    public String completo(){
        return "AT77465395-Arturo Gabriel Carrasco";
    }
    @GetMapping(path="/codigo")
    public String codigo(){
        return "AT77465395";
    }
    @GetMapping(path = "/nombre-completo")
    public String nombre(){
        return "Arturo Gabriel Carrasco";
    }
}