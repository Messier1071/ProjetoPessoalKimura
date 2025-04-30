package com.projetopessoal.Projeto.pessoal.aula.Ezequias.models;

import com.projetopessoal.Projeto.pessoal.aula.Ezequias.dtos.ProdutorasDTO;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "produtoras")

public class Produtoras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Long cpfcnpj;

    private String email;

    public Produtoras() {
    }

    public Produtoras(Long id, String nome, Long cpf_cnpj) {
        this.id = id;
        this.nome = nome;
        this.cpfcnpj = cpf_cnpj;
    }

    public Produtoras(ProdutorasDTO produtorasDTO) {
        this.id = produtorasDTO.getId();
        this.nome = produtorasDTO.getNome();
        this.cpfcnpj = produtorasDTO.getCpfcnpj();
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

    public Long getcpfcnpj() {
        return cpfcnpj;
    }

    public void setcpfcnpj(Long cpfcnpj) {
        this.cpfcnpj = cpfcnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Produtoras that = (Produtoras) o;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(cpfcnpj, that.cpfcnpj) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cpfcnpj, email);
    }
}
