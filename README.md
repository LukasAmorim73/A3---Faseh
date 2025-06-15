# Sistema de Agendamento - Projeto A3

Este projeto foi desenvolvido como parte da A3 da disciplina de Programação de Soluções Computacionais, com o objetivo de informatizar os processos de agendamento de serviços em pequenas ou médias empresas da região.

## 💡 Funcionalidades do Sistema

- Cadastro de Clientes, Profissionais e Serviços
- Criação, edição e cancelamento de Agendamentos
- Geração de Histórico de atendimentos
- Envio de Notificações (simulação)
- Registro de Transações externas (WhatsApp, Web, Outros)

## 🔧 Tecnologias Utilizadas

- Java 11
- Spring Boot
- MySQL
- Maven
- JPA (Hibernate)
- Lombok

## 🎯 Estrutura do Projeto
src/
├── controller/
├── service/
├── repository/
├── entity/
├── dto/
├── config/
└── Application.java


## 🗃️ Banco de Dados

O banco de dados foi modelado com as seguintes entidades:

- Cliente
- Profissional
- Serviço
- Agendamento
- Histórico
- Notificação
- Transação Externa

### Script SQL

Disponível na pasta `/resources/sql/` como `schema.sql`.

## 🧪 Como Executar

1. Clone o repositório:
```bash
git clone https://github.com/SEU_USUARIO/sistema-agendamento-a3.git

