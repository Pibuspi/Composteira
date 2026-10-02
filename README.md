# Composteira Urbana Doméstica

Aplicação web para acompanhar uma composteira doméstica com três módulos empilhados.

## Funcionalidades

- Dashboard com status dos três módulos.
- Cadastro e listagem de resíduos do Módulo 1.
- Registro, edição e exclusão de medições de líquido nos Módulos 2 e 3.
- Dados iniciais de exemplo carregados automaticamente no H2.
- Console H2 disponível em `/h2-console`.

## Executar localmente

Requisitos: Java 21 e Maven 3.8+.

```bash
mvn spring-boot:run
```

Acesse http://localhost:8080.

Para gerar o pacote:

```bash
mvn clean package
java -jar target/composteira-0.0.1-SNAPSHOT.jar
```

## API

- `GET /api/modulos`
- `PUT /api/modulos/{id}`
- `GET|POST /api/residuos`
- `DELETE /api/residuos/{id}`
- `GET|POST /api/liquidos`
- `PUT|DELETE /api/liquidos/{id}`
