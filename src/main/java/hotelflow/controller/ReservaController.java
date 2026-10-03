package hotelflow.controller;

import hotelflow.model.Reserva;
import hotelflow.service.ReservaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReservaController {

    private final ReservaService service;

    public ReservaController(ReservaService service) {
        this.service = service;
    }

    @GetMapping("/reservas")
    public List<Reserva> listarReservas(){
        return service.listarReservas();
    }


}
