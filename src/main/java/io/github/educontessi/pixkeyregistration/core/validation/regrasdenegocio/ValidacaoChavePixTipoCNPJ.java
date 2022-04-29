package io.github.educontessi.pixkeyregistration.core.validation.regrasdenegocio;

import io.github.educontessi.pixkeyregistration.core.exception.ValidacaoChavePixException;
import io.github.educontessi.pixkeyregistration.core.validation.Validator;

import java.util.InputMismatchException;

/**
 * @author Eduardo Possamai Contessi
 */
public class ValidacaoChavePixTipoCNPJ implements Validator {

    private final String valorChave;

    public ValidacaoChavePixTipoCNPJ(String valorChave) {
        this.valorChave = valorChave;
    }

    @Override
    public void validate() {

        if (valorChave.replaceAll("[0-9]", "").length() > 0) {
            throw new ValidacaoChavePixException("CNPJ possui conteúdo inválido: " + valorChave);
        }

        if (valorChave.length() != 14) {
            throw new ValidacaoChavePixException("Tamanho CNPJ inválido: " + valorChave);
        }

        if (!cnpjValido(valorChave)) {
            throw new ValidacaoChavePixException("CNPJ formato inválido: " + valorChave);
        }
    }

    protected boolean cnpjValido(String cnpj) {
        if (cnpjIgual(cnpj))
            return (false);

        char dig13;
        char dig14;
        int sm;
        int i;
        int r;
        int num;
        int peso;

        try {
            sm = 0;
            peso = 2;
            for (i = 11; i >= 0; i--) {
                num = cnpj.charAt(i) - 48;
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10)
                    peso = 2;
            }

            r = sm % 11;
            if ((r == 0) || (r == 1))
                dig13 = '0';
            else
                dig13 = (char) ((11 - r) + 48);

            sm = 0;
            peso = 2;
            for (i = 12; i >= 0; i--) {
                num = cnpj.charAt(i) - 48;
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10)
                    peso = 2;
            }

            r = sm % 11;
            if ((r == 0) || (r == 1))
                dig14 = '0';
            else
                dig14 = (char) ((11 - r) + 48);

            return (dig13 == cnpj.charAt(12)) && (dig14 == cnpj.charAt(13));
        } catch (InputMismatchException erro) {
            return false;
        }
    }

    private boolean cnpjIgual(String cnpj) {
        return cnpj.equals("00000000000000") || cnpj.equals("11111111111111") || cnpj.equals("22222222222222")
                || cnpj.equals("33333333333333") || cnpj.equals("44444444444444") || cnpj.equals("55555555555555")
                || cnpj.equals("66666666666666") || cnpj.equals("77777777777777") || cnpj.equals("88888888888888")
                || cnpj.equals("99999999999999");
    }

}
