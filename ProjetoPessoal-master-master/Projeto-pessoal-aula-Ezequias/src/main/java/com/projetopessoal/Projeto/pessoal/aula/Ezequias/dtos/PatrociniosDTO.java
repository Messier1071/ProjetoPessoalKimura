package com.projetopessoal.Projeto.pessoal.aula.Ezequias.dtos;

import com.projetopessoal.Projeto.pessoal.aula.Ezequias.models.Patrocinios;

public class PatrociniosDTO {

    Long id;
    String nome;
    Long idbanda; // ? idPatrocinadores ?

    public PatrociniosDTO(Long id, String nome, Long idbanda) {
        this.id = id;
        this.nome = nome;
        this.idbanda = idbanda;

    }

    public PatrociniosDTO(Patrocinios banda) {
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

}
