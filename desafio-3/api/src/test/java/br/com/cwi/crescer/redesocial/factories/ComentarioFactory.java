package br.com.cwi.crescer.redesocial.factories;

import br.com.cwi.crescer.redesocial._domain.Comentario;

public class ComentarioFactory {

    public static Comentario get() {
        Comentario comentario = new Comentario();
        comentario.setId(SimpleFactory.getRandomLong());
        comentario.setTexto("Comentario teste");
        comentario.setUsuario(UsuarioFactory.get());
        comentario.setPublicacao(PublicacaoFactory.get());
        return comentario;
    }
}
