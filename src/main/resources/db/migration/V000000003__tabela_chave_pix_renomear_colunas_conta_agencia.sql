ALTER TABLE `chave_pix`
    CHANGE COLUMN `agencia` `numero_agencia` INT(10) NOT NULL AFTER `tipo_conta`,
    CHANGE COLUMN `conta` `numero_conta` INT(10) NOT NULL AFTER `numero_agencia`;
