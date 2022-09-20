### Termos e acordos

Ao iniciar este projeto, você concorda com as diretrizes do Código de Ética e Conduta e do Manual da Pessoa Estudante da Trybe.

---

# Boas vindas ao repositório do desafio da Aceleração Java!

Você já usa o GitHub diariamente para desenvolver os exercícios, certo? Agora, para desenvolver o desafio, você deverá seguir as instruções a seguir. Fique atento a cada passo, e se tiver qualquer dúvida, nos envie por _Slack_! #vqv 🚀

Aqui você vai encontrar os detalhes de como estruturar o desenvolvimento do seu desafio a partir deste repositório, utilizando uma branch específica e um _Pull Request_ para colocar seus códigos.

---
# Instruções para entregar seu projeto

## Não se esqueça de consultar as documentações!

⚠️ **Importante**:

Esse projeto tem como intuito te treinar para ter mais familiaridade com a documentação de aplicações, por tanto, poderão haver alguns comandos ou atributos que não estão no curso, mas que devem ser descritos no decorrer dos requisitos.

Nesses casos, é importante se atentar a aquilo que o requisito pede, e lembrar sempre de utilizar a [documentação oficial](https://docs.oracle.com/en/java/javase/11/) do Java para pesquisar detalhes sobre comandos.


## Antes de começar a desenvolver

Lembre-se que você pode consultar nosso conteúdo sobre [Git & GitHub](https://course.betrybe.com/intro/git/) sempre que precisar!

1. Clone o repositório
  * Por exemplo: `git clone git@github.com:tryber/desafio-aceleracao.git`
  * Entre no diretório do repositório que você acabou de clonar:
    * neste caso `cd desafio-aceleracao`

2. Instale as dependências:
    * `mvn install`

3. Crie uma branch a partir da branch `main`

  * Verifique que você está na branch `main`
    * Exemplo: `git branch`
  * Se não estiver, mude para a branch `main`
    * Exemplo: `git checkout main`
  * Agora, crie uma branch onde você vai guardar os commits do seu desafio
    * Você deve criar uma branch no seguinte formato: `nome-de-usuario-nome-do-desafio`
    * Exemplo:
      * `git checkout -b joaozinho-acc-java-sample`

4. Adicione a sua branch com o novo `commit` ao repositório remoto

  - Usando o exemplo anterior:
    - `git push -u origin joaozinho-acc-java-sample`

5. Crie um novo `Pull Request` _(PR)_
  * Vá até a aba de _Pull Requests_ deste repositório no GitHub
  * Clique no botão verde _"New pull request"_
  * Clique na caixa de seleção _"Compare"_ e escolha a sua branch **com atenção**
  * Clique no botão verde _"Create pull request"_
  * Adicione uma descrição para o _Pull Request_ e clique no botão verde _"Create pull request"_
  * **Não se preocupe em preencher mais nada por enquanto!**
  * Volte até a página de _Pull Requests_ do repositório e confira que o seu _Pull Request_ está criado
 
 ⚠️ **Lembre-se do CheckStyle! Deixe seu Eclipse configurado para arrumar o estilo automaticamente. Qualquer dúvida, volte no conteúdo.**

---

## Durante o desenvolvimento

* ⚠ **PULL REQUESTS COM ISSUES NO CHECKSTYLE NÃO SERÃO AVALIADAS, ATENTE-SE PARA RESOLVÊ-LAS ANTES DE FINALIZAR O DESENVOLVIMENTO!** ⚠

* Faça `commits` das alterações que você fizer no código regularmente

* Lembre-se de sempre após um (ou alguns) `commits` atualizar o repositório remoto

* Os comandos que você utilizará com mais frequência são:
  1. `git status` _(para verificar o que está em vermelho - fora do stage - e o que está em verde - no stage)_
  2. `git add` _(para adicionar arquivos ao stage do Git)_
  3. `git commit` _(para criar um commit com os arquivos que estão no stage do Git)_
  4. `git push -u origin nome-da-branch` _(para enviar o commit para o repositório remoto na primeira vez que fizer o `push` de uma nova branch)_
  5. `git push` _(para enviar o commit para o repositório remoto após o passo anterior)_

---

## Depois de terminar o desenvolvimento (opcional)

Para **"entregar"** seu projeto, siga os passos a seguir:

* Vá até a página **DO SEU** _Pull Request_, adicione a label de _"code-review"_ e marque seus colegas
  * No menu à direita, clique no _link_ **"Labels"** e escolha a _label_ **code-review**
  * No menu à direita, clique no _link_ **"Assignees"** e escolha **o seu usuário**
  * No menu à direita, clique no _link_ **"Reviewers"** e digite `students`, selecione o time `tryber/students-sd-0x`

Se ainda houver alguma dúvida sobre como entregar seu projeto, [aqui tem um video explicativo](https://vimeo.com/362189205).

---

# Requisitos do desafio

### Gerenciando as minhas séries 🎬

Imagina saber exatamente quais séries você já assistiu ou até mesmo aquelas que você mais gostou e poderia rever. Quem sabe  ter o  registro de  quantos capítulos tem uma nova série e até mesmo a quantidade de minutos que vai levar para terminá-la... Calma, você não está dormindo no meio de uma série! 😆

Falando assim parece um sonho, mas é possível! Basta colocar em prática as habilidades de criação de aplicação REST, uso do Spring Data para persistência de dados, tratamento de exceções e deploy em servidores de nuvem, adquiridas nas aulas anteriores.

Então bora lá e nada de dormir no pontou ou quem sabe na série  🚀


### Descrição


Lili Elbe não está conseguindo gerenciar bem as séries que tem assistido , por muitas vezes, não lembra qual foi o  último episódio visto ou quais séries novas tem interesse em  maratonar.  

Nas últimas férias, Lili se perguntou quanto tempo gastou acompanhando os últimos lançamentos que estavam sendo tão aguardados por ela, e para que pudesse gerenciar melhor seu tempo dentro e fora das telas, decidiu criar uma aplicação que a ajude ter maior controle sobre as suas séries amadas ! 

No dia a dia de uma pessoa programadora, você terá que resolver diversos problemas e consequentemente ajudar muitas pessoas, que tal então começarmos a ajudar a Lili com a criação dessa aplicação? 💚

Primeiro vamos analisar as necessidades descritas por ela: 

- Gostaria de poder gerir as minhas séries da seguinte forma!

- Cadastrar e visualizar as séries que já assisti;
- Adicionar episódios a séries que já assisti (indicando o número do episódio e o tempo em minutos que ele possui);
- Remover série com os seus episódios;
- Visualizar episódios assistidos de uma determinada séries;
- Visualizar tempo gasto total de todos os episódios já assistidos em todas as séries."

Agora que você já sabe todas as necessidades de Lili, crie uma  API que possa efetuar tais operações seguindo as seguintes especificações:


#### Listagem de endpoints:
- Cadastro de série
Rota `/series`
Metodo: POST
Corpo da requisição:
  ```json
  {
      "nome":"Doctor Who"
  }
  ```
  Corpo da resposta:
  ```json
  {
      "id": 1,
      "nome": "Doctor Who",
      "episodios": []
  }
  ```

- Visualizar séries
Rota `/series`
Metodo: GET
Corpo da resposta:
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

- Remover séries
Rota `/series/{serie_id}`
Metodo: DELETE

- Adicionar episódios
Rota `/series/{serie_id}/episodios`
- Metodo: POST
Corpo da requisição:
  ```json
  {
    "numero": 1,
    "duracaoEmMinutos": 60
  }
  ```
  Corpo da resposta:
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

- Visualizar episódios de uma série
Rota `/series/{serie_id}/episodios`
- Metodo: GET
Corpo da resposta:
  ```json
  [
    {
      "id": 2,
      "numero": 1,
      "duracaoEmMinutos": 60
    }
  ]
  ```

- Visualizar tempo gasto
Rota `/series/tempo`
- Metodo: GET
Corpo da resposta:
  ```json
  {
    "tempoEmMinutos": 600
  }
  ```

> Statuscode para casos de sucesso devem ser 200(OK)

#### Casos de Falha
- Cadastro de série com nome existente deve emitir a exceção `SerieExistenteException`
- Tentativas de acesso a uma série que não exista deve emitir a exceção `SerieNaoEncontradaException`
- Adição de episódios com o mesmo número para a mesma série deve emitir a exceção `EpisodioExistenteException`
- Casos de erro não mapeados neste documento devem emitir a exceção `ErroInesperadoException` 


#### Mapeamento de exception para statusCode

Utilize um `ControllerAdivice` para realizar o mapeamento das exceções conforme apresentado a seguir:  

Exception: SerieExistenteException
StatusCode: 409
Corpo da resposta:
```json
{
  "error": "Série Existente"
}
```

Excecption: EpisodioExistenteException
statusCode: 409
Corpo da resposta:
```json
{
  "error": "Episódio Existente"
}
```

Exception: SerieNaoEncontradaException
StatusCode: 404
Corpo da resposta:
```json
{
  "error": "Série não encontrada"
}
```

Exception: ErroInesperadoException
StatusCode: 500
Corpo da resposta:
```json
{
  "error": "Erro inesperado"
}
```

#### Tolerância a falhas:

Adicione um `CircuitBreaker` utilizando a biblioteca `resilience4j` no endpoint `/series/{serie_id}/episodios`, fazendo com que, caso haja 50% de erro nas requisições ,o serviço retorne:
StatusCode 503
Corpo da resposta:
```json
{
  "error": "Serviço temporariamente indisponível"
}
```

#### Testes

Realize testes de unidade para as classes de serviço e testes de integração para cada endpoint utilizando como ferramenta:
```java
  @Autowired
  private MockMvc mockMvc;
```



---

# Avisos Finais

Ao finalizar e submeter o desafio, não se esqueça de avaliar sua experiência preenchendo o formulário. Leva menos de 3 minutos!

Link: [Formulário](https://be-trybe.typeform.com/to/PsefzL2e)

O avaliador automático não necessariamente avalia seu projeto na ordem em que os requisitos aparecem no readme. Isso acontece para deixar o processo de avaliação mais rápido. Então, não se assuste se isso acontecer, ok?

---
