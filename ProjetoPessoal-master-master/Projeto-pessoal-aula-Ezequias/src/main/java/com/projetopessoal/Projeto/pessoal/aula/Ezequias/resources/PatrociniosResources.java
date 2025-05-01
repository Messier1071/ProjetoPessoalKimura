package com.projetopessoal.Projeto.pessoal.aula.Ezequias.resources;

import com.projetopessoal.Projeto.pessoal.aula.Ezequias.dtos.PatrociniosDTO;
import com.projetopessoal.Projeto.pessoal.aula.Ezequias.models.Patrocinios;
import com.projetopessoal.Projeto.pessoal.aula.Ezequias.services.PatrociniosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios") //? should this be changed?
public class PatrociniosResources {

    @Autowired
    private PatrociniosService patrociniosService;

    @GetMapping("{id}")
    public ResponseEntity<PatrociniosDTO> buscarPatrociniosPorId(@PathVariable Long id) {
        Patrocinios patrocinios = patrociniosService.buscarPatrociniosPorId(id);
        return ResponseEntity.ok(patrociniosService.converterPatrociniosParaPatrociniosDTO(patrocinios));
    }

    @GetMapping("/buscar")
    public ResponseEntity<PatrociniosDTO> buscarPatrociniosPorEmail(@RequestParam String nome) {
        PatrociniosDTO patrociniosDTO = patrociniosService
                .converterPatrociniosParaPatrociniosDTO(patrociniosService.buscarPatrociniosPorNome(nome));
        return ResponseEntity.ok(patrociniosDTO);
    }

    @PostMapping()
    public ResponseEntity<PatrociniosDTO> criarPatrocinios(@RequestBody PatrociniosDTO usuarioDTO) {
        return ResponseEntity.ok(patrociniosService.salvarPatrocinios(usuarioDTO));
    }

    @PutMapping()
    public ResponseEntity<PatrociniosDTO> atualizarPrdoutoras(@RequestBody PatrociniosDTO usuarioDTO) {
        return ResponseEntity.ok(patrociniosService.atualizarPatrocinios(usuarioDTO));
    }

    @DeleteMapping()
    public ResponseEntity<PatrociniosDTO> deletarPatrocinios(@RequestBody PatrociniosDTO usuarioDTO) {
        patrociniosService.deletarPatrocinios(usuarioDTO.getId());
        return ResponseEntity.noContent().build();
    }
}
