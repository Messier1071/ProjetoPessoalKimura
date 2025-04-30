package com.projetopessoal.Projeto.pessoal.aula.Ezequias.services;

import com.projetopessoal.Projeto.pessoal.aula.Ezequias.dtos.ProdutorasDTO;
import com.projetopessoal.Projeto.pessoal.aula.Ezequias.models.Produtoras;
import com.projetopessoal.Projeto.pessoal.aula.Ezequias.repositories.ProdutorasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ProdutorasService {

    @Autowired
    private ProdutorasRepository produtorasRepository;

    public ProdutorasDTO salvarProdutoras(ProdutorasDTO produtorasDTO) {
        Produtoras produtoras = converterProdutorasDTOParaProdutoras(produtorasDTO);
        produtoras = produtorasRepository.save(produtoras);
        return converterProdutorasParaProdutorasDTO(produtoras);
    }

    private Produtoras converterProdutorasDTOParaProdutoras(ProdutorasDTO produtorasDTO) {
        Produtoras produtoras = new Produtoras();
        produtoras.setId(produtorasDTO.getId());
        produtoras.setNome(produtorasDTO.getNome());
        produtoras.setcpfcnpj(produtorasDTO.getCpfcnpj());
        return produtoras;
    }

    public ProdutorasDTO converterProdutorasParaProdutorasDTO(Produtoras produtoras) {
        ProdutorasDTO produtorasDTO = new ProdutorasDTO();
        produtorasDTO.setId(produtoras.getId());
        produtorasDTO.setNome(produtoras.getNome());
        produtorasDTO.setCpfcnpj(produtoras.getcpfcnpj());
        return produtorasDTO;
    }

    public Produtoras buscarProdutorasPorId(Long id) {
        return produtorasRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Produtoras não encontrada"));
    }

    public ProdutorasDTO buscarProdutorasPorCpf_cnpj(Long cpf_cnpj) {
        return converterProdutorasParaProdutorasDTO(produtorasRepository.findBycpfcnpj(cpf_cnpj)
                .orElseThrow(() ->
                        new IllegalArgumentException("Produtoras não encontrada")));
    }

    public ProdutorasDTO atualizarProdutoras(ProdutorasDTO produtorasDTO) {

        if (Objects.isNull(produtorasDTO.getId())) {
            throw new IllegalArgumentException("Id não informado");
        }

        Produtoras produtoras = produtorasRepository.findById(produtorasDTO.getId()).orElseThrow(()
                -> new IllegalArgumentException("Produtoras não encontrada"));

        produtoras = converterProdutorasDTOParaProdutoras(produtorasDTO);
        produtoras = produtorasRepository.save(produtoras);

        return converterProdutorasParaProdutorasDTO(produtoras);

    }

    public void deletarProdutoras(Long id) {
        produtorasRepository.deleteById(id);

    }
}
