package hotelflow.service;

import hotelflow.model.Funcionario;
import hotelflow.service.RH;

import java.util.List;

public class Hotel {

    private String nome;
    private int quantidadeQuartos;
    private RH rh;

    public Hotel(String nome, int quantidadeQuartos, RH rh) {
        this.nome = nome;
        this.quantidadeQuartos = quantidadeQuartos;
        this.rh = rh;
    }

    public void adicionarFuncionario(Funcionario funcionario){
        rh.adicionarFuncionario(funcionario);
    }
    public List<Funcionario> listarFuncionarios(){
        return rh.listarFuncionarios();
    }
}