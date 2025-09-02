package com.auditoria.javers.model;

import jakarta.persistence.*;
import org.javers.spring.annotation.JaversAuditable;


import java.util.Objects;


@Entity
@Table(name = "TB_PMS_PERMISSAO")
public class Permissao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PMS_NRID")
    private Long id;

    @Column(name = "PMS_NMPERMISSAO")
    private String nome;

    @Column(name = "PMS_DSPERMISSAO")
    private String descricao;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Permissao permissao = (Permissao) o;
        return Objects.equals(id, permissao.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
