package service;

import org.springframework.stereotype.Service;

import domain.model.Entrega;
import lombok.AllArgsConstructor;
import repository.EntregaRepository;
import domain.model.exception.EntidadeNaoEncontradaException;


@AllArgsConstructor
@Service
public class BuscaEntregaService {

	private EntregaRepository entregarepository;
	
	public Entrega Buscar(Long entregaId) {
		Entrega entrega = entregarepository.findById(entregaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontra"));
	}
}
