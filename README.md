# Velune

Projeto de estudo para praticar Java e construir, passo a passo, uma aplicação de gestão hoteleira. O objetivo é aprender lógica, orientação a objetos, SQL, Spring e a arquitetura usada em aplicações backend.

> **Status:** em desenvolvimento. A interface web já está conectada às operações de hóspedes, quartos e reservas. O módulo de equipe e alguns indicadores do painel ainda usam dados de demonstração.

## O que já existe

- Cadastro e consulta de hóspedes, quartos e reservas com persistência em PostgreSQL.
- Verificação de conflito de datas ao criar uma reserva.
- Busca de reservas que incluem uma data informada.
- Cancelamento pela API, atualmente localizado pelo ID do quarto e uma data.
- Interface web escura com painel, hóspedes, quartos, reservas e equipe.

### Limites conhecidos

- A tela de reservas carrega a lista geral. A busca por data existe na API, mas a interface ainda não a usa para listar reservas de uma data escolhida.
- O fluxo planejado é escolher uma reserva da lista e cancelar exatamente aquela reserva. Hoje o cancelamento usa quarto e data.
- RH/equipe e alguns indicadores são exemplos visuais, sem API REST ligada ao banco.
- Não há autenticação, autorização ou scripts de migração do banco.

## Tecnologias

- Java 25; Spring Boot 4.1.1; Spring Web; Bean Validation.
- Spring Data JPA / Hibernate; PostgreSQL; Maven.
- JUnit e Mockito.
- HTML, CSS e JavaScript na interface (sem React neste momento).

## Arquitetura

Na API, uma requisição segue este caminho:

**Navegador ou cliente HTTP → Controller → Service → Repository → PostgreSQL**

- **Controller:** recebe a requisição HTTP, valida a entrada e chama o service.
- **Service:** concentra as regras de negócio, como verificar se um quarto está livre.
- **Repository:** usa Spring Data JPA para consultar e salvar entidades no banco.
- **Model:** representa os conceitos do sistema e, nos casos persistidos, as entidades JPA.
- **DTO:** define os dados aceitos na entrada da API.

O Spring serve os arquivos de `src/main/resources/static`. O navegador carrega o HTML, CSS e JavaScript; o JavaScript consulta a API.

Há classes de estudo mais antigas, como `Main`, `Hotel`, `Recepcao` e `RH`, que trabalham com listas em memória. Elas demonstram lógica e orientação a objetos, mas são separadas do fluxo Spring/JPA usado pela interface.

## Interface web

Com a aplicação iniciada, abra `http://localhost:8080`.

- **Painel:** visão geral; alguns números, agenda e gráficos são demonstrações.
- **Hóspedes:** lista, pesquisa e cadastro via API.
- **Quartos:** lista, filtros e cadastro via API.
- **Reservas:** lista, cadastro e cancelamento via API.
- **Equipe:** conteúdo de demonstração, sem persistência.

## Endpoints atuais

| Método | Rota | Descrição | Sucesso |
|---|---|---|---|
| `GET` | `/hotel` | Verifica se a aplicação responde | `200 OK` |
| `GET` | `/hospedes` | Lista hóspedes | `200 OK` |
| `GET` | `/hospedes/{documento}` | Busca hóspede pelo documento | `200 OK` ou `404 Not Found` |
| `POST` | `/hospedes` | Cadastra hóspede | `201 Created` |
| `GET` | `/quartos` | Lista quartos | `200 OK` |
| `POST` | `/quartos` | Cadastra quarto | `201 Created` |
| `GET` | `/reservas` | Lista reservas | `200 OK` |
| `GET` | `/reservas/{data}` | Lista reservas que incluem a data (`yyyy-MM-dd`) | `200 OK` |
| `POST` | `/reservas` | Cria reserva | `201 Created` |
| `DELETE` | `/reservas/{quartoId}/{data}` | Cancela reserva localizada pelo quarto e pela data | `204 No Content` |

A busca por data considera o check-in como parte da estadia e o check-out como o primeiro dia fora dela. Uma reserva com check-out em 10 de junho não aparece como ocupando o quarto nesse dia.

### Criar uma reserva

O corpo de `POST /reservas` recebe `hospedeId`, `quartoId`, `dataCheckIn`, `dataCheckOut` e, opcionalmente, `observacao`. Use datas no formato `yyyy-MM-dd`; o check-out deve ser posterior ao check-in.

## Executar localmente

### Pré-requisitos

- JDK 25
- Maven
- PostgreSQL

Clone o repositório:

```bash
git clone https://github.com/MarcosEduardoDev/Velune.git
cd Velune
```

Crie no PostgreSQL um banco chamado `Velune`. O projeto ainda não possui migrações nem um script completo do schema; as tabelas de hóspedes, quartos e reservas precisam existir e corresponder às entidades JPA.

Configure a conexão por variáveis de ambiente. Exemplo no PowerShell:

```powershell
$env:SPRING_DATASOURCE_URL = "jdbc:postgresql://localhost:5432/Velune"
$env:SPRING_DATASOURCE_USERNAME = "seu_usuario"
$env:SPRING_DATASOURCE_PASSWORD = "sua_senha"
```

Essas variáveis valem para a sessão atual do terminal. Não coloque senhas reais em arquivos versionados.

Com o banco configurado e o schema preparado, inicie a aplicação:

```bash
mvn spring-boot:run
```

Depois, abra `http://localhost:8080` no navegador.

## Estrutura principal

```text
src/
├── main/
│   ├── java/velune/
│   │   ├── controller/   # Endpoints REST
│   │   ├── dto/          # Dados de entrada e validações
│   │   ├── exception/    # Exceções e respostas de erro
│   │   ├── model/        # Entidades e modelos de domínio
│   │   ├── repository/   # Acesso com Spring Data JPA
│   │   └── service/      # Regras de negócio
│   └── resources/
│       ├── application.properties
│       └── static/       # HTML, CSS e JavaScript
└── test/                 # Testes automatizados
```

## Conceitos praticados

- Lógica, métodos, coleções e orientação a objetos.
- Enums, Streams, lambdas e `Optional`.
- API REST, injeção de dependência e separação de responsabilidades.
- DTOs, validação e tratamento de exceções.
- Entidades JPA, relacionamentos e consultas ao banco.
- Integração entre JavaScript no navegador e uma API Spring.

## Próximos passos

- Consolidar o cancelamento para selecionar uma reserva específica.
- Conectar a busca por data da API à interface.
- Preparar o schema do banco por script ou ferramenta de migração.
- Evoluir o módulo de equipe e substituir os dados de demonstração.
- Ampliar e executar os testes depois de concluir a lógica e os frameworks.
- Adicionar autenticação e autorização antes de usar dados reais.

---

Projeto de estudo para evolução prática em desenvolvimento backend com Java.
