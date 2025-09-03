package com.auditoria.javers.service;


import com.auditoria.javers.api.PermissaoController;
import com.auditoria.javers.model.Permissao;
import com.auditoria.javers.repositories.PermissaoRepository;
import jakarta.transaction.Transactional;
import org.javers.spring.annotation.JaversAuditable;
import org.springframework.stereotype.Service;

@Service
public class PermissaoService {

    private final PermissaoRepository permissaoRepository;

    public PermissaoService(PermissaoRepository permissaoRepository) {
        this.permissaoRepository = permissaoRepository;
    }


    @Transactional
    public void salvar(PermissaoController.PermissaoDTO permissaoDTO) {
        var permissao = new Permissao();
        permissao.setNome(permissaoDTO.nome());
        permissao.setDescricao(permissaoDTO.descricao());
        permissaoRepository.save(permissao);
    }

    @JaversAuditable
    public void atualizar(PermissaoController.PermissaoDTO permissaoDTO){
        var permissao = permissaoRepository.findById(permissaoDTO.id())
                .orElseThrow(() -> new IllegalArgumentException("Permissão não encontrada"));

        permissao.setNome(permissaoDTO.nome());
        permissao.setDescricao(permissaoDTO.descricao());
        permissaoRepository.save(permissao);
    }


    public void deletar(Long id) {
        var permissao = permissaoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Permissão não encontrada"));
        permissaoRepository.delete(permissao);
    }
}
