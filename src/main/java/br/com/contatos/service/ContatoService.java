package br.com.contatos.service;

import br.com.contatos.model.Contato;
import br.com.contatos.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    public Contato gravarContato(Contato contato){
        return contatoRepository.save(contato);
    }

    public Contato buscarPorId(Long id){

        Optional<Contato> optionalContato = contatoRepository.findById(id);

        if (optionalContato.isPresent()){
            return optionalContato.get();
        } else {
            throw new RuntimeException("Contato não encontrado");
        }

    }

    public List<Contato> listarTodosContatos(){
        return contatoRepository.findAll();
    }

    public void excluir(Long id){
        Optional<Contato> optionalContato = contatoRepository.findById(id);

        if (optionalContato.isPresent()){
            contatoRepository.delete(optionalContato.get());
        }else {
            throw new RuntimeException("Contato não encontrado");
        }
    }

    public List<Contato> listarTodosContatosAniversariantes(LocalDate dataInicial, LocalDate dataFinal){
        return contatoRepository.findByDataNascimentoBetween(dataInicial, dataFinal);
    }

    public Contato atualizarContato(Contato contato){
        Optional<Contato> optionalContato = contatoRepository.findById(contato.getId());
        if (optionalContato.isPresent()){
            return contatoRepository.save(contato);
        } else {
            throw new RuntimeException("Contato não encontrado");
        }
    }

    public Contato listarPorNome(String nome){
        Optional<Contato> optional = contatoRepository.findByNome(nome);
        if (optional.isPresent()){
            return optional.get();
        }else {
            throw new RuntimeException("Contato não encontrado com esse nome");
        }
    }

}

