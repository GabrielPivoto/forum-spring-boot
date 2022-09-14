package br.com.alura.forum.controller;

import br.com.alura.forum.controller.dto.TopicoDto;
import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //Já assume que todos os métodos vão conter @ResponseBody
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;

    @RequestMapping("/topicos") //Endereço do mapeamento
    public List<TopicoDto> lista(){
        List<Topico> topicos = topicoRepository.findAll();
        return TopicoDto.converter(topicos);
        //return Arrays.asList(topico,topico,topico);
    }

}
