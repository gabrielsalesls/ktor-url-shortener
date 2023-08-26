# Encurtador de Links com Kotlin

Uma API utilizando Kotlin e Ktor com o objetivo de encurtar URLs.

Este projeto foi desenvolvido com o objetivo de aprender a respeito do framework Ktor e para aprimorar minhas habilidades com o Kotlin. Dado que minha linguagem de programação principal é o Java, é possível que tenha varios vicios do "javismo" no código.

## Tecnologias utilizadas

- Kotlin
- Ktor
- Exposed
- Postgres
- H2
- Docker

## Rodando localmente

1. Clone o repositorio.

   ```bash
   git clone https://github.com/gabrielsalesls/ktor-url-shortener.git
   cd ktor-url-shortener
   ```

2. Execute este código no terminal na pasta raiz do projeto. É necessario ter o Docker e o Docker Compose instalados.
    ```
    docker-compose up
    ```

## End-Points
- **POST**: Envia uma URL no body para ser encurtada:
```curl --request POST --url http://localhost:8080/ --header 'Content-Type: application/json' --data '{"name": "google.com"}'``` 


- **GET**: Redireciona para a URL original:
  ```curl --request GET --url http://localhost:8080/6c344a```
