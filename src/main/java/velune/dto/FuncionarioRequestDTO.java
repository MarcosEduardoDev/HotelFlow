package velune.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import velune.model.Cargo;

public class FuncionarioRequestDTO {

    @NotBlank(message = "Nome do funcionário é obrigatório.")
    private String nome;
    @NotBlank(message = "Data de entrada do funcionário é obrigatória.")
    private String dataDeEntrada;
    @NotNull(message = "Idade do funcionário é obrigatória.")
    private Integer idade;
    @NotNull(message = "Cargo do funcionário é obrigatório.")
    private Cargo cargo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getDataDeEntrada() {
        return dataDeEntrada;
    }

    public void setDataDeEntrada(String dataDeEntrada) {
        this.dataDeEntrada = dataDeEntrada;
    }
}
