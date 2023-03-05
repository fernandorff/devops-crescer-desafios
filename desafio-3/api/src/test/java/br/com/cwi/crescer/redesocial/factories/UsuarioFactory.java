package br.com.cwi.crescer.redesocial.factories;

import br.com.cwi.crescer.redesocial.__security._domain.Usuario;
import java.time.LocalDate;

public class UsuarioFactory {

    public static Usuario get() {
        Usuario usuario = new Usuario();
        usuario.setId(SimpleFactory.getRandomLong());
        usuario.setNomeCompleto("Usuário de teste");
        usuario.setEmail("teste@cwi.com.br");
        usuario.setApelido("testinho");
        usuario.setDataNascimento(LocalDate.of(1989, 2, 15));
        return usuario;
    }

    public static Usuario getOther() {
        Usuario usuario = new Usuario();
        usuario.setId(SimpleFactory.getRandomLong());
        usuario.setNomeCompleto("Usuário de teste 2");
        usuario.setEmail("teste2@cwi.com.br");
        usuario.setApelido("testonho");
        usuario.setDataNascimento(LocalDate.of(1992, 2, 15));
        return usuario;
    }
}
