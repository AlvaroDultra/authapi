# 🔐 AuthAPI — Sistema de Autenticação e Autorização JWT

API REST desenvolvida com **Spring Boot 3**, **Spring Security**, **JWT**, e **PostgreSQL**, com foco em **segurança, controle de acesso e arquitetura limpa**.

---

## 🚀 Tecnologias Utilizadas

| Tecnologia | Função |
|-------------|--------|
| **Spring Boot 3** | Framework principal da aplicação |
| **Spring Security** | Autenticação e autorização |
| **JWT (Json Web Token)** | Controle de sessão stateless |
| **PostgreSQL** | Banco de dados relacional |
| **JPA / Hibernate** | ORM para persistência |
| **Lombok** | Redução de boilerplate |
| **Swagger (SpringDoc)** | Documentação automática da API |
| **Docker** | Containerização (em desenvolvimento) |

---

## 🧩 Funcionalidades

- Registro de usuário (`/auth/register`)
- Login com autenticação JWT (`/auth/login`)
- Renovação de token (`/auth/refresh`)
- Consulta de usuário autenticado (`/auth/me`)
- Logout (revogação de token)
- Controle de acesso baseado em roles (`ROLE_USER`, `ROLE_ADMIN`)
- Tratamento global de erros (`GlobalExceptionHandler`)
- Configuração de CORS e segurança avançada

---

## 📁 Estrutura de Pacotes

```
src/main/java/com/authapi
 ├── controller
 ├── dto
 ├── exception
 ├── model
 ├── repository
 ├── security
 ├── config
 └── AuthApiApplication.java
```

---

## ⚙️ Configuração do Ambiente

### 🧾 Pré-requisitos
- **Java 21+**
- **Maven 3.9+**
- **PostgreSQL 15+**
- (Opcional) **Docker** e **Docker Compose**

---

### 🔧 Configuração do Banco
No PostgreSQL, crie o banco:
```sql
CREATE DATABASE authapi;
```

---

### 📦 Configuração do `application.properties`

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/authapi
spring.datasource.username=postgres
spring.datasource.password=SUA_SENHA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

jwt.secret=CHAVE_EM_BASE64
jwt.expiration=3600000
```

> 💡 Gere sua chave com:
> ```bash
> openssl rand -base64 64
> ```

---

## ▶️ Como Executar o Projeto

### Com Maven:
```bash
mvn spring-boot:run
```

### Ou gerando o JAR:
```bash
mvn clean package
java -jar target/authapi-0.0.1-SNAPSHOT.jar
```

A aplicação rodará em:
```
http://localhost:8080
```

---

## 📚 Documentação (Swagger UI)
Acesse a interface do Swagger:
```
http://localhost:8080/swagger-ui/index.html
```

---

## 🧪 Endpoints Principais

| Método | Rota | Descrição |
|:--:|:--|:--|
| `POST` | `/auth/register` | Cadastra novo usuário |
| `POST` | `/auth/login` | Faz login e retorna token JWT |
| `POST` | `/auth/refresh` | Renova token expirado |
| `GET` | `/auth/me` | Retorna dados do usuário autenticado |
| `POST` | `/auth/logout` | Revoga o token atual |

---

## 🧰 Exemplos de Requisição

### 🔑 Login
```json
POST /auth/login
{
  "email": "admin@email.com",
  "password": "123456"
}
```

**Resposta:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

---

### 👤 /auth/me
Header:
```
Authorization: Bearer <token>
```
Resposta:
```json
{
  "name": "Administrador",
  "email": "admin@email.com",
  "role": "ROLE_ADMIN"
}
```

---

## 🧱 Futuras Implementações
- [ ] Logout com blacklist de tokens
- [ ] Docker Compose (app + PostgreSQL)
- [ ] Testes unitários (`JwtServiceTest`)
- [ ] Deploy gratuito (Render / Railway)
- [ ] Front-end simples com React

---

## 👨‍💻 Autor
**Álvaro Filipe Silva Dultra**  
📍 Salvador - BA  
💼 [LinkedIn](https://www.linkedin.com/in/alvarodultra/)  
🧠 Foco em backend Java

---

## 📜 Licença
Este projeto está licenciado sob a **MIT License** — sinta-se livre para usar e modificar.
