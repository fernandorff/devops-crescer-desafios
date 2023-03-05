package br.com.cwi.crescer.redesocial.services.usuario;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import br.com.cwi.crescer.redesocial.__security._domain.Usuario;
import br.com.cwi.crescer.redesocial.__security._repository.UsuarioRepository;
import br.com.cwi.crescer.redesocial.__security.controller.request.EditarUsuarioRequest;
import br.com.cwi.crescer.redesocial.__security.service.usuario.BuscarUsuarioService;
import br.com.cwi.crescer.redesocial.__security.service.usuario.EditarUsuarioService;
import br.com.cwi.crescer.redesocial.factories.UsuarioFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EditarUsuarioServiceTest {

    @InjectMocks
    private EditarUsuarioService tested;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private BuscarUsuarioService buscarUsuarioService;

    @Test
    @DisplayName("Deve atualizar usuario corretamente")
    void deveEditarUsuarioCorretamente() {

        EditarUsuarioRequest request = new EditarUsuarioRequest();
        request.setNomeCompleto("Teste Testador");
        Usuario usuario = UsuarioFactory.get();
        Long usuarioId = usuario.getId();
        when(buscarUsuarioService.porId(usuarioId)).thenReturn(usuario);

        tested.editarUsuario(usuarioId, request);

        verify(usuarioRepository).save(usuario);
        assertEquals(request.getNomeCompleto(), usuario.getNomeCompleto());
    }
}