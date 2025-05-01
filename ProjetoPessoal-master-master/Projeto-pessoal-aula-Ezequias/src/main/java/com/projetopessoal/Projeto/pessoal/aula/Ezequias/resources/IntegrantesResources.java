package com.projetopessoal.Projeto.pessoal.aula.Ezequias.resources;

import com.projetopessoal.Projeto.pessoal.aula.Ezequias.dtos.IntegrantesDTO;
import com.projetopessoal.Projeto.pessoal.aula.Ezequias.models.Integrantes;
import com.projetopessoal.Projeto.pessoal.aula.Ezequias.services.IntegrantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios") // ? should this be changed?
public class IntegrantesResources {

    @Autowired
    private IntegrantesService integrantesService;

    @GetMapping("{id}")
    public ResponseEntity<IntegrantesDTO> buscarIntegrantesPorId(@PathVariable Long id) {
        Integrantes integrantes = integrantesService.buscarIntegrantesPorId(id);
        return ResponseEntity.ok(integrantesService.converterIntegrantesParaIntegrantesDTO(integrantes));
    }

    @GetMapping("/buscar")
    public ResponseEntity<IntegrantesDTO> buscarIntegrantesPorEmail(@RequestParam String nome) {
        IntegrantesDTO integrantesDTO = integrantesService.converterIntegrantesParaIntegrantesDTO(integrantesService.buscarIntegrantesPorNome(nome));
        return ResponseEntity.ok(integrantesDTO);
    }

    @PostMapping()
    public ResponseEntity<IntegrantesDTO> criarIntegrantes(@RequestBody IntegrantesDTO usuarioDTO) {
        return ResponseEntity.ok(integrantesService.salvarIntegrantes(usuarioDTO));
    }

    @PutMapping()
    public ResponseEntity<IntegrantesDTO> atualizarPrdoutoras(@RequestBody IntegrantesDTO usuarioDTO) {
        return ResponseEntity.ok(integrantesService.atualizarIntegrantes(usuarioDTO));
    }

    @DeleteMapping()
    public ResponseEntity<IntegrantesDTO> deletarIntegrantes(@RequestBody IntegrantesDTO usuarioDTO) {
        integrantesService.deletarIntegrantes(usuarioDTO.getId());
        return ResponseEntity.noContent().build();
    }
}
