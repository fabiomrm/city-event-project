# Event - City Project

## Sobre o projeto

Projeto de conclusão da segunda etapa do curso [Dev Superior](https://www.linkedin.com/school/devsuperior/).
Projeto desenvolvido utilizando o conceito de **TDD**, os repositórios, serviços e recursos foram implementados a partir de testes de integração
<br />

## Endpoints implementados
### GET
* /cities - retorna as cidades ordenadas por ordem alfabética
* /events - retorna os eventos das cidades ordenados por ordem alfabética
* /cities/{id} - retorna dados de uma cidade específica
### POST
* /cities - adiciona uma cidade
```json
{
  "name": "Caruaru",
}
```

### UPDATE
* /events/{id}
```json
{
  "id": "2",
  "name": "CCXP ATUALIZADO",
  "date": "2021-04-13",
  "url": "https://ccxp.com.br",
  "cityId": "1"
}
```

### DELETE
* /cities/{id}



