package hotelflow.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reserva {

    private Hospede hospede;
    private Quarto quarto;
    private LocalDate dataCheckIn;
    private LocalDate dataCheckOut;
    private String observacao;

    public Reserva(Hospede hospede, Quarto quarto, LocalDate dataCheckIn, LocalDate dataCheckOut, String observacao) {
        this.hospede = hospede;
        this.quarto = quarto;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.observacao = observacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public LocalDate getDataCheckOut() {
        return dataCheckOut;
    }

    public LocalDate getDataCheckIn() {
        return dataCheckIn;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    @Override
    public String toString() {
        return "Reserva: " + "\n" +
                "Hóspede: " + hospede + "\n" +
                "Quarto: " + quarto + "\n" +
                "Data check-in: " + dataCheckIn + "\n" +
                "Data check-out: " + dataCheckOut + "\n" +
                "Observação: " + observacao;
    }

    public boolean contemData(LocalDate data){
        boolean depoisDoCheckIn = !data.isBefore(dataCheckIn);
        boolean antesDoCheckOut = !data.isAfter(dataCheckOut);
        return antesDoCheckOut && depoisDoCheckIn;
    }

    public double calcularValor() {
        long dias = ChronoUnit.DAYS.between(dataCheckIn, dataCheckOut);
        return dias * quarto.getTipo().getPrecoDiaria();
    }




}
