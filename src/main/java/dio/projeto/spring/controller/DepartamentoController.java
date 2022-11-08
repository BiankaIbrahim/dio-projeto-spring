package dio.projeto.spring.controller;

import dio.projeto.spring.model.Departamento;
import dio.projeto.spring.service.impl.DepartamentoServiceImpl;
import dio.projeto.spring.service.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/departamento")
public class DepartamentoController {

    @Autowired
    private final DepartamentoServiceImpl departamentoService;


    public DepartamentoController(DepartamentoServiceImpl departamento) {
        this.departamentoService = departamento;
    }

    @PostMapping
    public ResponseEntity inserirDepartamento(@RequestBody Departamento departamento){
        if(departamentoService.verificaNome(departamento.getNome())== true){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Departamento já existe.");
        }
        departamentoService.inserir(departamento);
        return ResponseEntity.ok(departamento);
    }

    @GetMapping
    public ResponseEntity<Iterable<Departamento>> buscarTodos() {
        return ResponseEntity.ok(departamentoService.buscarTodos());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Departamento> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(departamentoService.buscarPorId(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Departamento>AtualizarDepartamento(@PathVariable Long id, @RequestBody Departamento departamento){
        departamentoService.atualizar(id, departamento);
        return ResponseEntity.ok(departamento);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarDepartamento(@PathVariable Long id){
        departamentoService.deletar(id);
        return ResponseEntity.ok().build();
    }

}
