# 📝 ToDo List API

Esta é uma API REST desenvolvida com Spring Boot para gerenciamento de tarefas (ToDos), com operações de criação, leitura, atualização, remoção e busca personalizada.

---

## 🚀 Tecnologias usadas

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database (em memória)
- Bean Validation
- Lombok

---

## 📚 Funcionalidades

- ✅ Criar tarefas com título, descrição, data e prioridade.
- 🔍 Buscar todas as tarefas.
- 🔎 Buscar por título.
- 📌 Buscar e ordenar por prioridade.
- 🛡️ Validação automática com mensagens de erro amigáveis.
- ❗ Tratamento global de exceções com `@ControllerAdvice`.

---

## 🎯 Endpoints principais

| Método | Rota                            | Descrição                                 |
|--------|----------------------------------|-------------------------------------------|
| POST   | `/todos`                         | Cria uma nova tarefa                      |
| GET    | `/todos`                         | Retorna todas as tarefas                  |
| GET    | `/todos/{id}`                    | Retorna uma tarefa por ID                 |
| GET    | `/todos/by-title?value=`         | Busca por título                          |
| GET    | `/todos/by-priority?direction=`  | Ordena por prioridade (`asc` ou `desc`)   |
| PUT    | `/todos/{id}`                    | Atualiza uma tarefa                       |
| DELETE | `/todos/{id}`                    | Deleta uma tarefa                         |

---

## ⚠️ Validações

- O título **não pode estar em branco**.
- A prioridade deve ser um dos valores definidos no **enum `Priority`** (ex: `LOW`, `MEDIUM`, `HIGH`).
- Os erros são tratados de forma personalizada e padronizada com resposta em JSON.

---

## ✅ Como rodar o projeto localmente

### 1. Clone o repositório:
```bash
https://github.com/motinhapro/ToDoList
```
### 2. ⚙️ Perfil de Teste

Este projeto possui um perfil de teste (`test`) que inicializa o banco de dados com algumas tarefas prontas automaticamente. Isso facilita testar a API sem precisar criar dados manualmente.

### Como rodar com o perfil `test`:

Pelo terminal, use:

```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=test
```

### 3. Acesse no navegador:
- API Base: http://localhost:8080/todos

- H2 Console: http://localhost:8080/h2-console

- JDBC URL: jdbc:h2:mem:testdb

- Usuário: sa

- Senha: (em branco)

## 🧪 Exemplos de requisição

### Buscar todas as tarefas:
```http
GET /todos
```
### Buscar por título:
```http
GET /todos
```

### Criar uma tarefa:
```http
POST /todos
Content-Type: application/json

{
  "title": "Estudar Spring",
  "description": "Focar em API REST",
  "priority": "HIGH",
  "dueDate": "2025-08-01T23:59:00Z"
}
```

### Buscar por prioridade (ordenação):

```http
GET /todos/by-priority?direction=asc
```

### Atualizar uma tarefa:

```http
PUT /todos/1
Content-Type: application/json

{
"title": "Estudar Spring Boot",
"description": "API REST e JPA",
"priority": "MEDIUM",
"dueDate": "2025-08-15T23:59:00Z",
"status": "IN_PROGRESS"
}
```

### Deletar uma tarefa:
```http
DELETE /todos/1
```

## 👨‍💻 Autor

- Carlos Eduardo Mota Lourenço

- GitHub: github.com/motinhapro

- LinkedIn: linkedin.com/in/carlos-eduardo-mota-lourenço-79364b324

## 📌 Observação
Este projeto foi desenvolvido com fins educacionais, com foco em boas práticas de desenvolvimento com Spring Boot e arquitetura limpa.



