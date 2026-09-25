package hotelflow.service;

import hotelflow.dto.HospedeRequestDTO;
import hotelflow.exception.HospedeJaExisteException;
import hotelflow.model.Hospede;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class HospedeService {

    private final HospedeRepository repository;

    public HospedeService(HospedeRepository repository) {
        this.repository = repository;
    }

    public void salvarHospede(HospedeRequestDTO hospedeDTO) throws SQLException, HospedeJaExisteException {

        Hospede hospede = new Hospede(
                hospedeDTO.getNome(), hospedeDTO.getDocumento());

        Hospede hospedeExistente = repository.buscarPorDocumento(hospedeDTO.getDocumento());

        if (hospedeExistente != null) {
            throw new HospedeJaExisteException("Número de documento utilizado por outro hóspede.");
        }
            repository.salvarHospede(hospede);
    }

    public List<Hospede> buscarTodos() throws SQLException {
        return repository.buscarTodos();
    }

    public Hospede buscarPorDocumento(String documento) throws SQLException{
        return repository.buscarPorDocumento(documento);
    }
}
