package hotelflow.controller;

import hotelflow.dto.ReservaRequestDTO;
import hotelflow.model.Reserva;
import hotelflow.service.ReservaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/reservas")
    public ResponseEntity<Reserva> criarReserva(@Valid @RequestBody ReservaRequestDTO reservaDTO){

        Reserva reserva = service.criarReservaPorId(reservaDTO.getHospedeId(),
                reservaDTO.getQuartoId(),
                reservaDTO.getDataCheckIn(),
                reservaDTO.getDataCheckOut(),
                reservaDTO.getObservacao());

        return ResponseEntity.status(HttpStatus.CREATED).body(reserva);
    }




}
