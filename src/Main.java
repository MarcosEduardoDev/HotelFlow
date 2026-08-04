import hotelflow.model.*;
import hotelflow.service.Hotel;
import hotelflow.service.RH;
import hotelflow.service.Recepcao;

import java.time.LocalDate;

void main() {

    Funcionario fun1 = new Funcionario("Marcos", "31/07/2023", 23, Cargo.SERVEUR);
    Funcionario fun2 = new Funcionario("Fernando", "30/07/2026", 23, Cargo.CHEF_DE_RANG);
    Funcionario fun3 = new Funcionario("João", "31/07/2026", 24, Cargo.RECEPCIONISTA);
    Funcionario fun4 = new Funcionario("Roberto", "01/08/2026", 32, Cargo.SERVEUR);

    RH rh = new RH();
    rh.adicionarFuncionario(fun1);
    rh.adicionarFuncionario(fun2);
    rh.adicionarFuncionario(fun3);
    rh.adicionarFuncionario(fun4);

    Recepcao recepcao = new Recepcao();
    Hotel hotel = new Hotel("HotelFlow", 40, rh, recepcao);

    rh.definirEscala(1, Turno.MANHA, LocalDate.of(2026, 8, 10));
    rh.definirEscala(1, Turno.TARDE, LocalDate.of(2026, 8, 15));
    System.out.println("*********************************");

    Hospede h1 = new Hospede("Marcos", "1020304050");
    Quarto q1 = new Quarto(101, TipoQuarto.SUITE);

    Reserva r1 = new Reserva(h1, q1, LocalDate.of(2026, 8, 10), LocalDate.of(2026, 8, 15));
    recepcao.criarReserva(r1);
    Reserva r2 = new Reserva(h1, q1, LocalDate.of(2026, 8, 12), LocalDate.of(2026, 8, 18));
    recepcao.criarReserva(r2);
    Reserva r3 = new Reserva(h1, q1, LocalDate.of(2026, 8, 15), LocalDate.of(2026, 8, 20));
    recepcao.criarReserva(r3);
    System.out.println(recepcao.listarReservas());



}


