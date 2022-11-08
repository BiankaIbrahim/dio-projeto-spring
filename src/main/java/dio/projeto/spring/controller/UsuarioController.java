package dio.projeto.spring.controller;

import dio.projeto.spring.model.Usuario;
import dio.projeto.spring.service.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private final UsuarioServiceImpl usuarioService;

    public UsuarioController(UsuarioServiceImpl usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity inserirUsuario(@RequestBody Usuario usuario){
        if(usuarioService.verificaNome(usuario.getNome()) == true){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario já existe.");
        }

        usuarioService.inserir(usuario);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping
    public ResponseEntity<Iterable<Usuario>> buscarTodos(){
        return ResponseEntity.ok(usuarioService.buscarTodos());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.buscarPorId(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Usuario>AtualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario){
        usuarioService.atualizar(id, usuario);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id){
        usuarioService.deletar(id);
        return ResponseEntity.ok().build();
    }

}


