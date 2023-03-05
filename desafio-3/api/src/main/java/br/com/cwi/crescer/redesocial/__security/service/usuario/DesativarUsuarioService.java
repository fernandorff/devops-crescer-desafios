package br.com.cwi.crescer.redesocial.__security.service.usuario;

import br.com.cwi.crescer.redesocial.__security._domain.Usuario;
import br.com.cwi.crescer.redesocial.__security._repository.UsuarioRepository;
import br.com.cwi.crescer.redesocial.__security.service.usuario.BuscarUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DesativarUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @Transactional
    public void desativar(Long usuarioId) {

        Usuario usuario = buscarUsuarioService.porId(usuarioId);

        usuario.setAtivo(false);

        usuarioRepository.save(usuario);
    }
}
