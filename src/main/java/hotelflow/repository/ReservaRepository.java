package hotelflow.repository;

import hotelflow.model.Quarto;
import hotelflow.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    List<Reserva> findByQuarto (Quarto quarto);

}
