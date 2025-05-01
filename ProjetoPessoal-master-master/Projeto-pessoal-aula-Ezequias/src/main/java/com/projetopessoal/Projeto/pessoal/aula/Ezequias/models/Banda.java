package com.projetopessoal.Projeto.pessoal.aula.Ezequias.models;

import com.projetopessoal.Projeto.pessoal.aula.Ezequias.dtos.BandaDTO;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "banda")
public class Banda {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    Long idpatrocinios; //? idPatrocinadores ?
    Integrantes integrantes;

    public Banda(Long id, String nome, Long idpatrocinios, Integrantes integrantes){
        this.id = id;
        this.nome = nome;
        this.idpatrocinios = idpatrocinios;
        this.integrantes = integrantes;
    }

    public Banda(BandaDTO banda){
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

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, idpatrocinios, integrantes);
    }
}
