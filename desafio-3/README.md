# DREAM CATCHER

API para gestão de rede social de diário de sonhos.

## Métodos

### Autenticação

- Login:
    - `POST /login, auth: { username, password }`
- Logout:
  - `POST /logout`
- Incluir usuário:
    - `POST /usuarios, { nome: string, email: string, senha: string, permissoes[]: string }`
- Listar livros:
  - `GET /livros`


### Usuário

- Cadastrar usuario
  - `POST /usuarios, {
    "nomeCompleto": String,
    "email": String,
    "apelido": String,
    "senha": String,
    "dataNascimento": LocalDateTime
    } `
- Editar usuario:
  - `PUT /usuarios/{usuarioId}, {
    "nomeCompleto": String,
    "apelido": String,
    "imagemPerfil": String
    }`
- Listar usuarios:
  - `GET /usuarios`
- Detalhar usuario:
  - `GET /usuarios/{usuarioId}`
- Procurar usuarios por nome ou email:
  - `GET /usuarios/procurar?query={query}`
- Listar publicacoes do usuario:
  - `GET /usuarios/{usuarioEscolhidoId}/publicacoes/{usuarioAcessandoId}`

<hr>

### Amigos
- Enviar Soliticação de Amizade
  - `POST /amigos/{usuarioSolicitandoId}/solicitar/{usuarioRecebendoId}`
- Aceitar Solicitação de Amizade
  - `PUT /amigos/{amizadeId}/aceitar`
- Desfazer Amizade
  - `PUT /amigos{amizadeId}/desfazer`
- Listar Amigos do Usuário
  - `GET /amigos/{usuarioId}`
- Listar Solicitações Recebidas do Usuário
  - `GET /amigos/{usuarioId}/recebidas`
- Listar Solicitações Enviadas do Usuário
  - `GET /amigos/{usuarioId}/enviadas`
- Procurar Amigos do Usuário por Nome ou Email
  - `GET /amigos/{usuarioId}/procurar?query={query}`

<hr>

### Publicações
- Incluir Publicação
  - `POST /publicacoes/{usuarioId}, {
    "titulo": String,
    "texto": String,
    "imagem": String,
    "visibilidade": Enum ("PUBLICO","PRIVADO")
    }`
- Detalhar Publicação
  - `GET /publicacoes/{publicacaoId}`
- Listar Publicações Públicas (Paginado, Order By DataCriacao DESC)
  - `GET /publicacoes`
- Curtir Publicação
  - `POST /publicacoes/{publicacaoId}/curtir/{usuarioId}`
- Comentar Publicação
  - `POST /publicacoes/{publicacaoId}/comentar/{usuarioId}`
- Listar Comentários da Publicação
  - `GET /publicacoes/{publicacaoId}/comentarios`

<hr>

## Dependencies

- Java 11
- PostgreSQL 14
- Aplicação React: `./app`
- Esquema e inserts do Banco de dados: `./api/data/schema.sql`
- Import de métodos do Insomnia: `./api/data/insomnia-tcc-java-fernando-filho.json`
