package service;

// Classe criada na aula 3.1 / 21:04

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.model.Cliente;
import domain.model.Entrega;
import domain.model.StatusEntrega;
import lombok.AllArgsConstructor;
import repository.ClienteRepository;
import repository.EntregaRepository;
import service.CatalogoClienteService;

@NotNull
@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {

private EntregaRepository entregareposiroty;
	
	//

	@Transactional
	public Entrega solicitar(Entrega entrega) {
		Cliente cliente = CatalogoClienteService.buscar(entrega.getCliente(.getId()) ;
		
		
	//
		
		entrega.setStatus(StatusEntrega.PENDENTE); 
		entrega.setDataPedido(LocalDateTime.now());
		
		return entregareposiroty.save(entrega);
	}
}