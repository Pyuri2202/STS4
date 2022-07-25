package service;

// Classe criada na aula 3.6 / 06:20

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.model.Entrega;
import domain.model.Ocorrencia;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RegistroOcorrenciaService {

	private BuscaEntregaService buscaEntregaService;
	
	@Transactional
	public Ocorrencia registrar(Long entregaId, String descricao) {
		Entrega entrega = buscaEntregaService.buscar(entregaId);
		 
		return entrega.adicionarOcorrencia(descricao);
	}
	
}
 