package hotelflow.model;

public class Hospede {

    private String nome;
    private String documento;

    public Hospede(String nome, String documento) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }
        if (documento == null || documento.isBlank()) {
            throw new IllegalArgumentException("Documento não pode ser vazio.");
        }
        this.nome = nome;
        this.documento = documento;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    @Override
    public String toString() {
        return "Hospede: " + "\n" +
                "Nome: " + nome + "\n" +
                "Documento: " + documento;
    }
}
