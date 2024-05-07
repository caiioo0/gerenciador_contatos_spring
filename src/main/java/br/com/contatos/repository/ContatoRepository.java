package br.com.contatos.repository;

import br.com.contatos.model.Contato;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

//https://docs.spring.io/spring-data/jpa/docs/current-SNAPSHOT/reference/html/#jpa.query-methods
@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

    public Contato findByNome(String nome);

    public List<Contato>findByDataNascimentoBetween(LocalDate dataInicial, LocalDate dataFinal);

}
