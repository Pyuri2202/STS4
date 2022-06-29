package service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.model.Entrega;
import domain.model.StatusEntrega;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FinalizacaoEntregaService {

	//private Entrega
	private BuscaEntregaService buscarEntregaService;
		
	@Transactional
	public void finalizar (Long entregaId) {
		Entrega entrega = buscarEntregaService.Buscar(entregaId);
		
		entrega.finalizar();
		
		//entregaRepository.save(entrega);
		
	}
}
