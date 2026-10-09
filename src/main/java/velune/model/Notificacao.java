package velune.model;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Notificacao {

    private String mensagem;
    private LocalDateTime data;
    private boolean lida;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Notificacao(String mensagem, LocalDateTime data) {
        this.mensagem = mensagem;
        this.data = data;

    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getData() {
        return data;
    }

    public boolean isLida() {
        return lida;
    }

    public void marcarComoLida(){
        this.lida = true;
    }

    @Override
    public String toString() {
        return "Notificacao: " +
                "Mensagem = " + mensagem + "\n" +
                "Data = " + data + "\n" +
                "Lida = " + lida;
    }

    public Long getId() {
        return id;
    }

    protected Notificacao() {}
}
