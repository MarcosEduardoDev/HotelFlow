package hotelflow.repository;

import hotelflow.model.Quarto;
import hotelflow.model.TipoQuarto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuartoRepository extends JpaRepository<Quarto, Long> {

    Optional<Quarto> findByNumero (Integer numero);
    List<Quarto> findByTipo (TipoQuarto tipoQuarto);

}
