package br.com.cwi.crescer.redesocial._repository;

import br.com.cwi.crescer.redesocial.__security._domain.Usuario;
import br.com.cwi.crescer.redesocial._domain.Publicacao;
import br.com.cwi.crescer.redesocial._domain.enums.Visibilidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicacaoRepository extends JpaRepository<Publicacao, Long> {

    Page<Publicacao> findByVisibilidade(Visibilidade visibilidade, Pageable pageable);

    Page<Publicacao> findByUsuarioAndVisibilidade(Usuario usuario, Visibilidade visibilidade,
        Pageable pageable);

    Page<Publicacao> findByUsuario(Usuario usuario, Pageable pageable);

}
