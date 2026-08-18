package hotelflow.model;
import java.time.LocalDateTime;

public class Notificacao {

    private String mensagem;
    private LocalDateTime data;
    private boolean lida;
    private static int contaNotificacao = 1;
    private int idNotificacao;

    public int getIdNotificacao() {
        return idNotificacao;
    }

    public Notificacao(String mensagem, LocalDateTime data) {
        this.mensagem = mensagem;
        this.data = data;
        this.idNotificacao = contaNotificacao++;
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




}
