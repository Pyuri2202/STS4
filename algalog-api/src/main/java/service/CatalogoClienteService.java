package service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.model.Cliente;
import lombok.AllArgsConstructor;
import repository.ClienteRepository;

@AllArgsConstructor
@Service
public class CatalogoClienteService { 

	private ClienteRepository clienteRepository;
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		return ClienteRepository.save(cliente);
		
		
	@Transactional	
	public void excluir(long clienteId) {
		clienteRepository.deleteAllById(clienteId);
	}
	}

}
	
