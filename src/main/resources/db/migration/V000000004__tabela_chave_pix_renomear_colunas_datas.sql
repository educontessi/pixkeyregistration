ALTER TABLE `chave_pix`
    CHANGE COLUMN `data_criacao` `data_hora_inclusao` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP AFTER `sobrenome_correntista`,
    CHANGE COLUMN `data_alteracao` `data_hora_alteracao` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP AFTER `data_hora_inclusao`,
    CHANGE COLUMN `data_exclusao` `data_hora_inativacao` TIMESTAMP NULL DEFAULT NULL AFTER `data_hora_alteracao`;
