package hotelflow.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DatabaseConfig {

    @Bean
    public Connection connection() throws SQLException {

        String url = "jdbc:postgresql://localhost:5432/HotelFlow";
        String usuario = "postgres";
        String senha = "SUA_SENHA";

        return DriverManager.getConnection(url, usuario, senha);
    }
}