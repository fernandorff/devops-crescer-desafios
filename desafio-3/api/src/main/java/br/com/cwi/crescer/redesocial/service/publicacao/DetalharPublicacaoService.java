package br.com.cwi.crescer.redesocial.service.publicacao;

import br.com.cwi.crescer.redesocial._repository.PublicacaoRepository;
import br.com.cwi.crescer.redesocial.controller.response.PublicacaoResponse;
import br.com.cwi.crescer.redesocial.mapper.PublicacaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalharPublicacaoService {

    @Autowired
    private PublicacaoRepository publicacaoRepository;

    @Autowired
    private BuscarPublicacaoService buscarPublicacaoService;

    public PublicacaoResponse detalhar(Long publicacaoId) {

        return PublicacaoMapper.toResponse(buscarPublicacaoService.porId(publicacaoId));
    }
}
