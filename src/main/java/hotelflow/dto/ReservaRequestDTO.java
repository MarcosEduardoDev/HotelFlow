package hotelflow.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class ReservaRequestDTO {

    @NotNull(message = "ID do quarto é obrigatório.")
    private Long quartoId;
    @NotNull(message = "ID do hóspede é obrigatório.")
    private Long hospedeId;
    @NotNull(message = "Data de check-in é obrigatória.")
    private LocalDate dataCheckIn;
    @NotNull(message = "Data de check-out é obrigatória.")
    private LocalDate dataCheckOut;
    private String observacao;

    public Long getQuartoId() {
        return quartoId;
    }

    public void setQuartoId(Long quartoId) {
        this.quartoId = quartoId;
    }

    public Long getHospedeId() {
        return hospedeId;
    }

    public void setHospedeId(Long hospedeId) {
        this.hospedeId = hospedeId;
    }

    public LocalDate getDataCheckIn() {
        return dataCheckIn;
    }

    public void setDataCheckIn(LocalDate dataCheckIn) {
        this.dataCheckIn = dataCheckIn;
    }

    public LocalDate getDataCheckOut() {
        return dataCheckOut;
    }

    public void setDataCheckOut(LocalDate dataCheckOut) {
        this.dataCheckOut = dataCheckOut;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @AssertTrue(message = "O check-out deve ser depois do check-in.")
    public boolean isPeriodoValido(){
        if (dataCheckIn == null  || dataCheckOut == null) {
            return true;
        }
        return dataCheckOut.isAfter(dataCheckIn);
    }


}
