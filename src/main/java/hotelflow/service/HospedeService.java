package hotelflow.service;

import hotelflow.dto.HospedeRequestDTO;
import hotelflow.exception.HospedeJaExisteException;
import hotelflow.model.Hospede;
import hotelflow.repository.HospedeRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HospedeService {

    private final HospedeRepository repository;

    public HospedeService(HospedeRepository repository) {
        this.repository = repository;
    }

    public Hospede salvarHospede(HospedeRequestDTO hospedeRequestDTO)  {

        Hospede hospede = new Hospede(
                hospedeRequestDTO.getNome(), hospedeRequestDTO.getDocumento());

        if (repository.existsByDocumento(hospede.getDocumento())) {
            throw new HospedeJaExisteException("Este documento já está sendo utilizado por outro hóspede.");
        }
        return repository.save(hospede);
    }

    public List<Hospede> buscarTodos() {
        return repository.findAll();
    }

    public Optional<Hospede> buscarPorDocumento(String documento) {
        return repository.findByDocumento(documento);
    }
}
