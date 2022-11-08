package dio.projeto.spring.service.impl;

import dio.projeto.spring.model.Departamento;
import dio.projeto.spring.repository.DepartamentoRepository;
import dio.projeto.spring.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

    @Autowired
    private final DepartamentoRepository departamentoRepository;

    public DepartamentoServiceImpl(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    @Override
    public Iterable<Departamento> buscarTodos() {
       return departamentoRepository.findAll();
    }

    @Override
    public Departamento buscarPorId(Long id) {
        Optional<Departamento> departamento = departamentoRepository.findById(id);
        return departamento.orElseThrow(() -> new RuntimeException("departamento não encontrado"));
    }

    @Override
    public void inserir(Departamento departamento) {
        Departamento addDepartamento = new Departamento();
        addDepartamento.setNome(departamento.getNome());
        departamentoRepository.save(addDepartamento);
    }

    @Override
    public void atualizar(Long id, Departamento departamento) {

        Optional<Departamento> usuarioBd = departamentoRepository.findById(id);
        System.out.println("usuario banco de dados " + usuarioBd);

        var departamentoAtual = usuarioBd.get();
        System.out.println("usuario Atual " + departamentoAtual);

        departamentoAtual.setNome(usuarioBd.get().getNome());
        System.out.println("usuario Atual " + departamentoAtual);

        departamentoRepository.save(departamentoAtual);
    }

    @Override
    public void deletar(Long id) {
        departamentoRepository.deleteById(id);
    }

    public boolean verificaNome(String nome){
        return departamentoRepository.existsBynomeContains(nome);
    }
}
