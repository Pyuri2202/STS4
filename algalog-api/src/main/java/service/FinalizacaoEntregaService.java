package service;

//Classe criada na aula 3.7 / 00:54

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.model.Entrega;
import domain.model.StatusEntrega;
import lombok.AllArgsConstructor;
import repository.EntregaRepository;
import domain.model.exception.NegocioException;

@AllArgsConstructor
@Service
public class FinalizacaoEntregaService {

	private EntregaRepository entregaRepository;
	private BuscaEntregaService buscarEntregaService;
		
	@Transactional
	public void finalizar (Long entregaId) {
		Entrega entrega = buscarEntregaService.Buscar(entregaId);
		
		if (!entrega.getStatus().equals(StatusEntrega.PENDENTE)) {
			throw new NegocioException("Entrega não pode ser finalizada");
		}
		
		entrega.setStatus(StatusEntrega.FINALIZADA);
		
		entregaRepository.save(entrega);
		
	}
}
