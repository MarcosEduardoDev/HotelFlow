package hotelflow.model;

import java.time.LocalDate;

public class Escala {

    private Turno turno;
    private LocalDate data;

    public Escala(Turno turno, LocalDate data) {
        this.turno = turno;
        this.data = data;
    }

    public Turno getTurno() {
        return turno;
    }

    public LocalDate getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Escala{" +
                "Turno = " + turno +
                ", Data = " + data +
                '}';
    }
}