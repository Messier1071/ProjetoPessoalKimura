package com.projetopessoal.Projeto.pessoal.aula.Ezequias.dtos;

import com.projetopessoal.Projeto.pessoal.aula.Ezequias.models.Integrantes;

import com.projetopessoal.Projeto.pessoal.aula.Ezequias.models.Banda;

public class BandaDTO {
    
    Long id;
    String nome;
    Long idpatrocinios; //? idPatrocinadores ?
    Integrantes integrantes;

    public BandaDTO(Long id, String nome, Long idpatrocinios, Integrantes integrantes){
        this.id = id;
        this.nome = nome;
        this.idpatrocinios = idpatrocinios;
        this.integrantes = integrantes;
    }

    public BandaDTO(Banda banda){
        this.id = banda.getId();
        this.nome = banda.getNome();
        this.idpatrocinios = banda.getIdPatrocinios();
        this.integrantes = banda.getIntegrantes();
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

    public Long getIdPatrocinios() {
        return idpatrocinios;
    }

    public void setIdPatrocinio(Long id) {
        this.idpatrocinios = id;
    }

    public Integrantes getIntegrantes(){
        return this.integrantes;
    }

    public void setIdIntegrantes(Integrantes integrantes) {
        this.integrantes = integrantes;
    }
        
}
