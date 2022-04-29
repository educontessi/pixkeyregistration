package io.github.educontessi.pixkeyregistration.core.validation.regrasdenegocio;

import io.github.educontessi.pixkeyregistration.core.exception.ValidacaoChavePixException;
import io.github.educontessi.pixkeyregistration.core.validation.Validator;

import java.util.InputMismatchException;

/**
 * @author Eduardo Possamai Contessi
 */
public class ValidacaoChavePixTipoCPF implements Validator {

    private final String valorChave;

    public ValidacaoChavePixTipoCPF(String valorChave) {
        this.valorChave = valorChave;
    }

    @Override
    public void validate() {

        if (valorChave.replaceAll("[0-9]", "").length() > 0) {
            throw new ValidacaoChavePixException("CPF possui conteúdo inválido: " + valorChave);
        }

        if (valorChave.length() != 11) {
            throw new ValidacaoChavePixException("Tamanho CPF inválido: " + valorChave);
        }

        if (!cpfValido(valorChave)) {
            throw new ValidacaoChavePixException("CPF formato inválido: " + valorChave);
        }
    }

    protected boolean cpfValido(String cpf) {
        if (cpfIgual(cpf))
            return (false);

        char dig10;
        char dig11;
        int sm;
        int i;
        int r;
        int num;
        int peso;

        try {
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                num = cpf.charAt(i) - 48;
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else
                dig10 = (char) (r + 48);

            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = cpf.charAt(i) - 48;
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else
                dig11 = (char) (r + 48);

            return (dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10));
        } catch (InputMismatchException erro) {
            return (false);
        }
    }

    private boolean cpfIgual(String cpf) {
        return cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222")
                || cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555")
                || cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888")
                || cpf.equals("99999999999");
    }

}
