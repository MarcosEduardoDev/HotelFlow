package hotelflow.controller;

import hotelflow.dto.HospedeRequestDTO;
import hotelflow.exception.HospedeJaExisteException;
import hotelflow.model.Hospede;
import hotelflow.service.HospedeRepository;
import hotelflow.service.HospedeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class HotelController {

    @GetMapping("/hotel")
    public String hotel() {
        return "HotelFlow funcionando!";
    }

    private final HospedeService service;

    public HotelController(HospedeService service) {
        this.service = service;
    }

    @GetMapping("/hospedes")
    public List<Hospede> buscarHospede() throws SQLException {
        return service.buscarTodos();
    }

    @PostMapping("/hospedes")
    public void salvarHospede(@Valid @RequestBody HospedeRequestDTO hospedeDTO) throws SQLException, HospedeJaExisteException {
        service.salvarHospede(hospedeDTO);
    }

    @GetMapping("/hospedes/{documento}")
    public ResponseEntity<Hospede> buscarPorDocumento(@PathVariable String documento) throws SQLException {

        Hospede hospede = service.buscarPorDocumento(documento);

        if (hospede != null) {
            return ResponseEntity.ok(hospede);
        }

        return ResponseEntity.notFound().build();
    }

}