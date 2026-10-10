package velune.dto;

import jakarta.validation.constraints.NotNull;
import velune.model.Turno;

import java.time.LocalDate;

public class EscalaRequestDTO {

    @NotNull(message = "Turno do funcionário é obrigatório.")
    private Turno turno;
    @NotNull(message = "Data é obrigatória.")
    private LocalDate data;

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }
}
