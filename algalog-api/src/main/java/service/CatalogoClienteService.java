package service;

//classe criada na aula 2.7 / 01:48

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import domain.model.exception.NegocioException;

import domain.model.Cliente;
import lombok.AllArgsConstructor;
import repository.ClienteRepository;

@AllArgsConstructor
@Service
public class CatalogoClienteService { 

	private ClienteRepository clienteRepository;
	
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
