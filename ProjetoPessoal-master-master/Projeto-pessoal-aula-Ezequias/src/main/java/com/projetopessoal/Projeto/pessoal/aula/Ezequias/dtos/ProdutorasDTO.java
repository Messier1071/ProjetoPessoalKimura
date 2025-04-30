package com.projetopessoal.Projeto.pessoal.aula.Ezequias.dtos;

public class ProdutorasDTO {

    private Long id;

    private String nome;

    private Long cpfcnpj;

    private String email;

    public ProdutorasDTO() {
    }

    public ProdutorasDTO(Long id, String nome, Long cpfcnpj, String email) {
        this.id = id;
        this.nome = nome;
        this.cpfcnpj = cpfcnpj;
        this.email = email;
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

    public Long getCpfcnpj() {
        return cpfcnpj;
    }

    public void setCpfcnpj(Long cpfcnpj) {
        this.cpfcnpj = cpfcnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
