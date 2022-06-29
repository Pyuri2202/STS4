package service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.model.Entrega;
import domain.model.Ocorrencia;
import lombok.AllArgsConstructor;
import repository.EntregaRepository;

@AllArgsConstructor
@Service
public class RegistroOcorrenciaService {

	private BuscaEntregaService buscaEntregaService;
	
	@Transactional
	public Ocorrencia registrar(Long entregaId, String descricao) {
		Entrega entrega = buscaEntregaService.Buscar(entregaId);
		 
		return entrega.adicionarOcorrencia(descricao);
	}
	
}
