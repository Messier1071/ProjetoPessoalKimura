package com.projetopessoal.Projeto.pessoal.aula.Ezequias.repositories;

import com.projetopessoal.Projeto.pessoal.aula.Ezequias.models.Integrantes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IntegrantesRepository extends JpaRepository<Integrantes, Long> {
    Optional<Integrantes> findbyId(Long id);
    Optional<Integrantes> findByNome(String nome);
    
} 
