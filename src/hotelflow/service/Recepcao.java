package hotelflow.service;

import hotelflow.model.Quarto;
import hotelflow.model.Reserva;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Recepcao {

    private List<Reserva> reservas = new ArrayList<>();

    public void criarReserva(Reserva reserva){
        reservas.add(reserva);
    }

    public List<Reserva> listarReservas(){
        return new ArrayList<>(reservas);
    }

    public boolean quartoDisponivel(Quarto quarto, LocalDate data){
        boolean temReservaNaData = reservas.stream()
                .filter(r -> r.getQuarto() == quarto)
                .anyMatch(r -> r.contemData(data));
        return !temReservaNaData;
    }


}
