package dio.projeto.spring.service;

import dio.projeto.spring.model.Departamento;
import dio.projeto.spring.model.Usuario;

public interface UsuarioService {

    Iterable<Usuario> buscarTodos();

    Usuario buscarPorId(Long id);

    void inserir(Usuario usuario);

    void atualizar(Long id, Usuario usuario);

    void deletar(Long id);
}
