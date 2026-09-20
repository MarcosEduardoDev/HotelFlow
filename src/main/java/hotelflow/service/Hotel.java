package hotelflow.service;

import hotelflow.model.Funcionario;
import hotelflow.model.Reserva;

import java.util.List;

public class Hotel {

    private String nome;
    private int quantidadeQuartos;
    private RH rh;
    private Recepcao recepcao;


    public Hotel(String nome, int quantidadeQuartos, RH rh, Recepcao recepcao) {
        this.nome = nome;
        this.quantidadeQuartos = quantidadeQuartos;
        this.rh = rh;
        this.recepcao = recepcao;
    }

    public void adicionarFuncionario(Funcionario funcionario){
        rh.adicionarFuncionario(funcionario);
    }
    public List<Funcionario> listarFuncionarios(){
        return rh.listarFuncionarios();
    }

    public void criarReserva(Reserva reserva){
        recepcao.criarReserva(reserva);
    }

    public List<Reserva> listarReservas(){
        return recepcao.listarReservas();
    }



}