package velune.controller;

import velune.dto.QuartoRequestDTO;
import velune.model.Quarto;
import velune.service.QuartoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuartoController {

    private final QuartoService service;

    public QuartoController(QuartoService service) {
        this.service = service;
    }

    @GetMapping("/quartos")
    public List<Quarto> listarQuartos() {
        return service.listarQuartos();
    }

    @PostMapping("/quartos")
    public ResponseEntity<Quarto> criarQuarto(@Valid @RequestBody QuartoRequestDTO quartoRequestDTO) {
        Quarto quarto = service.criarQuarto(quartoRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(quarto);
    }
}
