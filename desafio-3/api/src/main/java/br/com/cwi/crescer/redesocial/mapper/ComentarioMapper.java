package br.com.cwi.crescer.redesocial.mapper;

import static java.util.Objects.isNull;

import br.com.cwi.crescer.redesocial._domain.Comentario;
import br.com.cwi.crescer.redesocial.controller.request.ComentarioRequest;
import br.com.cwi.crescer.redesocial.controller.response.ComentarioResponse;
import java.time.LocalDateTime;

public class ComentarioMapper {

    public static Comentario toEntity(ComentarioRequest request) {
        Comentario entity = new Comentario();
        entity.setTexto(request.getTexto());
        entity.setDataCriacao(LocalDateTime.now());
        return entity;
    }

    public static ComentarioResponse toResponse(Comentario entity) {

        if (isNull(entity)) {
            return ComentarioResponse.builder().build();
        }

        ComentarioResponse response = new ComentarioResponse();
        response.setId(entity.getId());
        response.setTexto(entity.getTexto());
        response.setDataCriacao(entity.getDataCriacao());
        response.setUsuarioId(entity.getUsuario().getId());
        response.setUsuarioApelido(entity.getUsuario().getApelido());
        response.setUsuarioImagemPerfil(entity.getUsuario().getImagemPerfil());
        return response;
    }
}
