# HotelFlow

Sistema de gestão hoteleira desenvolvido em Java, criado inicialmente como projeto de estudo de Programação Orientada a Objetos e evoluindo para uma aplicação backend com API REST, PostgreSQL e Spring Boot.

O projeto simula operações de um sistema interno de gestão hoteleira, com foco em regras de negócio, persistência de dados e construção de uma arquitetura backend.

## Funcionalidades

### Gestão de RH

- Cadastro de funcionários com cálculo automático de salário-base por cargo
- Sistema de aumento salarial e bônus anual
- Regras específicas por cargo
- Definição de escalas de trabalho
- Notificações automáticas ao funcionário quando uma escala é definida

### Gestão de Reservas

- Criação de reservas
- Verificação de disponibilidade do quarto
- Cancelamento de reservas
- Cálculo do valor total da estadia com base no tipo de quarto e período

### API de Hóspedes

- Consulta de hóspedes cadastrados
- Persistência de hóspedes no PostgreSQL
- Endpoint REST para consulta dos hóspedes
- Integração entre Spring Boot, JDBC e PostgreSQL

## Tecnologias

- Java 25
- Spring Boot
- Spring Web
- JDBC
- PostgreSQL
- Maven
- IntelliJ IDEA
- Git/GitHub

## Conceitos técnicos aplicados

### Java

- Programação Orientada a Objetos
- Encapsulamento
- Composição
- Herança
- Polimorfismo
- Interfaces
- Enum com comportamentos específicos por constante
- Collections
- Streams e Lambdas
- Optional
- Exceções customizadas
- LocalDate, LocalDateTime e ChronoUnit

### Banco de dados

- SQL
- PostgreSQL
- JDBC
- PreparedStatement
- ResultSet
- Persistência de dados
- Separação entre lógica de negócio e acesso ao banco

### Spring Boot

- Spring Boot
- API REST
- Controllers
- Repository
- Injeção de Dependência
- Inversion of Control (IoC)
- Mapeamento de endpoints HTTP

## Arquitetura atual

```text
Controller
    ↓
Repository
    ↓
JDBC
    ↓
PostgreSQL