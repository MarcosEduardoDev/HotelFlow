# HotelFlow

Sistema interno de gestão hoteleira, feito para uso por funcionários da empresa. Projeto desenvolvido como estudo prático de Programação Orientada a Objetos em Java, dentro da trilha de back-end.

## Funcionalidades

### Gestão de RH
- Cadastro de funcionários com cálculo automático de salário-base por cargo
- Sistema de aumento salarial e bônus anual, com regras específicas por cargo
- Definição de escalas de trabalho (turno + data)
- Notificações automáticas geradas ao funcionário quando uma escala é definida

### Gestão de Reservas
- Criação de reservas com verificação automática de disponibilidade do quarto
- Cancelamento de reservas
- Cálculo automático do valor total da estadia, baseado no tipo de quarto e período

## Conceitos técnicos aplicados

- Programação Orientada a Objetos: encapsulamento, composição, herança
- Polimorfismo com interface implementada por enum (comportamento diferente por constante)
- Streams e Lambdas (filter, map, sorted, anyMatch, findFirst, collect)
- Optional para tratamento seguro de valores ausentes
- Exceções customizadas (RuntimeException) para regras de negócio
- Manipulação de datas com LocalDate, LocalDateTime e ChronoUnit

## Estrutura do projeto

src/
- ├── hotelflow/
- │ ├── model/ → entidades do domínio (Funcionario, Reserva, Quarto...)
- │ └── service/ → regras de negócio (RH, Recepcao, Hotel)
- └── Main.java


## Como executar

1. Clone o repositório:
```bash
   git clone https://github.com/Marcos1009-spec/HotelFlow.git
```
2. Abra a pasta do projeto no IntelliJ IDEA.
3. Certifique-se de ter o JDK 25 (ou superior) configurado no projeto.
4. Rode o arquivo `Main.java` (botão direito → Run 'Main').

## Autor

Desenvolvido por Marcos Eduardo, como projeto de estudo de POO em Java.

[GitHub](https://github.com/Marcos1009-spec)