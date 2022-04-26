ALTER DATABASE `gerenciamento_chave_pix` CHARSET = Latin1 COLLATE = latin1_swedish_ci;

CREATE TABLE `chave_pix` (
    `id` BINARY(16) NOT NULL,
	`tipo_chave` VARCHAR(9) NOT NULL,
	`valor_chave` VARCHAR(77) NOT NULL,
	`tipo_conta` VARCHAR(10) NOT NULL,
	`agencia` INT(4) NOT NULL,
	`conta` INT(8) NOT NULL,
	`nome_correntista` VARCHAR(30) NOT NULL,
	`sobrenome_correntista` VARCHAR(45) NULL,
	`data_criacao` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`data_alteracao` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
	`data_exclusao` TIMESTAMP NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
    UNIQUE INDEX `valor_chave` (`valor_chave`) USING BTREE
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;