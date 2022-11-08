package dio.projeto.spring.service;

import dio.projeto.spring.model.Departamento;
import dio.projeto.spring.model.Usuario;

public interface DepartamentoService {
    Iterable<Departamento> buscarTodos();

    Departamento buscarPorId(Long id);

    void inserir(Departamento departamento);

    void atualizar(Long id, Departamento departamento);

    void deletar(Long id);
}
