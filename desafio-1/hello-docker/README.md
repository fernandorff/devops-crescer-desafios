# Hello Docker

Projeto para criação de imagem docker da aplicação Hello Docker.

##  Instruções

- Buildar imagem.
```
docker build -t "nome"/"nomeDaAplicacao":"tag" .
```
- Rodar imagem na porta 9320

```
docker run -p 9320:8080 "nome"/"nomeDaAplicacao":"tag"
```

## Métodos

``` 
GET '/' -> return "Index!"
```

``` 
GET '/hello' -> return "Hello"
```

