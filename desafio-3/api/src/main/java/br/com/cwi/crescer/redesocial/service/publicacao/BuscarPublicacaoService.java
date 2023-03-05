package br.com.cwi.crescer.redesocial.service.publicacao;

import br.com.cwi.crescer.redesocial._domain.Publicacao;
import br.com.cwi.crescer.redesocial._repository.PublicacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BuscarPublicacaoService {

    @Autowired
    private PublicacaoRepository publicacaoRepository;

    public Publicacao porId(Long publicacaoId) {

        return publicacaoRepository.findById(publicacaoId)
            .orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Publicação nao encontrada."));
    }
}
