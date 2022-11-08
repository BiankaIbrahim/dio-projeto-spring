package dio.projeto.spring.repository;

import dio.projeto.spring.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
    boolean existsBynomeContains(String nome);
}
