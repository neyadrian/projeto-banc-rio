CREATE DATABASE IF NOT EXISTS banco_swing;
USE banco_swing;

CREATE TABLE contas (
    id_conta INT AUTO_INCREMENT PRIMARY KEY,
    numero_conta VARCHAR(20) NOT NULL UNIQUE,
    nome_titular VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    saldo DECIMAL(15, 2) DEFAULT 0.00,
    data_abertura TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE transacoes (
    id_transacao INT AUTO_INCREMENT PRIMARY KEY,
    id_conta INT NOT NULL,
    tipo_operacao VARCHAR(30) NOT NULL, 
    valor DECIMAL(15, 2) NOT NULL,
    data_hora TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    descricao VARCHAR(100), 
    
    FOREIGN KEY (id_conta) REFERENCES contas(id_conta) ON DELETE CASCADE
);

USE banco_swing;
ALTER TABLE contas ADD COLUMN telefone VARCHAR(20);

ALTER TABLE contas ADD COLUMN data_ultimo_rendimento DATE DEFAULT (CURRENT_DATE); 

ALTER TABLE contas ADD COLUMN tipo_conta VARCHAR(20) DEFAULT 'CORRENTE';