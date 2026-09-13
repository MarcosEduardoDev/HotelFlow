import hotelflow.model.*;
import hotelflow.service.Hotel;
import hotelflow.service.RH;
import hotelflow.service.Recepcao;

import java.time.LocalDate;

void main() {

    // ===== SETUP =====
    RH rh = new RH();
    Recepcao recepcao = new Recepcao();
    Hotel hotel = new Hotel("HotelFlow", 40, rh, recepcao);

    // ===== RH: FUNCIONÁRIOS =====
    System.out.println("===== FUNCIONÁRIOS =====");
    Funcionario fun1 = new Funcionario("Marcos", "31/07/2023", 23, Cargo.SERVEUR);
    Funcionario fun2 = new Funcionario("Fernando", "30/07/2026", 23, Cargo.CHEF_DE_RANG);
    Funcionario fun3 = new Funcionario("João", "31/07/2026", 24, Cargo.RECEPCIONISTA);
    Funcionario fun4 = new Funcionario("Roberto", "01/08/2026", 32, Cargo.SERVEUR);

    rh.adicionarFuncionario(fun1);
    rh.adicionarFuncionario(fun2);
    rh.adicionarFuncionario(fun3);
    rh.adicionarFuncionario(fun4);

    System.out.println(rh.listarFuncionarios());

    // ===== RH: ESCALAS E NOTIFICAÇÕES =====
    System.out.println("\n===== ESCALAS E NOTIFICAÇÕES =====");
    rh.definirEscala(1, Turno.MANHA, LocalDate.of(2026, 8, 10));
    rh.definirEscala(1, Turno.TARDE, LocalDate.of(2026, 8, 15));

    rh.buscarFuncionarioPorId(1).ifPresent(f -> System.out.println(f));
    rh.buscarFuncionarioPorId(1).ifPresent(f -> System.out.println(f.listarNotificacoesNaoLidas()));

    fun1.marcarNotificacaoComoLida(1);
    System.out.println("Após marcar notificação 1 como lida:");
    System.out.println(fun1.listarNotificacoesNaoLidas());

    // ===== RH: SALÁRIO E BÔNUS =====
    System.out.println("\n===== SALÁRIO E BÔNUS =====");
    System.out.println("Salário antes: " + fun1.getSalario());
    fun1.aumentarSalario();
    System.out.println("Salário depois do aumento: " + fun1.getSalario());
    System.out.println("Bônus calculado: " + fun1.calcularBonus());

    // ===== RECEPÇÃO: RESERVAS =====
    System.out.println("\n===== RESERVAS =====");
    Hospede h1 = new Hospede("Marcos", "1020304050");
    Quarto q1 = new Quarto(101, TipoQuarto.SUITE);
    Quarto q2 = new Quarto(202, TipoQuarto.SIMPLES);
    Quarto q3 = new Quarto(303, TipoQuarto.DUPLO);

    Reserva r1 = new Reserva(
            h1, q1,
            LocalDate.of(2026, 9, 1),
            LocalDate.of(2026, 9, 5),
            "Sem observação."
    );

    Reserva r2 = new Reserva(
            h1, q2,
            LocalDate.of(2026, 9, 2),
            LocalDate.of(2026, 9, 8),
            "Sem observação.");

    Reserva r3 = new Reserva(
            h1, q3,
            LocalDate.of(2026, 9, 3),
            LocalDate.of(2026, 9, 10),
            "Sem observação.");


    hotel.criarReserva(r1);
    System.out.println(hotel.listarReservas());
    System.out.println("Valor total da estadia: " + r1.calcularValor());

    hotel.criarReserva(r2);
    System.out.println(hotel.listarReservas());
    System.out.println("Valor total da estadia: " + r2.calcularValor());

    hotel.criarReserva(r3);
    System.out.println(hotel.listarReservas());
    System.out.println("Valor total da estadia: " + r3.calcularValor());

    boolean disponivel = recepcao.quartoDisponivel(q1, LocalDate.of(2026, 8, 20), LocalDate.of(2026, 8, 22));
    System.out.println("Quarto 101 disponível de 20 a 22/08? " + disponivel);

    // ===== RECEPÇÃO: CANCELAMENTO =====
    System.out.println("\n===== CANCELAMENTO =====");
    recepcao.cancelarReserva(q1, LocalDate.of(2026, 9, 5));
    System.out.println("Reservas após cancelamento: " + hotel.listarReservas());

    System.out.println("\n========= TESTE ==========");


    System.out.println("\n========= TESTE 02 ==========");
    Optional<Reserva> reserva = recepcao.reservaMaisCara(LocalDate.now());
        double valor = reserva.map(r -> r.calcularValor())
                .orElse(0.0);

}