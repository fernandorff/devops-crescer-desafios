package br.com.cwi.crescer.redesocial.service.publicacao;

import br.com.cwi.crescer.redesocial._repository.ComentarioRepository;
import br.com.cwi.crescer.redesocial._repository.PublicacaoRepository;
import br.com.cwi.crescer.redesocial.controller.response.ComentarioResponse;
import br.com.cwi.crescer.redesocial.mapper.ComentarioMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListarComentariosDaPublicacaoService {

    @Autowired
    private PublicacaoRepository publicacaoRepository;

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private BuscarPublicacaoService buscarPublicacaoService;

    public List<ComentarioResponse> listarComentariosDaPublicacao(Long publicacaoId) {

        return buscarPublicacaoService.porId(publicacaoId).getComentarios().stream()
            .map(ComentarioMapper::toResponse).collect(Collectors.toList());
    }
}
