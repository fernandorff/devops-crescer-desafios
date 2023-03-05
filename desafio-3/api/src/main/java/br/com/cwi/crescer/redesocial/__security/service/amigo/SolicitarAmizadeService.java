package br.com.cwi.crescer.redesocial.__security.service.amigo;

import br.com.cwi.crescer.redesocial.__security._domain.Amigo;
import br.com.cwi.crescer.redesocial.__security._domain.Usuario;
import br.com.cwi.crescer.redesocial.__security._repository.AmigoRepository;
import br.com.cwi.crescer.redesocial.__security.service.usuario.BuscarUsuarioService;
import br.com.cwi.crescer.redesocial.__security.validator.SolicitarAmizadeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolicitarAmizadeService {

    @Autowired
    private AmigoRepository amigoRepository;

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @Autowired
    private SolicitarAmizadeValidator solicitarAmizadeValidator;

    public void solicitarAmizade(Long usuarioEnviandoId, Long usuarioRecebendoId) {

        Usuario usuarioEnviando = buscarUsuarioService.porId(usuarioEnviandoId);
        Usuario usuarioRecebendo = buscarUsuarioService.porId(usuarioRecebendoId);

        solicitarAmizadeValidator.validar(usuarioEnviando, usuarioRecebendo);

        Amigo amigo = Amigo.builder()
            .usuarioEnviando(usuarioEnviando)
            .usuarioRecebendo(usuarioRecebendo)
            .confirmado(false)
            .build();

        amigoRepository.save(amigo);
    }
}
