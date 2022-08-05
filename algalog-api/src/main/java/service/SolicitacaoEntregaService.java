package service;

// Classe criada na aula 3.1 / 21:04

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

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

	private CatalogoClienteService catalogoClienteService;
	private EntregaRepository entregareposiroty;
	
	//.buscar
	//The method buscar(Long) is undefined for the type CatalogoClienteService
	//O método buscar(Long) é indefinido para o tipo CatalogoClienteService
	@Transactional
	public Entrega solicitar(Entrega entrega) {
		Cliente cliente = catalogoClienteService.buscar(entrega.getCliente().getId()) ;

		
	//set=definir
		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(OffsetDateTime.now());
		
		return entregareposiroty.save(entrega);
	}
}