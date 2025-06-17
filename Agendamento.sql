CREATE DATABASE IF NOT EXISTS sistema_agendamento;
USE sistema_agendamento;

-- Tabela: Cliente
CREATE TABLE Cliente (
id_cliente INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(100) NOT NULL,
telefone VARCHAR(15),
email VARCHAR(100),
endereco TEXT
);

-- Tabela: Profissional
CREATE TABLE Profissional (
id_profissional INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(100) NOT NULL,
telefone VARCHAR(15),
email VARCHAR(100),
especialidade VARCHAR(100)
);

-- Tabela: Servico
CREATE TABLE Servico (
id_servico INT AUTO_INCREMENT PRIMARY KEY,
nome_servico VARCHAR(100) NOT NULL,
duracao_estimativa TIME,
descricao TEXT
);

-- Tabela: Agendamento
CREATE TABLE Agendamento (
id_agendamento INT AUTO_INCREMENT PRIMARY KEY,
data_hora_inicio DATETIME NOT NULL,
data_hora_fim DATETIME NOT NULL,
status ENUM('ativo', 'cancelado', 'editado') DEFAULT 'ativo',
observacoes TEXT,
notificacao_enviada BOOLEAN DEFAULT FALSE,
id_cliente INT,
id_profissional INT,
id_servico INT,
FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente),
FOREIGN KEY (id_profissional) REFERENCES Profissional(id_profissional),
FOREIGN KEY (id_servico) REFERENCES Servico(id_servico)
);

-- Tabela: Historico
CREATE TABLE Historico (
id_historico INT AUTO_INCREMENT PRIMARY KEY,
data_registro DATETIME DEFAULT CURRENT_TIMESTAMP,
relatorio_texto TEXT,
id_agendamento INT,
id_cliente INT,
FOREIGN KEY (id_agendamento) REFERENCES Agendamento(id_agendamento),
FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente)
);

-- Tabela: Notificacao
CREATE TABLE Notificacao (
id_notificacao INT AUTO_INCREMENT PRIMARY KEY,
tipo ENUM('email', 'sms', 'app') NOT NULL,
destinatario VARCHAR(100),
data_envio DATETIME DEFAULT CURRENT_TIMESTAMP,
status_envio ENUM('enviado', 'falha') DEFAULT 'enviado',
id_agendamento INT,
FOREIGN KEY (id_agendamento) REFERENCES Agendamento(id_agendamento)
);

-- Tabela: Transacao_Externa
CREATE TABLE Transacao_Externa (
id_transacao INT AUTO_INCREMENT PRIMARY KEY,
canal ENUM('whatsapp', 'web', 'outro') NOT NULL,
mensagem TEXT,
data_recebimento DATETIME DEFAULT CURRENT_TIMESTAMP,
id_cliente INT,
FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente)
);
