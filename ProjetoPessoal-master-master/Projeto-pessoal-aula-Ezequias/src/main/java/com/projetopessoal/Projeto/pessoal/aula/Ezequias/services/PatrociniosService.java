package com.projetopessoal.Projeto.pessoal.aula.Ezequias.services;

import com.projetopessoal.Projeto.pessoal.aula.Ezequias.dtos.PatrociniosDTO;
import com.projetopessoal.Projeto.pessoal.aula.Ezequias.models.Patrocinios;
import com.projetopessoal.Projeto.pessoal.aula.Ezequias.repositories.PatrociniosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PatrociniosService {

    @Autowired
    private PatrociniosRepository _patrociniosRepository;

    public PatrociniosDTO salvarPatrocinios(PatrociniosDTO PatrociniosDTO) {
        Patrocinios Patrocinios = converterPatrociniosDTOParaPatrocinios(PatrociniosDTO);
        Patrocinios = _patrociniosRepository.save(Patrocinios);
        return converterPatrociniosParaPatrociniosDTO(Patrocinios);
    }

    private Patrocinios converterPatrociniosDTOParaPatrocinios(PatrociniosDTO PatrociniosDTO) {
        Patrocinios Patrocinios = new Patrocinios(PatrociniosDTO);
        return Patrocinios;
    }

    public PatrociniosDTO converterPatrociniosParaPatrociniosDTO(Patrocinios Patrocinios) {
        PatrociniosDTO PatrociniosDTO = new PatrociniosDTO(Patrocinios);
        return PatrociniosDTO;
    }

    public Patrocinios buscarPatrociniosPorId(Long id) {
        return _patrociniosRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Patrocinios não encontrado"));
    }

    public Patrocinios buscarPatrociniosPorNome(String nome) {
        return _patrociniosRepository.findByNome(nome)
                .orElseThrow(() -> new IllegalArgumentException("Patrocinios não encontrado"));
    }

    public PatrociniosDTO atualizarPatrocinios(PatrociniosDTO patrociniosDTO) {

        if (Objects.isNull(patrociniosDTO.getId())) {
            throw new IllegalArgumentException("Id não informado");
        }

        Patrocinios patrocinios = _patrociniosRepository.findById(patrociniosDTO.getId())
                .orElseThrow(() -> new IllegalArgumentException("Patrocinios não encontrado"));

        patrocinios = converterPatrociniosDTOParaPatrocinios(patrociniosDTO);
        patrocinios = _patrociniosRepository.save(patrocinios);

        return converterPatrociniosParaPatrociniosDTO(patrocinios);

    }

    public void deletarPatrocinios(Long id) {
        _patrociniosRepository.deleteById(id);

    }
}
