package br.com.alura.forum.controller;

import br.com.alura.forum.controller.dto.DetalhesTopicoDto;
import br.com.alura.forum.controller.dto.TopicoDto;
import br.com.alura.forum.controller.form.AtualizaTopicoForm;
import br.com.alura.forum.controller.form.TopicoForm;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.CursoRepository;
import br.com.alura.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController //Já assume que todos os métodos vão conter @ResponseBody
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

   @GetMapping //Endereço do mapeamento
    public List<TopicoDto> lista(String nomeCurso){
        if(nomeCurso == null){
            List<Topico> topicos = topicoRepository.findAll();
            return TopicoDto.converter(topicos);
        }else{
            List<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso);
            return TopicoDto.converter(topicos);
        }

        //return Arrays.asList(topico,topico,topico);
    }

    /**
     * @author Gabriel Pivoto
     * @param form
     * @param uriComponentsBuilder
     * @return
     *
     * ResponseEntity é utilizado para montar uma resposta
     *
     */
    @PostMapping
    public ResponseEntity<TopicoDto> cadatrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriComponentsBuilder){
        Topico topico = form.conveter(cursoRepository);
        topicoRepository.save(topico);
        URI uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDto(topico));
    }

    @GetMapping("/{id}")
    public DetalhesTopicoDto detalhar(@PathVariable Long id){
       Topico topico = topicoRepository.getReferenceById(id);
       return new DetalhesTopicoDto(topico);
    }

    /**
     *
     * Transactional utilizado para atualizar no banco de dados.
     *
     * @param id
     * @param form
     * @return
     * @author Gabriel Pivoto
     */
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizaTopicoForm form){
        Topico topico = form.atualizar(id, topicoRepository);
        return ResponseEntity.ok(new TopicoDto(topico));
    }

}
