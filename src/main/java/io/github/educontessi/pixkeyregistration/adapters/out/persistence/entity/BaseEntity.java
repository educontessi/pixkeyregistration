package io.github.educontessi.pixkeyregistration.adapters.out.persistence.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@JsonInclude(Include.NON_NULL)
public abstract class BaseEntity {

    @Column(name = "data_criacao", insertable = false, updatable = false)
    protected LocalDateTime dataCriacao;

    @Column(name = "data_alteracao", insertable = false, updatable = false)
    protected LocalDateTime dataAlteracao;

    @Column(name = "data_exclusao", insertable = false)
    protected LocalDateTime dataExclusao;

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public LocalDateTime getDataExclusao() {
        return dataExclusao;
    }

    public void setDataExclusao(LocalDateTime dataExclusao) {
        this.dataExclusao = dataExclusao;
    }
}
