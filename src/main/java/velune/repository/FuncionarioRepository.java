package velune.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import velune.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
