package br.com.cwi.crescer.redesocial.service.publicacao;

import static br.com.cwi.crescer.redesocial.mapper.ComentarioMapper.toEntity;
import static br.com.cwi.crescer.redesocial.mapper.ComentarioMapper.toResponse;

import br.com.cwi.crescer.redesocial.__security._domain.Usuario;
import br.com.cwi.crescer.redesocial.__security._repository.UsuarioRepository;
import br.com.cwi.crescer.redesocial.__security.service.usuario.BuscarUsuarioService;
import br.com.cwi.crescer.redesocial._domain.Comentario;
import br.com.cwi.crescer.redesocial._domain.Publicacao;
import br.com.cwi.crescer.redesocial._repository.ComentarioRepository;
import br.com.cwi.crescer.redesocial._repository.PublicacaoRepository;
import br.com.cwi.crescer.redesocial.controller.request.ComentarioRequest;
import br.com.cwi.crescer.redesocial.controller.response.ComentarioResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ComentarPublicacaoService {

    @Autowired
    private PublicacaoRepository publicacaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @Autowired
    private BuscarPublicacaoService buscarPublicacaoService;

    @Transactional
    public ComentarioResponse comentar(Long publicacaoId, Long usuarioId,
        ComentarioRequest request) {

        Usuario usuario = buscarUsuarioService.porId(usuarioId);
        Publicacao publicacao = buscarPublicacaoService.porId(publicacaoId);
        Comentario comentario = toEntity(request);

        usuario.adicionarComentario(comentario);
        publicacao.adicionarComentario(comentario);
        comentario.adicionarUsuario(usuario);
        comentario.adicionarPublicacao(publicacao);

        usuarioRepository.save(usuario);
        publicacaoRepository.save(publicacao);
        comentarioRepository.save(comentario);

        return toResponse(comentario);
    }
}
