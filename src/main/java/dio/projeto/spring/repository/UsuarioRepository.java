package dio.projeto.spring.repository;

import dio.projeto.spring.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {
    boolean existsBynomeContains(String nome);
}
