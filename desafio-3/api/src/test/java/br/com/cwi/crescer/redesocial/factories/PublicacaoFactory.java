package br.com.cwi.crescer.redesocial.factories;

import br.com.cwi.crescer.redesocial._domain.Publicacao;
import br.com.cwi.crescer.redesocial._domain.enums.Visibilidade;
import java.time.LocalDateTime;

public class PublicacaoFactory {

    public static Publicacao get() {
        Publicacao publicacao = new Publicacao();
        publicacao.setId(SimpleFactory.getRandomLong());
        publicacao.setTitulo("Titulo da Publicacao Teste");
        publicacao.setTexto("Hello World");
        publicacao.setUsuario(UsuarioFactory.get());
        publicacao.setDataCriacao(LocalDateTime.now());
        publicacao.setVisibilidade(Visibilidade.PUBLICO);
        return publicacao;
    }
}
