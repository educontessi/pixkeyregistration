package io.github.educontessi.pixkeyregistration.core.model;

import io.github.educontessi.pixkeyregistration.core.enums.TipoChave;
import io.github.educontessi.pixkeyregistration.core.enums.TipoConta;

import javax.validation.constraints.*;
import java.util.UUID;

public class ChavePix extends BaseModel {

    private UUID id;

    @NotNull
    private TipoChave tipoChave;

    @NotBlank
    private String valorChave;

    @NotNull
    private TipoConta tipoConta;

    @NotNull
    @Digits(integer = 4, fraction = 0)
    private Integer agencia;

    @NotNull
    @Digits(integer = 8, fraction = 0)
    private Integer conta;

    @NotBlank
    @Size(min = 3, max = 30)
    private String nomeCorrentista;

    @Size(min = 3, max = 45)
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

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public Integer getConta() {
        return conta;
    }

    public void setConta(Integer conta) {
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
