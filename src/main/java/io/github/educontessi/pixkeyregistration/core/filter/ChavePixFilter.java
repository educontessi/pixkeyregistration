package io.github.educontessi.pixkeyregistration.core.filter;

import io.github.educontessi.pixkeyregistration.core.enums.TipoChave;

/**
 * @author Eduardo Possamai Contessi
 */
public class ChavePixFilter {
    private TipoChave tipoChave;
    private String nomeCorrentista;

    public TipoChave getTipoChave() {
        return tipoChave;
    }

    public void setTipoChave(TipoChave tipoChave) {
        this.tipoChave = tipoChave;
    }

    public String getNomeCorrentista() {
        return nomeCorrentista;
    }

    public void setNomeCorrentista(String nomeCorrentista) {
        this.nomeCorrentista = nomeCorrentista;
    }
}
