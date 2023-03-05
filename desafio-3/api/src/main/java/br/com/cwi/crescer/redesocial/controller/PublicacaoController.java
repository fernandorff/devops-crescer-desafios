package br.com.cwi.crescer.redesocial.controller;

import br.com.cwi.crescer.redesocial.controller.request.ComentarioRequest;
import br.com.cwi.crescer.redesocial.controller.request.PublicacaoRequest;
import br.com.cwi.crescer.redesocial.controller.response.ComentarioResponse;
import br.com.cwi.crescer.redesocial.controller.response.PublicacaoResponse;
import br.com.cwi.crescer.redesocial.service.publicacao.ComentarPublicacaoService;
import br.com.cwi.crescer.redesocial.service.publicacao.CurtirPublicacaoService;
import br.com.cwi.crescer.redesocial.service.publicacao.DetalharPublicacaoService;
import br.com.cwi.crescer.redesocial.service.publicacao.IncluirPublicacaoService;
import br.com.cwi.crescer.redesocial.service.publicacao.ListarComentariosDaPublicacaoService;
import br.com.cwi.crescer.redesocial.service.publicacao.ListarPublicacoesPublicasService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publicacoes")
public class PublicacaoController {

    @Autowired
    private IncluirPublicacaoService incluirPublicacaoService;

    @Autowired
    private ComentarPublicacaoService comentarPublicacaoService;

    @Autowired
    private CurtirPublicacaoService curtirPublicacaoService;

    @Autowired
    private ListarPublicacoesPublicasService listarPublicacoesPublicasService;

    @Autowired
    private ListarComentariosDaPublicacaoService listarComentariosDaPublicacaoService;

    @Autowired
    private DetalharPublicacaoService detalharPublicacaoService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Page<PublicacaoResponse> listarPublicacoes(
        @PageableDefault(sort = "dataCriacao", direction = Sort.Direction.DESC) Pageable pageable) {
        return listarPublicacoesPublicasService.listarPublicacoesPublicas(pageable);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{publicacaoId}")
    public PublicacaoResponse detalharPublicacao(@PathVariable Long publicacaoId) {
        return detalharPublicacaoService.detalhar(publicacaoId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{publicacaoId}/comentarios")
    public List<ComentarioResponse> listarComentariosDaPublicacao(@PathVariable Long publicacaoId) {
        return listarComentariosDaPublicacaoService.listarComentariosDaPublicacao(publicacaoId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("{usuarioId}")
    public void incluirPublicacao(@PathVariable Long usuarioId,
        @Valid @RequestBody PublicacaoRequest request) {
        incluirPublicacaoService.publicar(usuarioId, request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("{publicacaoId}/comentar/{usuarioId}")
    public void incluirComentario(@PathVariable Long publicacaoId,
        @PathVariable Long usuarioId,
        @Valid @RequestBody ComentarioRequest request) {
        comentarPublicacaoService.comentar(publicacaoId, usuarioId, request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("{publicacaoId}/curtir/{usuarioId}")
    public void incluirCurtida(@PathVariable Long publicacaoId,
        @PathVariable Long usuarioId) {
        curtirPublicacaoService.curtir(publicacaoId, usuarioId);
    }
}
