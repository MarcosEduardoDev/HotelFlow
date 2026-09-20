package hotelflow.service;

import hotelflow.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Recepcao {

    private List<Reserva> reservas = new ArrayList<>();

    public void criarReserva(Reserva reserva){
        if (quartoDisponivel(reserva.getQuarto(), reserva.getDataCheckIn(), reserva.getDataCheckOut())){
            reservas.add(reserva);
        } else System.out.println("Quarto indisponível para esse período.");
    }

    public List<Reserva> listarReservas(){
        return new ArrayList<>(reservas);
    }

    public boolean quartoDisponivel(Quarto quarto, LocalDate dataCheckIn, LocalDate dataCheckOut){
        boolean temConflito = reservas.stream()
                .filter(r -> r.getQuarto() == quarto)
                .anyMatch(r -> dataCheckIn.isBefore(r.getDataCheckOut()) && dataCheckOut.isAfter(r.getDataCheckIn()));
        return !temConflito;
    }

    public void cancelarReserva(Quarto quarto, LocalDate data) {
        Reserva reserva = buscarReservaOuLancarExcecao(quarto, data);
        reservas.remove(reserva);
    }

    private Reserva buscarReservaOuLancarExcecao(Quarto quarto, LocalDate data){
        return reservas.stream()
                .filter(r -> r.getQuarto() == quarto && r.contemData(data))
                .findFirst()
                .orElseThrow(() -> new ReservaNaoEncontradaException("Reserva não encontrada."));
    }

    public List<Reserva> buscarReservasHospede(Hospede hospede){
        return reservas.stream()
                .filter(r -> r.getHospede().getNome().equals(hospede.getNome()))
                .collect(Collectors.toList());
    }

    public List<Reserva> pegarPeloNome(Hospede hospede){
        return reservas.stream()
                .filter(r -> r.getHospede().getNome().equals(hospede.getNome()))
                .collect(Collectors.toList());
    }

    public List<String> nomeDosHospedes(){
        return reservas.stream()
                .map(r -> r.getHospede().getNome())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Hospede> hospedesDeHoje(){
        return reservas.stream()
                .filter(r -> (r.getDataCheckIn().isBefore(LocalDate.now()) ||
                        r.getDataCheckIn().isEqual(LocalDate.now())) &&
                        r.getDataCheckOut().isAfter(LocalDate.now()))
                .map(r -> r.getHospede())
                .distinct()
                .collect(Collectors.toList());
    }

    public double calcularValorReservasAtivas(LocalDate data){
        return reservas.stream()
                .filter(r -> r.estaAtiva(data))
                .map(r -> r.calcularValor())
                .reduce(0.0, (total, valor) -> total + valor);
    }

    public Optional<Reserva> reservaMaisCara(LocalDate data){
        return reservas.stream()
                .filter(r -> r.estaAtiva(data))
                .max(Comparator.comparing(Reserva::calcularValor));
    }



}





