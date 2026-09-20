package hotelflow.model;

public class Quarto {

    private int numero;
    private TipoQuarto tipo;

    public Quarto(int numero, TipoQuarto tipo) {
        if (numero <= 0) {
            throw new IllegalArgumentException("Número de quarto não pode ser inferior ou igual a 0.");
        }
        this.numero = numero;
        this.tipo = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public TipoQuarto getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Quarto: " + "\n" +
                "Número: " + numero + "\n" +
                "Tipo: " + tipo;
    }
}
