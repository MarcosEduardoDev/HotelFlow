package hotelflow.service;

import hotelflow.model.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class RH {

    private List<Funcionario> gestao = new ArrayList<>();

    public void adicionarFuncionario(Funcionario funcionario){
        gestao.add(funcionario);
    }

    public List<Funcionario> listarFuncionarios(){
        return new ArrayList<>(gestao);
    }

    public void removerFuncionario(int id){
        Funcionario funcionario = buscarOuLancarExcecao(id);
        gestao.remove(funcionario);
    }

    public Optional<Funcionario> buscarFuncionarioPorId(int id){
        for (Funcionario funcionario : gestao){
            if (funcionario.getId() == id){
                return Optional.of(funcionario);
            }
        } return Optional.empty();
    }

    public void alterarIdade(int id, int novaIdade){
        Funcionario funcionario = buscarOuLancarExcecao(id);
        funcionario.alterarIdade(novaIdade);
    }

    public void alterarCargo(int id, Cargo novoCargo){
        Funcionario funcionario = buscarOuLancarExcecao(id);
        funcionario.alterarCargo(novoCargo);
    }

    public int quantidadeFuncionarios(){
        return gestao.size();
    }

    public int quantidadePorCargo(Cargo cargo){
        return (int) gestao.stream()
                .filter(funcionario -> funcionario.getCargo() == cargo)
                .count();
    }

    public List<Funcionario> buscarFuncionarioPorCargo(Cargo cargo){
        return gestao.stream()
                .filter(funcionario -> funcionario.getCargo() == cargo)
                .toList();
    }

    public List<String> listarNomes(){
        return gestao.stream()
                .map(funcionario -> funcionario.getNome())
                .toList();
    }

    public List<String> listarNomesPorCargo(Cargo cargo){
        return gestao.stream()
                .filter(f -> f.getCargo() == cargo)
                .map(f -> f.getNome())
                .toList();
    }

    public List<Funcionario> listarPorIdade(){
        return gestao.stream()
                .sorted(Comparator.comparing(Funcionario::getIdade))
                .toList();
    }

    public void definirEscala(int id, Turno turno, LocalDate data){
        Funcionario funcionario = buscarOuLancarExcecao(id);
        funcionario.adicionarEscala(new Escala(turno, data));
        String mensagem = "Você foi escalado para " + turno + " no dia " + data;
        funcionario.adicionarNotificacao(new Notificacao(mensagem, LocalDateTime.now()));
        }

    private Funcionario buscarOuLancarExcecao(int id){
        return buscarFuncionarioPorId(id)
                .orElseThrow(() -> new FuncionarioNaoEncontradoException("Funcionário com o id " + id + " não foi encontrado."));
    }
}