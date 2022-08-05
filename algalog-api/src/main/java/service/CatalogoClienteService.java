package service;

import org.springframework.boot.autoconfigure.integration.IntegrationProperties.RSocket.Client;

//classe criada na aula 2.7 / 01:48

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import domain.model.exception.NegocioException;

import domain.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import repository.ClienteRepository;

@AllArgsConstructor
@Service
@Getter
@Setter
public class CatalogoClienteService { 

	private ClienteRepository clienteRepository;
	
	// metodo buscar na aula 3.1 / 38:35
	//stream = fluxo
	//get = pegue ou definir
	
	public Cliente buscar(Long clienteId) {
		return clienteRepository.findById(clienteId)
				.orElseThrow(() -> new NegocioException("Cliente não encontrado"));
	}
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
			.stream()
			.anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
			
		if (emailEmUso) {
			throw new NegocioException("já existe um cliente cadastrado com este e-mail.");
		
		}
		
		return clienteRepository.save(cliente);
	}
			
	@Transactional	
	public void excluir(long clienteId) {
		clienteRepository.deleteById(clienteId);
	}

} 
