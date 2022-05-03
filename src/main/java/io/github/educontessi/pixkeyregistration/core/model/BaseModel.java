package io.github.educontessi.pixkeyregistration.core.model;

import java.time.LocalDateTime;

public abstract class BaseModel {

    protected LocalDateTime dataHoraInclusao;
    protected LocalDateTime dataHoraAlteracao;
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

    public boolean estaExcluido() {
        return this.dataHoraInativacao != null;
    }
}
