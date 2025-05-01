package com.projetopessoal.Projeto.pessoal.aula.Ezequias.services;

import com.projetopessoal.Projeto.pessoal.aula.Ezequias.dtos.BandaDTO;
import com.projetopessoal.Projeto.pessoal.aula.Ezequias.models.Banda;
import com.projetopessoal.Projeto.pessoal.aula.Ezequias.repositories.BandaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class BandaService {

    @Autowired
    private BandaRepository _bandaRepository;

    public BandaDTO salvarBanda(BandaDTO BandaDTO) {
        Banda Banda = converterBandaDTOParaBanda(BandaDTO);
        Banda = _bandaRepository.save(Banda);
        return converterBandaParaBandaDTO(Banda);
    }

    private Banda converterBandaDTOParaBanda(BandaDTO BandaDTO) {
        Banda Banda = new Banda(BandaDTO);
        return Banda;
    }

    public BandaDTO converterBandaParaBandaDTO(Banda Banda) {
        BandaDTO BandaDTO = new BandaDTO(Banda);
        return BandaDTO;
    }

    public Banda buscarBandaPorId(Long id) {
        return _bandaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Integrante não encontrado"));
    }

    public Banda buscarBandaPorNome(String nome) {
        return _bandaRepository.findByNome(nome)
                .orElseThrow(() -> new IllegalArgumentException("Integrante não encontrado"));
    }

    public BandaDTO atualizarBanda(BandaDTO bandaDTO) {

        if (Objects.isNull(bandaDTO.getId())) {
            throw new IllegalArgumentException("Id não informado");
        }

        Banda banda = _bandaRepository.findById(bandaDTO.getId())
                .orElseThrow(() -> new IllegalArgumentException("Integrante não encontrado"));

        banda = converterBandaDTOParaBanda(bandaDTO);
        banda = _bandaRepository.save(banda);

        return converterBandaParaBandaDTO(banda);

    }

    public void deletarBanda(Long id) {
        _bandaRepository.deleteById(id);

    }
}
