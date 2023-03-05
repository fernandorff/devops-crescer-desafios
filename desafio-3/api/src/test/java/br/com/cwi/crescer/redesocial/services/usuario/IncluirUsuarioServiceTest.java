package br.com.cwi.crescer.redesocial.services.usuario;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import br.com.cwi.crescer.redesocial.__security._domain.Usuario;
import br.com.cwi.crescer.redesocial.__security._repository.UsuarioRepository;
import br.com.cwi.crescer.redesocial.__security.controller.request.UsuarioRequest;
import br.com.cwi.crescer.redesocial.__security.service.auth.IncluirUsuarioService;
import br.com.cwi.crescer.redesocial.__security.service.auth.core.ValidaEmailUnicoService;
import br.com.cwi.crescer.redesocial.service._core.NowService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.server.ResponseStatusException;

@ExtendWith(MockitoExtension.class)
class IncluirUsuarioServiceTest {

    @InjectMocks
    private IncluirUsuarioService tested;

    @Mock
    private NowService nowService;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private UsuarioRepository repository;

    @Mock
    private ValidaEmailUnicoService validaEmailUnicoService;

    @Captor
    private ArgumentCaptor<Usuario> usuarioCaptor;

    @Test
    @DisplayName("Deve incluir novo usuario como ativo e com data e hora de inclusão")
    void deveIncluirUsuario() {

        UsuarioRequest request = new UsuarioRequest();
        request.setEmail("teste@cwi.com.br");
        request.setSenha(passwordEncoder.encode("123123"));

        LocalDateTime hoje = LocalDateTime.now();

        when(nowService.getDateTime()).thenReturn(hoje);

        tested.incluir(request);

        verify(validaEmailUnicoService).validar(request.getEmail());
        verify(repository).save(usuarioCaptor.capture());

        Usuario usuario = usuarioCaptor.getValue();
        assertEquals(true, usuario.getAtivo());
        assertEquals(hoje, usuario.getDataCriacao());
    }

    @Test
    @DisplayName("Não deve incluir usuario se existir outro usuario com o mesmo email")
    void deveRetornarErroParaTituloDuplicado() {

        UsuarioRequest request = new UsuarioRequest();
        request.setEmail("teste@cwi.com.br");
        request.setSenha(passwordEncoder.encode("123123"));

    doThrow(ResponseStatusException.class)
                .when(validaEmailUnicoService).validar(request.getEmail());

        assertThrows(ResponseStatusException.class, () -> {
            tested.incluir(request);
        });

        verify(repository, never()).save(usuarioCaptor.capture());
    }
}