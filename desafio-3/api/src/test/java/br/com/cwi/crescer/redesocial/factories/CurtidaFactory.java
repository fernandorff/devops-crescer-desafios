package br.com.cwi.crescer.redesocial.factories;

import br.com.cwi.crescer.redesocial._domain.Curtida;

public class CurtidaFactory {

    public static Curtida get() {
        Curtida curtida = new Curtida();
        curtida.setId(SimpleFactory.getRandomLong());
        curtida.setUsuario(UsuarioFactory.get());
        curtida.setPublicacao(PublicacaoFactory.get());
        return curtida;
    }
}
