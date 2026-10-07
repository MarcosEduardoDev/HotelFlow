package velune.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import velune.model.Quarto;
import velune.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    List<Reserva> findByQuarto (Quarto quarto);

    @Query("""
           SELECT r
           FROM Reserva r
           WHERE r.dataCheckIn <= :data
           AND r.dataCheckOut > :data""")
    List<Reserva> buscarReservasNaData(@Param("data") LocalDate data);
}
