package velune.repository;

import velune.model.Hospede;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface HospedeRepository extends JpaRepository<Hospede, Long> {

    Optional<Hospede> findByDocumento(String documento);

    boolean existsByDocumento(String documento);

}