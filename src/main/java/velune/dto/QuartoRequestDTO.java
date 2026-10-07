package velune.dto;

import velune.model.TipoQuarto;
import jakarta.validation.constraints.NotNull;

public class QuartoRequestDTO {

    @NotNull(message = "Número do quarto é obrigatório.")
    private Integer numero;
    @NotNull(message = "Tipo do quarto é obrigatório.")
    private TipoQuarto tipo;

    public TipoQuarto getTipo() {
        return tipo;
    }

    public void setTipo(TipoQuarto tipo) {
        this.tipo = tipo;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
}
