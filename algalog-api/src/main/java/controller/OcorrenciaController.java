package controller;

//Classe criada na aula 3.6 / 17:00

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import antlr.collections.List;
import assembler.OcorrenciaAssembler;
import domain.model.Entrega;
import domain.model.Ocorrencia;
import domain.model.OcorrenciaInput;
import domain.model.OcorrenciaModel;
import lombok.AllArgsConstructor;
import service.BuscaEntregaService;
import service.RegistroOcorrenciaService;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId)/ocorrencias")
public class OcorrenciaController {

	private BuscaEntregaService buscaEntregaService;
	private RegistroOcorrenciaService registroOcorrenciaService;
	private OcorrenciaAssembler ocorrenciaAmssembler;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OcorrenciaModel registrar(@PathVariable long entregaId,
			@Valid @RequestBody OcorrenciaInput ocorrenciaInput) {

		// 3.6 / 19:15		
		Ocorrencia ocorrenciaRegistrada = registroOcorrenciaService
				.registrar(entregaId, ocorrenciaInput.getDescricao());
			
		  return ocorrenciaAmssembler.toModel(ocorrenciaRegistrada);	
	}
	
 	public java.util.List<OcorrenciaModel> listar(@PathVariable Long entregaId) {
 		Entrega entrega = buscaEntregaService.buscar(entregaId);

 		return ocorrenciaAmssembler.toCollectionModel(entrega.getOcorrencia());
	}

} 