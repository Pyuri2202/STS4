package repository;

import java.util.List;

import javax.validation.Valid;

import org.springframework.boot.autoconfigure.integration.IntegrationProperties.RSocket.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Client, Long> {

	List<Client> findByNome(String nome);
	List<Client>findByNomeContaining (String nome);
	Cliente save(@Valid Cliente cliente);
}