package repository;

import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
import org.springframework.stereotype.Repository;

@Repository
public class EntregaRepository extends JpaRepository<Entrega, Long>{

}
