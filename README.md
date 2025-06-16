# FIAP Challenge - API com Spring Boot

## integrantes:
 - Guilherme Daher - 98611 <br>
 - Gabriel Toledo - 551654 <br>
 - Gustavo Akio - 550241 <br>
 - Gabriel Freitas - 550187 <br>
 - Heitor Nobre - 551539 <br>

Este projeto é uma API RESTful desenvolvida em **Spring Boot**, que oferece autenticação com **JWT**, endpoints protegidos, e documentação interativa com **Swagger UI**.

## ✨ Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Security
- JWT (com `com.auth0:java-jwt`)
- Maven
- Swagger OpenAPI 3 (`springdoc-openapi`)
- Lombok (opcional)
- PostgreSQL / H2 / outro banco (conforme configuração)
  
---

## 🔐 Autenticação JWT

A autenticação é feita via token JWT. Ao fazer login com credenciais válidas, um token é gerado e deve ser usado nos headers das requisições protegidas.

### 📥 Obter Token

```
POST /auth/login
Content-Type: application/json

{
"username": "admin",
"password": "123456"
}
```

### 📤 Usar Token

Adicione o token no header de requisições autenticadas:

```
Authorization: Bearer SEU_TOKEN_AQUI
```

## 📁 Versionamento de API

- `v1`: endpoints públicos ou legados (não requerem autenticação)
- `v2`: endpoints protegidos por autenticação JWT

Exemplo:
```http
GET /api/v1/ia
GET /api/v2/ia
```

🔎 Swagger UI
A documentação da API pode ser acessada via:
```
http://localhost:8080/docs
```

Autentique-se clicando no botão Authorize e insira seu token!

```
src/
├── main/
│   ├── java/
│   │   └── br/com/fiap/challenge/
│   │       ├── controller/         # Controllers das versões v1, v2
│   │       ├── model/              # Modelos de domínio
│   │       ├── service/            # Lógica de negócio
│   │       ├── dto/                # DTOs para entrada/saída
│   │       ├── configs/            # Filtros e config do Spring Security
│   │       └── utils/              # JwtUtils (geração e validação)
│   └── resources/
│       ├── application.properties  # Configurações

```
# 📜 Segurança com Spring Security
## Filtro de Autenticação
Classe JwtFilter intercepta as requisições, valida o token e insere o usuário no contexto de segurança.

```java
http.csrf().disable()
    .authorizeHttpRequests()
    .requestMatchers("/auth/**", "/api/v1/**", "/v3/api-docs/**", "/swagger-ui/**", "/docs/**").permitAll()
    .anyRequest().authenticated()
    .and()
    .addFilterBefore(new JwtFilter(jwtUtils, authService), UsernamePasswordAuthenticationFilter.class);
```


## ✅ Requisitos
 - Java 17+
 - Maven
 - IDE (IntelliJ, Eclipse, VS Code)
   

## ▶️ Como Rodar
 - Clone o repositório

 - Configure seu banco de dados (ou use o H2 para testes)

 - Rode o projeto (./mvnw spring-boot:run)

 - Acesse o Swagger em http://localhost:8080/docs


