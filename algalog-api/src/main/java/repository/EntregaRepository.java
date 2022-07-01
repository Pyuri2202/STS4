package repository;



import java.util.List;

import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import domain.model.Entrega;

		//classe criada na aula 3.1 Implementando solicitacao de entrega 18:46
@Repository
public class EntregaRepository extends JpaRepositoryExtension<Entrega, Long>{
  
	public Entrega save(Entrega entrega) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Entrega> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object findById(Long entregaId) {
		// TODO Auto-generated method stub
		return null;
	}

}
