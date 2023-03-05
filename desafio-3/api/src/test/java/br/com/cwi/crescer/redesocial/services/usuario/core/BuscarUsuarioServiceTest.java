package br.com.cwi.crescer.redesocial.services.usuario.core;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import br.com.cwi.crescer.redesocial.__security._domain.Usuario;
import br.com.cwi.crescer.redesocial.__security._repository.UsuarioRepository;
import br.com.cwi.crescer.redesocial.__security.service.usuario.BuscarUsuarioService;
import br.com.cwi.crescer.redesocial.factories.UsuarioFactory;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

@ExtendWith(MockitoExtension.class)
class BuscarUsuarioServiceTest {

    @InjectMocks
    private BuscarUsuarioService tested;

    @Mock
    private UsuarioRepository repository;

    @Test
    @DisplayName("Deve buscar usuário por id")
    void deveRetornarUsuario() {
        Usuario usuario = UsuarioFactory.get();
        when(repository.findById(usuario.getId())).thenReturn(Optional.of(usuario));

        Usuario retorno = tested.porId(usuario.getId());

        verify(repository).findById(usuario.getId());
        assertEquals(usuario, retorno);
    }

    @Test
    @DisplayName("Deve retornar erro quando não encontrar usuário")
    void deveRetornarErro() {

        ResponseStatusException exception =
                assertThrows(ResponseStatusException.class, () -> tested.porId(1L));

        assertEquals("Usuário não encontrado", exception.getReason());
    }
}
