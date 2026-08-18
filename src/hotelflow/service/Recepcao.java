package hotelflow.service;

import hotelflow.model.Quarto;
import hotelflow.model.Reserva;
import hotelflow.model.ReservaNaoEncontradaException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
}



