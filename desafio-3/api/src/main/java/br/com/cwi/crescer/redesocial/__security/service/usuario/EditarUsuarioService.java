package br.com.cwi.crescer.redesocial.__security.service.usuario;

import br.com.cwi.crescer.redesocial.__security._domain.Usuario;
import br.com.cwi.crescer.redesocial.__security._repository.UsuarioRepository;
import br.com.cwi.crescer.redesocial.__security.controller.request.EditarUsuarioRequest;
import br.com.cwi.crescer.redesocial.__security.service.usuario.BuscarUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditarUsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    BuscarUsuarioService buscarUsuarioService;

    public void editarUsuario(Long usuarioId, EditarUsuarioRequest request) {

        Usuario usuario = buscarUsuarioService.porId(usuarioId);

        usuario.setApelido(request.getApelido());
        usuario.setNomeCompleto(request.getNomeCompleto());
        usuario.setImagemPerfil(request.getImagemPerfil());

        usuarioRepository.save(usuario);
    }

}
