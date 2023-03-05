package br.com.cwi.crescer.redesocial._repository;

import br.com.cwi.crescer.redesocial._domain.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

}
