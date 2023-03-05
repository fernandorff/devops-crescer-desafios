package br.com.cwi.crescer.redesocial.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import br.com.cwi.crescer.redesocial._domain.Comentario;
import br.com.cwi.crescer.redesocial.controller.response.ComentarioResponse;
import br.com.cwi.crescer.redesocial.factories.ComentarioFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ComentarioMapperTest {

    @Test
    @DisplayName("Deve retornar o response completo quando receber um amigo completo")
    void deveRetornarResponseCompleto() {

        Comentario amigo = ComentarioFactory.get();

        ComentarioResponse response = ComentarioMapper.toResponse(amigo);

        assertEquals(amigo.getId(), response.getId());
        assertEquals(amigo.getTexto(), response.getTexto());
        assertEquals(amigo.getDataCriacao(), response.getDataCriacao());
        assertEquals(amigo.getUsuario().getId(), response.getUsuarioId());
        assertEquals(amigo.getUsuario().getApelido(), response.getUsuarioApelido());
        assertEquals(amigo.getUsuario().getImagemPerfil(), response.getUsuarioImagemPerfil());
    }

    @Test
    @DisplayName("Deve retornar response vazio quando amigo for nulo")
    void deveRetornarResponseVazio() {

        ComentarioResponse response = ComentarioMapper.toResponse(null);

        assertNotNull(response);
    }
}
