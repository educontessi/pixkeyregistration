package io.github.educontessi.pixkeyregistration.adapters.out.persistence.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;

@MappedSuperclass
@JsonInclude(Include.NON_NULL)
public abstract class BaseEntity {

    @Column(name = "data_hora_inclusao", insertable = false, updatable = false)
    protected LocalDateTime dataHoraInclusao;

    @Column(name = "data_hora_alteracao", insertable = false, updatable = false)
    protected LocalDateTime dataHoraAlteracao;

    @Column(name = "data_hora_inativacao", insertable = false)
    protected LocalDateTime dataHoraInativacao;

    public LocalDateTime getDataHoraInclusao() {
        return dataHoraInclusao;
    }

    public void setDataHoraInclusao(LocalDateTime dataHoraInclusao) {
        this.dataHoraInclusao = dataHoraInclusao;
    }

    public LocalDateTime getDataHoraAlteracao() {
        return dataHoraAlteracao;
    }

    public void setDataHoraAlteracao(LocalDateTime dataHoraAlteracao) {
        this.dataHoraAlteracao = dataHoraAlteracao;
    }

    public LocalDateTime getDataHoraInativacao() {
        return dataHoraInativacao;
    }

    public void setDataHoraInativacao(LocalDateTime dataHoraInativacao) {
        this.dataHoraInativacao = dataHoraInativacao;
    }
}
