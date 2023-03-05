package br.com.cwi.crescer.redesocial.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import br.com.cwi.crescer.redesocial._domain.Publicacao;
import br.com.cwi.crescer.redesocial.controller.response.PublicacaoResponse;
import br.com.cwi.crescer.redesocial.factories.PublicacaoFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PublicacaoMapperTest {

    @Test
    @DisplayName("Deve retornar o response completo quando receber uma publicacao completa")
    void deveRetornarResponseCompleto() {

        Publicacao publicacao = PublicacaoFactory.get();

        PublicacaoResponse response = PublicacaoMapper.toResponse(publicacao);

        assertEquals(publicacao.getId(), response.getId());
        assertEquals(publicacao.getTitulo(), response.getTitulo());
        assertEquals(publicacao.getTexto(), response.getTexto());
        assertEquals(publicacao.getImagem(), response.getImagem());
        assertEquals(publicacao.getVisibilidade(), response.getVisibilidade());
        assertEquals(publicacao.getDataCriacao(), response.getDataCriacao());
        assertEquals(publicacao.getUsuario().getId(), response.getUsuarioId());
        assertEquals(publicacao.getUsuario().getApelido(), response.getUsuarioApelido());
        assertEquals(publicacao.getUsuario().getImagemPerfil(), response.getUsuarioImagemPerfil());
        assertEquals(publicacao.getCurtidas().size(), response.getQuantidadeLikes());
        assertEquals(publicacao.getComentarios().size(), response.getQuantidadeComentarios());
    }

    @Test
    @DisplayName("Deve retornar response vazio quando publicacao for nulo")
    void deveRetornarResponseVazio() {

        PublicacaoResponse response = PublicacaoMapper.toResponse(null);

        assertNotNull(response);
    }
}
