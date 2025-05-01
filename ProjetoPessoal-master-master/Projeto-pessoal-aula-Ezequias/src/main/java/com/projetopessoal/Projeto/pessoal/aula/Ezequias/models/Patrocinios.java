package com.projetopessoal.Projeto.pessoal.aula.Ezequias.models;

import com.projetopessoal.Projeto.pessoal.aula.Ezequias.dtos.PatrociniosDTO;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Patrocinios")
public class Patrocinios {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    Long idbanda; //? idPatrocinadores ?
   

    public Patrocinios(Long id, String nome, Long idbanda){
        this.id = id;
        this.nome = nome;
        this.idbanda = idbanda;
        
    }

    public Patrocinios(PatrociniosDTO banda){
        this.id = banda.getId();
        this.nome = banda.getNome();
        this.idbanda = banda.getIdBanda();
    }

    
    
    public Long getId() {
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

    public Long getIdBanda() {
        return idbanda;
    }

    public void setIdBanda(Long id) {
        this.idbanda = id;
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, nome, idbanda);
    }
}
