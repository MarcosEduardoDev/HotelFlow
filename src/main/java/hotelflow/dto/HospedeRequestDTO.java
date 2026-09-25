package hotelflow.dto;

import jakarta.validation.constraints.NotBlank;

public class HospedeRequestDTO {

    @NotBlank(message = "Nome é obrigatório.")
    private String nome;
    @NotBlank(message = "Documento é obrigatório.")
    private String documento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}
