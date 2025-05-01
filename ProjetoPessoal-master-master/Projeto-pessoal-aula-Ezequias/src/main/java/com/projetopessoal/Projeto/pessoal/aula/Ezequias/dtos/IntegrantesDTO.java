package com.projetopessoal.Projeto.pessoal.aula.Ezequias.dtos;

import com.projetopessoal.Projeto.pessoal.aula.Ezequias.models.Integrantes;

public class IntegrantesDTO {
    
    private Long id;

    private String nome;

    private Long idBanda;

    public IntegrantesDTO(Long id, String nome, Long idBanda) {
        this.id = id;
        this.nome = nome;
        this.idBanda = idBanda;
    }

    public IntegrantesDTO(Integrantes Integrantes){
        this.id = Integrantes.getId();
        this.nome = Integrantes.getNome();
        this.idBanda = Integrantes.getIdBanda();
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
        return idBanda;
    }

    public void setIdBanda(Long id) {
        this.idBanda = id;
    }
}
