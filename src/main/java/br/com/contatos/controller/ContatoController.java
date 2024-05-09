package br.com.contatos.controller;

import br.com.contatos.model.Contato;
import br.com.contatos.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ContatoController {

    @Autowired
    private ContatoService service;

    @PostMapping("/contatos")
    @ResponseStatus(HttpStatus.CREATED)
    public Contato gravar(@RequestBody Contato contato){
        return service.gravarContato(contato);
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/contatos")
    public List<Contato> listarTodosContatos(){

        return service.listarTodosContatos();

    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/contatos/{id}")
    public void deletarContatoPorId(@PathVariable Long id){
        service.excluir(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/contatos")
    public Contato atualizar(Contato contato){

        return service.atualizarContato(contato);

    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/contatos/{nome}")
    public Contato listarContatoPorNome(@PathVariable String nome){
        return service.listarPorNome(nome);
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/contatos/{dataInicial}/{dataFinal}")
    public List<Contato> listarAniversiariantes(@PathVariable LocalDate dataInicial,
                                                @PathVariable LocalDate dataFinal){
        return service.listarTodosContatosAniversariantes(dataInicial, dataFinal);
    }

}
