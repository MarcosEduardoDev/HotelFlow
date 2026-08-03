package hotelflow.model;

import hotelflow.model.Escala;
import hotelflow.model.Notificacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Funcionario {

    private String nome;
    private int idade;
    private String dataDeEntrada;
    private static int contador = 1;
    private int id;
    private Cargo cargo;
    private double salario;
    private List<Escala> escalas = new ArrayList<>();
    private List<Notificacao> notificacoes = new ArrayList<>();

    public int getIdade() {
        return idade;
    }

    public Funcionario(String nome, String dataDeEntrada, int idade, Cargo cargo) {
        this.nome = nome;
        this.dataDeEntrada = dataDeEntrada;
        this.idade = idade;
        this.cargo = cargo;
        this.salario = cargo.calcularSalarioBase();
        this.id = contador++;
    }

    public int getId(){
        return id;
    }

    public Cargo getCargo(){
        return cargo;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public void alterarIdade(int novaIdade){
        this.idade = novaIdade;
    }

    public void alterarCargo(Cargo novoCargo){
        this.cargo = novoCargo;
    }

    public void aumentarSalario() {
        double valorDoAumento = cargo.calcularAumento(this);
        this.salario += valorDoAumento;
    }

    public double calcularBonus(){
        return cargo.calcularBonus(this);
    }

    public void adicionarEscala(Escala escala){
        escalas.add(escala);
    }

    public List<Escala> listarEscalas(){
        return new ArrayList<>(escalas);
    }

    public void adicionarNotificacao(Notificacao notificacao){
        notificacoes.add(notificacao);
    }

    public List<Notificacao> listarNotificacoes() {
        return new ArrayList<>(notificacoes);
    }

    public List<Notificacao> listarNotificacoesNaoLidas(){
        return notificacoes.stream()
                .filter(n -> !n.isLida())
                .toList();
    }

    private String formatarEscalas() {
        return escalas.stream()
                .map(escala -> escala.getTurno() + " em " + escala.getData())
                .collect(Collectors.joining("\n"));
    }

    @Override
    public String toString() {
        return "Funcionário:\n" +
                "Nome: " + nome + "\n" +
                "Idade: " + idade + "\n" +
                "Data de entrada: " + dataDeEntrada + "\n" +
                "Cargo: " + cargo + "\n" +
                "Salário: " + salario + "\n" +
                "Escalas:\n" + formatarEscalas();
    }

    public void marcarNotificacaoComoLida(int idNotificacao){
        Optional<Notificacao> notificacao = notificacoes.stream()
                .filter(n -> n.getIdNotificacao() == idNotificacao)
                .findFirst();
        notificacao.ifPresent(n -> n.marcarComoLida());
    }
}