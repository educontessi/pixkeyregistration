package io.github.educontessi.pixkeyregistration.core.validation.regrasdenegocio;

import io.github.educontessi.pixkeyregistration.core.exception.ValidacaoChavePixException;
import io.github.educontessi.pixkeyregistration.core.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Eduardo Possamai Contessi
 */
public class ValidacaoChavePixTipoEmail implements Validator {

    private final String valorChave;

    public ValidacaoChavePixTipoEmail(String valorChave) {
        this.valorChave = valorChave;
    }

    @Override
    public void validate() {
        if (!emailValido(valorChave)) {
            throw new ValidacaoChavePixException("E-mail inválido: " + valorChave);
        }
    }

    protected boolean emailValido(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
