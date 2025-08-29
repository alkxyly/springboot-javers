package com.auditoria.javers.api;


import com.auditoria.javers.service.PermissaoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/permissao")
public class PermissaoController {

    private final PermissaoService permissaoService;

    public PermissaoController(PermissaoService permissaoService) {
        this.permissaoService = permissaoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody PermissaoDTO permissaoDTO){
         permissaoService.salvar(permissaoDTO);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void atualizar(@RequestBody PermissaoDTO permissaoDTO){
        permissaoService.atualizar(permissaoDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id){
        permissaoService.deletar(id);
    }

   public static record PermissaoDTO(Long id, String nome, String descricao){}
}
