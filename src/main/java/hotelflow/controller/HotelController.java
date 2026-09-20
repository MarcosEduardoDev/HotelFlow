package hotelflow.controller;

import hotelflow.model.Hospede;
import hotelflow.service.HospedeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;
import java.util.List;

@RestController
public class HotelController {

    @GetMapping("/hotel")
    public String hotel() {
        return "HotelFlow funcionando!";
    }

    private final HospedeRepository repository;

    public HotelController(HospedeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/hospedes")
    public List<Hospede> buscarHospede() throws SQLException {
        return repository.buscarTodos();
    }

}