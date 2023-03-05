package br.com.cwi.crescer.redesocial.__security.service.amigo;

import static br.com.cwi.crescer.redesocial.__security.mapper.AmigoMapper.toResponse;

import br.com.cwi.crescer.redesocial.__security._domain.Amigo;
import br.com.cwi.crescer.redesocial.__security._domain.Usuario;
import br.com.cwi.crescer.redesocial.__security._repository.AmigoRepository;
import br.com.cwi.crescer.redesocial.__security.controller.response.AmigosDoUsuarioResponse;
import br.com.cwi.crescer.redesocial.__security.service.usuario.BuscarUsuarioService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListarSolicitacoesRecebidasDoUsuarioService {

    @Autowired
    AmigoRepository amigoRepository;

    @Autowired
    BuscarUsuarioService buscarUsuarioService;

    public List<AmigosDoUsuarioResponse> listar(Long usuarioId) {
        Usuario usuario = buscarUsuarioService.porId(usuarioId);

        List<Amigo> amizadesConfirmadas = amigoRepository.findByConfirmadoFalseAndUsuarioEnviandoOrConfirmadoFalseAndUsuarioRecebendo(
            usuario, usuario);

        return amizadesConfirmadas.stream()
            .filter(amizade -> amizade.getUsuarioRecebendo().equals(usuario))
            .map(amizade -> {
                Usuario amigoUsuario = amizade.getUsuarioEnviando();
                return toResponse(amizade, amigoUsuario);
            })
            .collect(Collectors.toList());
    }
}
