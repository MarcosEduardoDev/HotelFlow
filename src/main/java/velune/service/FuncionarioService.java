package velune.service;

import velune.dto.FuncionarioRequestDTO;
import velune.model.Funcionario;
import velune.repository.FuncionarioRepository;

import java.util.List;

public class FuncionarioService {

    private final FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public Funcionario salvarFuncionario(FuncionarioRequestDTO funcionarioDTO){

        Funcionario funcionario = new Funcionario(funcionarioDTO.getNome(),
                funcionarioDTO.getDataDeEntrada(),
                funcionarioDTO.getIdade(),
                funcionarioDTO.getCargo());

        return repository.save(funcionario);
    }

    public List<Funcionario> listarFuncionarios() {

        return repository.findAll();
    }





}
