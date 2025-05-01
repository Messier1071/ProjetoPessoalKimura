package com.projetopessoal.Projeto.pessoal.aula.Ezequias.services;

import com.projetopessoal.Projeto.pessoal.aula.Ezequias.dtos.IntegrantesDTO;
import com.projetopessoal.Projeto.pessoal.aula.Ezequias.models.Integrantes;
import com.projetopessoal.Projeto.pessoal.aula.Ezequias.repositories.IntegrantesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class IntegrantesService {
    
    @Autowired
    private IntegrantesRepository _integrantesRepository;

    public IntegrantesDTO salvarIntegrantes(IntegrantesDTO IntegrantesDTO) {
        Integrantes Integrantes = converterIntegrantesDTOParaIntegrantes(IntegrantesDTO);
        Integrantes = _integrantesRepository.save(Integrantes);
        return converterIntegrantesParaIntegrantesDTO(Integrantes);
    }

    private Integrantes converterIntegrantesDTOParaIntegrantes(IntegrantesDTO IntegrantesDTO) {
        Integrantes Integrantes = new Integrantes(IntegrantesDTO);
        return Integrantes;
    }

    public IntegrantesDTO converterIntegrantesParaIntegrantesDTO(Integrantes Integrantes) {
        IntegrantesDTO IntegrantesDTO = new IntegrantesDTO(Integrantes);
        return IntegrantesDTO;
    }

    public Integrantes buscarIntegrantesPorId(Long id) {
        return _integrantesRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Integrante não encontrado"));
    }

    public Integrantes buscarIntegrantesPorNome(String nome) {
        return _integrantesRepository.findByNome(nome)
                .orElseThrow(() -> new IllegalArgumentException("Integrante não encontrado"));
    }

    public IntegrantesDTO atualizarIntegrantes(IntegrantesDTO integrantesDTO) {

        if (Objects.isNull(integrantesDTO.getId())) {
            throw new IllegalArgumentException("Id não informado");
        }

        Integrantes integrantes = _integrantesRepository.findById(integrantesDTO.getId()).orElseThrow(()
                -> new IllegalArgumentException("Integrante não encontrado"));

        integrantes = converterIntegrantesDTOParaIntegrantes(integrantesDTO);
        integrantes = _integrantesRepository.save(integrantes);

        return converterIntegrantesParaIntegrantesDTO(integrantes);

    }

    public void deletarIntegrantes(Long id) {
        _integrantesRepository.deleteById(id);

    }
}
