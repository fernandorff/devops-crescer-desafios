package br.com.cwi.crescer.redesocial.services.usuario.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import br.com.cwi.crescer.redesocial.__security._repository.UsuarioRepository;
import br.com.cwi.crescer.redesocial.__security.service.auth.core.ValidaEmailUnicoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

@ExtendWith(MockitoExtension.class)
class ValidaEmailUnicoServiceTest {

    @InjectMocks
    private ValidaEmailUnicoService tested;

    @Mock
    private UsuarioRepository repository;

    @Test
    @DisplayName("Deve fazer nada quando email for único")
    void deveFazerNadaSeTituloUnico() {

        String email = "teste@cwi.com.br";
        when(repository.existsByEmail(email)).thenReturn(false);

        tested.validar(email);

        verify(repository).existsByEmail(email);
    }

    @Test
    @DisplayName("Deve retornar erro quando existir outro usuario com o mesmo email")
    void deveRetornarErroQuandoTituloDuplicado() {

        String email = "teste@cwi.com.br";
        when(repository.existsByEmail(email)).thenReturn(true);

        ResponseStatusException exception =
                assertThrows(ResponseStatusException.class, () -> tested.validar(email));

        assertEquals("Email do usuario deve ser único", exception.getReason());
    }
}
