# Login & Register System (Fullstack Spring Boot)

Um sistema simples de cadastro e login de usuários, com front-end integrado servido diretamente pelo Spring Boot e persistência de dados no PostgreSQL.

---

## 🛠️ Tecnologias Utilizadas

* **Backend:** Java, Spring Boot (Spring Web, Spring Data JPA)
* **Frontend:** HTML5, CSS3, JavaScript (Vanilla)
* **Banco de Dados:** PostgreSQL
* **Gerenciador de Dependências:** Maven

---

## 📁 Estrutura do Projeto

* `src/main/java/.../controller`: Endpoints da API e redirecionamento inicial.
* `src/main/java/.../model`: Definição da entidade `UsuarioEntity` mapeada para o banco de dados.
* `src/main/java/.../repository`: Interface de acesso ao banco (JPA Repository).
* `src/main/java/.../service`: Regras de negócio para cadastro, login e validação.
* `src/main/resources/static`: Arquivos do Frontend (HTML, CSS e JS).

---

## ⚙️ Pré-requisitos

Antes de iniciar, certifique-se de ter instalado:
* **Java JDK 17** ou superior
* **Maven** (opcional, pois o projeto inclui o wrapper `./mvnw`)
* **PostgreSQL** instalado e em execução

---

## 🚀 Como Executar

### 1. Configurar o Banco de Dados
No PostgreSQL, crie um banco de dados com o nome `login-registerdb`.

Se necessário, ajuste as credenciais de acesso (usuário e senha) no arquivo `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/login-registerdb
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

### 2. Rodar a Aplicação
Navegue até a pasta raiz do projeto e execute o comando:

**No Windows (PowerShell/CMD):**
```bash
.\mvnw.cmd spring-boot:run
```

**No Linux/macOS:**
```bash
chmod +x mvnw
./mvnw spring-boot:run
```

### 3. Acessar a Aplicação
Com o servidor rodando, abra o navegador e acesse:
👉 **[http://localhost:8080](http://localhost:8080)** (você será automaticamente redirecionado para a tela de login)

---

## 🔌 API Endpoints

A API expõe os seguintes endpoints sob a rota `/users`:

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| `POST` | `/users/register` | Cadastra um novo usuário. Retorna `200 OK` em caso de sucesso ou `400 Bad Request` se o login já existir. |
| `POST` | `/users/login` | Autentica um usuário. Retorna `200 OK` (true) se as credenciais forem válidas ou `400 Bad Request` se incorretas. |
