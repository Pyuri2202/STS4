package service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.model.Entrega;
import domain.model.StatusEntrega;
import lombok.AllArgsConstructor;
import repository.ClienteRepository;
import repository.EntregaRepository;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {

	private EntregaRepository entregareposiroty;
	
	@Transactional
	public Entrega solicitar(Entrega entrega) {
		//ClienteRepository.findAllById(entrega.id);
		
		
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(LocalDateTime.now());
		
		return entregareposiroty.save(entrega);
	}
}