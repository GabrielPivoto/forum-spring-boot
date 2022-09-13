package br.com.alura.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping("/") //Para o Spring saber quando chamar este método
    @ResponseBody //Para o Spring entender que deve devolver a String direto e não buscar uma página
    public String hello(){
        return "Hello World!";
    }

}
