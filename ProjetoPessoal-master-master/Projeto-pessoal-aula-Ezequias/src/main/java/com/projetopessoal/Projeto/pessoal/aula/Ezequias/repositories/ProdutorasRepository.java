package com.projetopessoal.Projeto.pessoal.aula.Ezequias.repositories;

import com.projetopessoal.Projeto.pessoal.aula.Ezequias.models.Produtoras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutorasRepository extends JpaRepository<Produtoras, Long> {
    Optional<Produtoras> findByEmail(String email);
    Optional<Produtoras> findBycpfcnpj(Long cpfcnpj);

}
