# Game Reviews API

API RESTful para avaliação de jogos, permitindo cadastro de jogos, usuários e reviews, com cálculo automático da nota média dos jogos.

---

## Tecnologias

* Java 17
* Spring Boot
* Spring Data JPA
* H2/PostgreSQL (ou outro banco de dados)
* Maven
* Postman/Thunder Client para testes

---

## Endpoints

### 1️⃣ Jogos (`/games`)

| Método | Rota                          | Descrição                  |
| ------ | ----------------------------- | -------------------------- |
| POST   | `/games`                      | Cria um novo jogo          |
| GET    | `/games`                      | Lista todos os jogos       |
| GET    | `/games/{id}`                 | Busca um jogo por ID       |
| GET    | `/games/search?title={title}` | Busca jogos pelo título    |
| PUT    | `/games/{id}`                 | Atualiza um jogo existente |
| DELETE | `/games/{id}`                 | Deleta um jogo             |

**Exemplo de criação de jogo (POST /games):**

```json
{
  "title": "The Witcher 3",
  "genre": ["RPG", "Aventura"],
  "plataform": ["PC", "PS5"],
  "urlImage": "https://example.com/witcher3.jpg",
  "releaseDate": "2015-05-19"
}
```

**Exemplo de resposta:**

```json
{
  "id": 1,
  "title": "The Witcher 3",
  "genre": ["RPG", "Aventura"],
  "plataform": ["PC", "PS5"],
  "urlImage": "https://example.com/witcher3.jpg",
  "releaseDate": "2015-05-19",
  "note": 9.5
}
```

---

### 2️⃣ Usuários (`/usuarios`)

| Método | Rota                                  | Descrição                           |
| ------ | ------------------------------------- | ----------------------------------- |
| POST   | `/usuarios`                           | Cria um novo usuário                |
| GET    | `/usuarios`                           | Lista todos os usuários             |
| GET    | `/usuarios/{id}`                      | Busca um usuário por ID             |
| GET    | `/usuarios/search?usuario={username}` | Busca usuários pelo nome de usuário |
| DELETE | `/usuarios/{id}`                      | Deleta um usuário                   |

**Exemplo de criação de usuário (POST /usuarios):**

```json
{
  "nome": "João Silva",
  "email": "joao@email.com",
  "usuario": "joaosilva",
  "senha": "123456"
}
```

**Exemplo de resposta:**

```json
{
  "id": 1,
  "nome": "João Silva",
  "email": "joao@email.com",
  "usuario": "joaosilva"
}
```

---

### 3️⃣ Reviews (`/reviews`)

| Método | Rota                           | Descrição                            |
| ------ | ------------------------------ | ------------------------------------ |
| POST   | `/reviews/game/{gameId}`       | Cria uma review para um jogo         |
| GET    | `/reviews`                     | Lista todas as reviews               |
| GET    | `/reviews/game/{gameId}`       | Lista todas as reviews de um jogo    |
| PUT    | `/reviews/{id}`                | Atualiza uma review existente        |
| DELETE | `/reviews/{id}`                | Deleta uma review                    |
| GET    | `/reviews/game/{gameId}/media` | Retorna a média das notas de um jogo |

**Exemplo de criação de review (POST /reviews/game/1):**

```json
{
  "title": "Excelente RPG",
  "comment": "História incrível e gráficos lindos!",
  "note": 9.5,
  "usuarioId": 1
}
```

**Exemplo de resposta:**

```json
{
  "id": 1,
  "title": "Excelente RPG",
  "comment": "História incrível e gráficos lindos!",
  "note": 9.5,
  "usuarioId": 1,
  "gameId": 1
}
```

**Exemplo de média de notas (GET /reviews/game/1/media):**

```json
9.5
```

---

## Como rodar

1. Clone o repositório:

```bash
git clone https://github.com/GuylhermeLima/game-reviews.git
```

2. Entre na pasta do projeto e rode com Maven:

```bash
cd game-reviews
mvn spring-boot:run
```

3. Acesse `http://localhost:8080` e teste os endpoints com Postman ou Thunder Client.

---

## Testes recomendados

* Crie primeiro **usuários**.
* Crie depois **jogos**.
* Por fim, crie **reviews** para os jogos.
* Confira se a **nota média** do jogo está sendo atualizada automaticamente.

---

## Observações

* A senha do usuário **não é exposta** nas respostas.
* As notas médias dos jogos são recalculadas automaticamente sempre que uma review é criada, atualizada ou deletada.
* Endpoints seguem a arquitetura RESTful.
