package com.projetopessoal.Projeto.pessoal.aula.Ezequias.models;

import com.projetopessoal.Projeto.pessoal.aula.Ezequias.dtos.IntegrantesDTO;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "integrantes")
public class Integrantes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    
    private Long idBanda;

    public Integrantes(Long id, String nome, Long idBanda){
        this.id = id;
        this.nome = nome;
        this.idBanda = idBanda;
    }

    public Integrantes(IntegrantesDTO Integrantes){
        this.id = Integrantes.getId();
        this.nome = Integrantes.getNome();
        this.idBanda = Integrantes.getIdBanda();
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Long getIdBanda(){
        return idBanda;
    }

    public void setIdBanda(Long id) {
        this.idBanda = id;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, nome, idBanda);
    }

}
