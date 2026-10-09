package velune.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Escala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Turno turno;

    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    protected Escala() {}

    public Escala(Turno turno, LocalDate data) {
        this.turno = turno;
        this.data = data;
    }

    public Turno getTurno() {
        return turno;
    }

    public LocalDate getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Escala{" +
                "Turno = " + turno +
                ", Data = " + data +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}