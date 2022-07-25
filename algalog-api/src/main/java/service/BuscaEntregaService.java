package service;

// Classe criada na aula 3.6 / 12:15

import java.util.Optional;

//Classe criada na aula 3.6 / 12:15

import org.springframework.stereotype.Service;

import domain.model.Entrega;
import lombok.AllArgsConstructor;
import repository.EntregaRepository;
import domain.model.exception.EntidadeNaoEncontradaException;
import domain.model.exception.NegocioException;


@AllArgsConstructor
@Service
public class BuscaEntregaService {

	private EntregaRepository entregarepository;

	// 3.6 / 12:32
	
	public Entrega buscar(Long entregaId) {
		return entregarepository.findById(entregaId)
				.orElseThrow(() -> new NegocioException("Entrega não encontrada"));
	}
}