package br.com.cwi.crescer.redesocial.services.usuario;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import br.com.cwi.crescer.redesocial.__security._domain.Usuario;
import br.com.cwi.crescer.redesocial.__security._repository.UsuarioRepository;
import br.com.cwi.crescer.redesocial.__security.controller.response.UsuarioResponse;
import br.com.cwi.crescer.redesocial.__security.service.usuario.BuscarUsuarioService;
import br.com.cwi.crescer.redesocial.__security.service.usuario.DetalharUsuarioService;
import br.com.cwi.crescer.redesocial.factories.UsuarioFactory;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@ExtendWith(MockitoExtension.class)
class DetalharUsuarioServiceTest {

    @InjectMocks
    private DetalharUsuarioService tested;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private BuscarUsuarioService buscarUsuarioService;

    @Test
    @DisplayName("Deve detalhar os dados do usuário corretamente.")
    void deveDetalharUsuarioCorretamente() {

        Usuario usuario = UsuarioFactory.get();
        Long usuarioId = usuario.getId();

//        when(tested.detalhar(usuarioId)).thenReturn(UsuarioResponse response);



    }


}