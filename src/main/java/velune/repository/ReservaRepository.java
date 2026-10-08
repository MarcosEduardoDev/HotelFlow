package velune.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import velune.model.Quarto;
import velune.model.Reserva;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    List<Reserva> findByQuarto (Quarto quarto);

}
