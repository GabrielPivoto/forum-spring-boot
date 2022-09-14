package br.com.alura.forum.controller;

import br.com.alura.forum.controller.dto.TopicoDto;
import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //Já assume que todos os métodos vão conter @ResponseBody
public class TopicosController {

    @RequestMapping("/topicos") //Endereço do mapeamento
    public List<TopicoDto> lista(){
        Topico topico = new Topico("Dúvida","Dúvida com Spring",new Curso("Spring","Programacao"));

        return TopicoDto.converter(List.of(topico,topico,topico));
        //return Arrays.asList(topico,topico,topico);
    }

}
