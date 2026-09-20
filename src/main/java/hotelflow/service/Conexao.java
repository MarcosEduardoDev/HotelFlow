package hotelflow.service;

import hotelflow.model.Hospede;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Conexao {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/HotelFlow";
        String usuario = "postgres";
        String senha = "SUA_SENHA";

        try {
            Class.forName("org.postgresql.Driver");

            try (Connection conexao = DriverManager.getConnection(url, usuario, senha)) {

                conexao.setAutoCommit(false);

                try {
                    System.out.println("Conectado com sucesso!");

                    Hospede hospede = new Hospede("Marcos", "1234567");

                    HospedeRepository repository = new HospedeRepository(conexao);
                    repository.salvarHospede(hospede);

                    List<Hospede> hospedes = repository.buscarTodos();

                    for (Hospede hospedeBanco : hospedes) {
                        System.out.println(hospedeBanco);
                    }

                    conexao.commit();

                } catch (SQLException e) {

                    conexao.rollback();
                    e.printStackTrace();
                }
            }

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}