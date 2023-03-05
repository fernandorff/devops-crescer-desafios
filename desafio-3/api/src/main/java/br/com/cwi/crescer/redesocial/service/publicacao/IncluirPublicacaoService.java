package br.com.cwi.crescer.redesocial.service.publicacao;

import static br.com.cwi.crescer.redesocial.mapper.PublicacaoMapper.toEntity;
import static br.com.cwi.crescer.redesocial.mapper.PublicacaoMapper.toResponse;

import br.com.cwi.crescer.redesocial.__security._domain.Usuario;
import br.com.cwi.crescer.redesocial.__security._repository.UsuarioRepository;
import br.com.cwi.crescer.redesocial.__security.service.usuario.BuscarUsuarioService;
import br.com.cwi.crescer.redesocial._domain.Publicacao;
import br.com.cwi.crescer.redesocial._repository.PublicacaoRepository;
import br.com.cwi.crescer.redesocial.controller.request.PublicacaoRequest;
import br.com.cwi.crescer.redesocial.controller.response.PublicacaoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IncluirPublicacaoService {

    @Autowired
    private PublicacaoRepository publicacaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @Transactional
    public PublicacaoResponse publicar(Long usuarioId, PublicacaoRequest request) {

        Usuario usuario = buscarUsuarioService.porId(usuarioId);

        Publicacao publicacao = toEntity(request);

        usuario.adicionarPublicacao(publicacao);

        publicacao.adicionarUsuario(usuario);

        usuarioRepository.save(usuario);

        publicacaoRepository.save(publicacao);

        return toResponse(publicacao);
    }
}
