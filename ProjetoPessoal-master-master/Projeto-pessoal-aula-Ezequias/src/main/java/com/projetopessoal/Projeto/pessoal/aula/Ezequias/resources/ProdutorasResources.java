package com.projetopessoal.Projeto.pessoal.aula.Ezequias.resources;

import com.projetopessoal.Projeto.pessoal.aula.Ezequias.dtos.ProdutorasDTO;
import com.projetopessoal.Projeto.pessoal.aula.Ezequias.models.Produtoras;
import com.projetopessoal.Projeto.pessoal.aula.Ezequias.services.ProdutorasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class ProdutorasResources {
    @Autowired
    private ProdutorasService produtorasService;
    @GetMapping("{id}")
    public ResponseEntity<ProdutorasDTO> buscarProdutorasPorId(@PathVariable Long id) {
        Produtoras produtoras = produtorasService.buscarProdutorasPorId(id);
        return ResponseEntity.ok(produtorasService.converterProdutorasParaProdutorasDTO(produtoras));
    }
    @GetMapping("/buscar")
    public ResponseEntity<ProdutorasDTO> buscarProdutorasPorEmail(@RequestParam Long cpf_cnpj) {
        ProdutorasDTO produtorasDTO = produtorasService.buscarProdutorasPorCpf_cnpj(cpf_cnpj);
        return ResponseEntity.ok(produtorasDTO);
    }
    @PostMapping()
    public ResponseEntity<ProdutorasDTO> criarProdutoras(@RequestBody ProdutorasDTO usuarioDTO) {
        return ResponseEntity.ok(produtorasService.salvarProdutoras(usuarioDTO));
    }
    @PutMapping()
    public ResponseEntity<ProdutorasDTO> atualizarPrdoutoras(@RequestBody ProdutorasDTO usuarioDTO){
        return ResponseEntity.ok(produtorasService.atualizarProdutoras(usuarioDTO));
    }
    @DeleteMapping()
    public ResponseEntity<ProdutorasDTO> deletarProdutoras(@RequestBody ProdutorasDTO usuarioDTO){
        produtorasService.deletarProdutoras(usuarioDTO.getId());
        return ResponseEntity.noContent().build();
    }
}