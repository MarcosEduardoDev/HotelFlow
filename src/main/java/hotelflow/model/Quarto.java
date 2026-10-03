package hotelflow.model;

import jakarta.persistence.*;

@Entity
public class Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    @Column(nullable = false, unique = true)
    private Integer numero;

    @Enumerated(EnumType.STRING)
    private TipoQuarto tipo;

    protected Quarto() {}

    public Quarto(Integer numero, TipoQuarto tipo) {
        if (numero <= 0) {
            throw new IllegalArgumentException("Número de quarto não pode ser inferior ou igual a 0.");
        }
        this.numero = numero;
        this.tipo = tipo;
    }

    public Integer getNumero() {
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
