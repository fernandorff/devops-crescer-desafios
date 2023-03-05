package br.com.cwi.crescer.redesocial.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import br.com.cwi.crescer.redesocial.__security._domain.Amigo;
import br.com.cwi.crescer.redesocial.__security._domain.Usuario;
import br.com.cwi.crescer.redesocial.__security.controller.response.AmigosDoUsuarioResponse;
import br.com.cwi.crescer.redesocial.__security.mapper.AmigoMapper;
import br.com.cwi.crescer.redesocial.factories.AmigoFactory;
import br.com.cwi.crescer.redesocial.factories.UsuarioFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AmigoMapperTest {

    @Test
    @DisplayName("Deve retornar o response completo quando receber um amigo completo")
    void deveRetornarResponseCompleto() {

        Amigo amigo = AmigoFactory.get();

        Usuario usuario = UsuarioFactory.get();

        AmigosDoUsuarioResponse response = AmigoMapper.toResponse(amigo, usuario);

        assertEquals(amigo.getId(), response.getAmizadeId());
        assertEquals(amigo.getConfirmado(), response.getAmizadeConfirmada());
        assertEquals(usuario.getId(), response.getUsuarioId());
        assertEquals(usuario.getApelido(), response.getUsuarioApelido());
        assertEquals(usuario.getImagemPerfil(), response.getUsuarioImagemPerfil());
    }

    @Test
    @DisplayName("Deve retornar response vazio quando amigo for nulo")
    void deveRetornarResponseVazio() {

        AmigosDoUsuarioResponse response = AmigoMapper.toResponse(null, null);

        assertNotNull(response);
    }
}
