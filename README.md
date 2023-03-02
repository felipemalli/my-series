# My series

This project is a API rest for handling series.
It was made with Spring for data persistence and there is a exception handling with ControllerAdvice and ExceptionHandler.

<br>

## Startup

1. Clone the repository.
    * `git clone git@github.com:felipemalli/my-series.git`

2. Install dependencies:
    * `mvn install`

3. Run the project:
    * `mvn spring-boot:run`

<br>

---

<br>

## Operations
### Description

With this API, it's possible to:
- Register and view the series you have already watched;
- Add episodes to series you've already watched (indicating the episode number and the time in minutes it has);
- Remove series with its episodes;
- View watched episodes of a particular series;
- View total time spent of all episodes already watched in all series."


<br>

### Endpoints Summary

- Create a new serie: `POST /series`

- Read all series:  `GET /series`

- Delete a professional: `DELETE /api/professional/delete/{id}`

- Update a professional: `PUT /api/professional/edit/{id}`

<br>

### Endpoints:
- Series registration <br>
Route `/series` <br>
Method: POST <br>
Request body:
  ```json
  {
      "nome":"Doctor Who"
  }
  ```
  Body response:
  ```json
  {
      "id": 1,
      "nome": "Doctor Who",
      "episodios": []
  }
  ```

<br>

- View series <br>
Route `/series` <br>
Method: GET <br>
Request body:
  ```json
  [
      {
          "id": 1,
          "nome": "Doctor Who",
          "episodios": []
      },
      {
          "id": 2,
          "nome": "Friends",
          "episodios": []
      }
  ]
  ```

<br>

- Remove series <br>
Route `/series/{serie_id}` <br>
Method: DELETE

<br>

- Add episodes <br>
Route `/series/{serie_id}/episodios` <br>
Method: POST <br>
Request body:
  ```json
  {
    "numero": 1,
    "duracaoEmMinutos": 60
  }
  ```
  Response body:
  ```json
  {
      "id": 1,
      "nome": "Doctor Who",
      "episodios": [
          {
              "id": 2,
              "numero": 1,
              "duracaoEmMinutos": 60
          }
      ]
  }
  ```

<br>

- View episodes of a series <br>
Route `/series/{serie_id}/episodios` <br>
Method: GET <br>
Response body:
  ```json
  [
    {
      "id": 2,
      "numero": 1,
      "duracaoEmMinutos": 60
    }
  ]
  ```

<br>

- View time spent <br>
Route `/series/tempo` <br>
Method: GET <br>
Response body:
  ```json
  {
    "tempoEmMinutos": 600
  }
  ```

<br>

### Exceptions

I utilize a `ControllerAdivice` for mapping the exceptions with `ExceptionHandler`.

- Series registration with existing name throw the exception `SerieExistenteException`
- Attempts to access a series that does not exist throw the exception `SerieNaoEncontradaException`
- Adding episodes with the same number for the same series throws the exception `EpisodioExistenteException`
- Error cases not mapped in this document throw the exception `ErroInesperadoException`

<br>

Exception: SerieExistenteException <br>
StatusCode: 409  <br>
Body Response:
```json
{
  "error": "Série Existente"
}
```

Excecption: EpisodioExistenteException <br>
statusCode: 409  <br>
Body Response:
```json
{
  "error": "Episódio Existente"
}
```

Exception: SerieNaoEncontradaException <br>
StatusCode: 404  <br>
Body Response:
```json
{
  "error": "Série não encontrada"
}
```

Exception: ErroInesperadoException <br>
StatusCode: 500 <br>
Body Response:
```json
{
  "error": "Erro inesperado"
}
```
<br>

I add a `CircuitBreaker` with the library `resilience4j` in endpoint `/series/{serie_id}/episodios`. If there is 50% error at requisitions, the service send a unavailable response:

Exception: ServicoIndisponivelException <br>
StatusCode 503   <br>
Body Response:
```json
{
  "error": "Serviço temporariamente indisponível"
}
```