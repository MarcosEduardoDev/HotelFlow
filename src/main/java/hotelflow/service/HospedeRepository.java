package hotelflow.service;

import hotelflow.model.Hospede;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class HospedeRepository {

    private final Connection conexao;

    public HospedeRepository(Connection conexao) {
        this.conexao = conexao;
    }

    public void salvarHospede(Hospede hospede) throws SQLException {

        String sql = "INSERT INTO hospede(nome, documento) VALUES (?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, hospede.getNome());
            stmt.setString(2, hospede.getDocumento());

            stmt.executeUpdate();
        }
    }

    public List<Hospede> buscarTodos() throws SQLException {

        List<Hospede> hospedes = new ArrayList<>();

        String sql = "SELECT * FROM hospede";

        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet resultado = stmt.executeQuery()) {

            while (resultado.next()) {

                String nome = resultado.getString("nome");
                String documento = resultado.getString("documento");

                Hospede hospede = new Hospede(nome, documento);

                hospedes.add(hospede);
            }
        }
        return hospedes;
    }

        public Hospede buscarPorDocumento(String documento) throws SQLException{

            String sql1 = "SELECT * FROM hospede WHERE documento = ?";

            try (PreparedStatement stmt1 = conexao.prepareStatement(sql1)) {
                stmt1.setString(1, documento);

                try (ResultSet resultado = stmt1.executeQuery()) {
                    if (resultado.next()) {

                        String nome = resultado.getString("nome");
                        String doc = resultado.getString("documento");

                        return new Hospede(nome, doc);
                    }

                    return null;
                }
            }
        }
    }