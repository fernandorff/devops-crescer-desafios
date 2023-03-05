package br.com.cwi.crescer.redesocial.factories;


import br.com.cwi.crescer.redesocial.__security._domain.Amigo;

public class AmigoFactory {

    public static Amigo get() {
        Amigo amigo = new Amigo();
        amigo.setId(SimpleFactory.getRandomLong());
        amigo.setUsuarioEnviando(UsuarioFactory.get());
        amigo.setUsuarioRecebendo(UsuarioFactory.getOther());
        amigo.setConfirmado(true);
        return amigo;
    }
}
