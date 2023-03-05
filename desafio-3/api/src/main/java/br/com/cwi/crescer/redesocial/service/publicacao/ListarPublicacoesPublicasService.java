package br.com.cwi.crescer.redesocial.service.publicacao;

import br.com.cwi.crescer.redesocial._domain.enums.Visibilidade;
import br.com.cwi.crescer.redesocial._repository.PublicacaoRepository;
import br.com.cwi.crescer.redesocial.controller.response.PublicacaoResponse;
import br.com.cwi.crescer.redesocial.mapper.PublicacaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListarPublicacoesPublicasService {

    @Autowired
    private PublicacaoRepository publicacaoRepository;

    public Page<PublicacaoResponse> listarPublicacoesPublicas(Pageable pageable) {
        return publicacaoRepository.findByVisibilidade(Visibilidade.PUBLICO, pageable)
            .map(PublicacaoMapper::toResponse);
    }
}
