package com.projetopessoal.Projeto.pessoal.aula.Ezequias.repositories;

import com.projetopessoal.Projeto.pessoal.aula.Ezequias.models.Patrocinios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatrociniosRepository extends JpaRepository<Patrocinios, Long> {
    Optional<Patrocinios> findbyId(Long id);

    Optional<Patrocinios> findByNome(String nome);

}
