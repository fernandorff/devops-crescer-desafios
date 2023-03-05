package br.com.cwi.crescer.redesocial.__security.service.usuario;

import br.com.cwi.crescer.redesocial.__security._domain.Usuario;
import br.com.cwi.crescer.redesocial.__security._repository.AmigoRepository;
import br.com.cwi.crescer.redesocial.__security.service.amigo.VerificarAmigoService;
import br.com.cwi.crescer.redesocial._domain.enums.Visibilidade;
import br.com.cwi.crescer.redesocial._repository.PublicacaoRepository;
import br.com.cwi.crescer.redesocial.controller.response.PublicacaoResponse;
import br.com.cwi.crescer.redesocial.mapper.PublicacaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListarPublicacoesDoUsuarioService {

    @Autowired
    private PublicacaoRepository publicacaoRepository;

    @Autowired
    private AmigoRepository amigoRepository;

    @Autowired
    private VerificarAmigoService verificarAmigoService;

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    public Page<PublicacaoResponse> listarPublicacoesDoUsuario(Pageable pageable, Long usuarioId,
        Long usuarioAcessandoId) {

        Usuario usuario = buscarUsuarioService.porId(usuarioId);
        Usuario usuarioAcessando = buscarUsuarioService.porId(usuarioAcessandoId);

        if (verificarAmigoService.verificarAmigo(usuario, usuarioAcessando) ||
            usuario == usuarioAcessando) {
            return publicacaoRepository.findByUsuario(usuario, pageable)
                .map(PublicacaoMapper::toResponse);
        }

        return publicacaoRepository.findByUsuarioAndVisibilidade(usuario,
            Visibilidade.PUBLICO, pageable).map(PublicacaoMapper::toResponse);

    }
}
