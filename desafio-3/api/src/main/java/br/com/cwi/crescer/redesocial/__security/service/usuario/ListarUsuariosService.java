package br.com.cwi.crescer.redesocial.__security.service.usuario;

import br.com.cwi.crescer.redesocial.__security._repository.UsuarioRepository;
import br.com.cwi.crescer.redesocial.__security.controller.response.UsuarioResponse;
import br.com.cwi.crescer.redesocial.__security.mapper.UsuarioMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListarUsuariosService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioResponse> listar() {

        return usuarioRepository.findAll().stream()
            .map(UsuarioMapper::toResponse)
            .collect(Collectors.toList());
    }
}
