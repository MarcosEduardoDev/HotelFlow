package hotelflow.model;

public class Hospede {

    private String nome;
    private String documento;

    public Hospede(String nome, String documento) {
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
