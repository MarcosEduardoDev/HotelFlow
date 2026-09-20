package hotelflow.model;

public enum TipoQuarto {
    SIMPLES(250.0, 2),
    DUPLO(350.0, 4),
    SUITE(500.0, 6);

    private final double precoDiaria;
    private final int capacidade;

    public double getPrecoDiaria() {
        return precoDiaria;
    }

    public int getCapacidade() {
        return capacidade;
    }

    TipoQuarto(double precoDiaria, int capacidade) {
        this.precoDiaria = precoDiaria;
        this.capacidade = capacidade;
    }
}
