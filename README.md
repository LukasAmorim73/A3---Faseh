# Sistema de Agendamento - Projeto A3

Este projeto foi desenvolvido como parte da A3 da disciplina de **Programação de Soluções Computacionais**, com o objetivo de informatizar os processos de agendamento de serviços no **FuroLider**.

---

## Funcionalidades do Sistema

- Cadastro de **Clientes**, **Profissionais** e **Serviços**
- Criação, edição e cancelamento de **Agendamentos**
- Geração de **Histórico de Atendimentos**
- Envio de **Notificações** (simulação)
- Registro de **Transações Externas** (WhatsApp, Web, Outros)

---

## Tecnologias Utilizadas

- Java 11
- Spring Boot
- MySQL

---

## Estrutura de Pacotes

O projeto está organizado da seguinte forma:

src/main/java/com/seuusuario/agendamento/

├── controller # Camada de Controllers (REST API)

├── service # Camada de Serviços (Regras de Negócio)

├── repository # Camada de Repositórios (JPA / MySQL)

├── entity # Entidades do Banco de Dados (JPA Entities)

├── dto # Data Transfer Objects (se necessário)

├── util # Classes Utilitárias (se houver)

└── AgendamentoApplication.java # Classe principal Spring Boot

---

## Como Rodar o Projeto Localmente

### Pré-requisitos:

- Java 11+
- MySQL
- Maven

### Passos:

1. **Clone o repositório:**

git clone https://github.com/seuusuario/sistema-agendamento.git
cd sistema-agendamento

2. **Configure o banco de dados:**

Crie um banco no MySQL (exemplo: agendamento_db)
Execute o arquivo SQL que está na pasta /sql do projeto.

3. **Configure o application.properties:**

Exemplo de configuração:

spring.datasource.url=jdbc:mysql://localhost:3306/agendamento_db
spring.datasource.username=root
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

4. **Compile e Rode o projeto:**

mvn clean install
mvn spring-boot:run

## SCRIPT

o Script está em /sql/agendamento.sql

## Gestão de Projeto

Está localizada no Link do Trello: (Botem o link)

