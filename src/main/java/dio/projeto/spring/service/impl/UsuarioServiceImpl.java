package dio.projeto.spring.service.impl;
import dio.projeto.spring.model.Departamento;
import dio.projeto.spring.model.Usuario;
import dio.projeto.spring.repository.UsuarioRepository;
import dio.projeto.spring.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private final UsuarioRepository usuarioRepository;
    private final DepartamentoServiceImpl departamentoService;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, DepartamentoServiceImpl departamentoService) {
        this.usuarioRepository = usuarioRepository;

        this.departamentoService = departamentoService;
    }

    @Override
    public Iterable<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario buscarPorId(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.get();
    }

    @Override
    public void inserir(Usuario usuario) {
        Usuario addUsuario = new Usuario();
        Departamento departamento = departamentoService.buscarPorId(usuario.getDepartamento().getId());
        addUsuario.setNome(usuario.getNome());
        addUsuario.setEmail(usuario.getEmail());
        addUsuario.setDepartamento(departamento);
        usuarioRepository.save(addUsuario);
    }

    @Override
    public void atualizar(Long id, Usuario usuario) {
        Optional<Usuario> usuarioBd = usuarioRepository.findById(id);
        System.out.println("usuario banco de dados " + usuarioBd);

        var usuarioAtual = usuarioBd.get();
        System.out.println("usuario Atual " + usuarioAtual);

        usuarioAtual.setNome(usuario.getNome());
        usuarioAtual.setEmail(usuario.getEmail());
        System.out.println("usuario Atual " + usuarioAtual);

        usuarioRepository.save(usuarioAtual);
    }


    @Override
    public void deletar(Long id) {

        usuarioRepository.deleteById(id);
    }

    public boolean verificaNome(String nome){
        return usuarioRepository.existsBynomeContains(nome);
    }

}
