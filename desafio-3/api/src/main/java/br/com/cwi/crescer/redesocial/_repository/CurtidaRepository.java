package br.com.cwi.crescer.redesocial._repository;

import br.com.cwi.crescer.redesocial.__security._domain.Usuario;
import br.com.cwi.crescer.redesocial._domain.Curtida;
import br.com.cwi.crescer.redesocial._domain.Publicacao;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurtidaRepository extends JpaRepository<Curtida, Long> {

    Boolean existsByPublicacaoAndUsuario(Publicacao publicacao, Usuario usuario);

    Optional<Curtida> findByPublicacaoAndUsuario(Publicacao publicacao, Usuario usuario);

    void deleteByPublicacaoAndUsuario(Publicacao publicacao, Usuario usuario);
}
