package io.github.educontessi.pixkeyregistration.core.model;

import io.github.educontessi.pixkeyregistration.core.enums.TipoChave;
import io.github.educontessi.pixkeyregistration.core.enums.TipoConta;

import java.util.UUID;

public class ChavePix extends BaseModel {

    private UUID id;
    private TipoChave tipoChave;
    private String valorChave;
    private TipoConta tipoConta;
    private int agencia;
    private int conta;
    private String nomeCorrentista;
    private String sobrenomeCorrentista;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public TipoChave getTipoChave() {
        return tipoChave;
    }

    public void setTipoChave(TipoChave tipoChave) {
        this.tipoChave = tipoChave;
    }

    public String getValorChave() {
        return valorChave;
    }

    public void setValorChave(String valorChave) {
        this.valorChave = valorChave;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    public String getNomeCorrentista() {
        return nomeCorrentista;
    }

    public void setNomeCorrentista(String nomeCorrentista) {
        this.nomeCorrentista = nomeCorrentista;
    }

    public String getSobrenomeCorrentista() {
        return sobrenomeCorrentista;
    }

    public void setSobrenomeCorrentista(String sobrenomeCorrentista) {
        this.sobrenomeCorrentista = sobrenomeCorrentista;
    }
}
