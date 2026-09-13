package hotelflow.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao{

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/HotelFlow";
        String usuario = "postgres";
        String senha = "SUA_SENHA";

        try {
            Class.forName("org.postgresql.Driver");

            Connection conexao = DriverManager.getConnection(url, usuario, senha);

            System.out.println("Conectado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}