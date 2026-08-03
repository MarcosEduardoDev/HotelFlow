package hotelflow.model;

import java.time.LocalDate;

public class Reserva {

    private Hospede hospede;
    private Quarto quarto;
    private LocalDate dataCheckIn;
    private LocalDate dataCheckOut;

    public Reserva(Hospede hospede, Quarto quarto, LocalDate dataCheckIn, LocalDate dataCheckOut) {
        this.hospede = hospede;
        this.quarto = quarto;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
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
                "Data check-out: " + dataCheckOut;
    }

    public boolean contemData(LocalDate data){
        boolean depoisDoCheckIn = !data.isBefore(dataCheckIn);
        boolean antesDoCheckOut = !data.isAfter(dataCheckOut);
        return antesDoCheckOut && depoisDoCheckIn;
    }
}
