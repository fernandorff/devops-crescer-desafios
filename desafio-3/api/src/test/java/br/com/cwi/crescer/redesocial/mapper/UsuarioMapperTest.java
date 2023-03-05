package br.com.cwi.crescer.redesocial.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import br.com.cwi.crescer.redesocial.__security._domain.Usuario;
import br.com.cwi.crescer.redesocial.__security.controller.response.UsuarioResponse;
import br.com.cwi.crescer.redesocial.__security.mapper.UsuarioMapper;
import br.com.cwi.crescer.redesocial.factories.UsuarioFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UsuarioMapperTest {

    @Test
    @DisplayName("Deve retornar o response completo quando receber um usuario completo")
    void deveRetornarResponseCompleto() {

        Usuario usuario = UsuarioFactory.get();

        UsuarioResponse response = UsuarioMapper.toResponse(usuario);

        assertEquals(usuario.getId(), response.getId());
        assertEquals(usuario.getNomeCompleto(), response.getNomeCompleto());
        assertEquals(usuario.getApelido(), response.getApelido());
        assertEquals(usuario.getEmail(), response.getEmail());
        assertEquals(usuario.getDataNascimento(), response.getDataNascimento());
        assertEquals(usuario.getImagemPerfil(), response.getImagemPerfil());
        assertEquals(usuario.getAtivo(), response.getAtivo());
    }

    @Test
    @DisplayName("Deve retornar response vazio quando usuario for nulo")
    void deveRetornarResponseVazio() {

        UsuarioResponse response = UsuarioMapper.toResponse(null);

        assertNotNull(response);
    }
}
