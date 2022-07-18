package controller;

//Classe criada na aula 3.6 / 17:00

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import assembler.OcorrenciaAssembler;
import domain.model.Ocorrencia;
import domain.model.OcorrenciaInput;
import domain.model.OcorrenciaModel;
import lombok.AllArgsConstructor;
import service.RegistroOcorrenciaService;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId)/ocorrencias")
public class OcorrenciaController {

	private RegistroOcorrenciaService registroOcorrenciaService;
	private OcorrenciaAssembler ocorrenciaAmssembler;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OcorrenciaModel registrar(@PathVariable long entregaId,
			@Valid @RequestBody OcorrenciaInput ocorrenciaInput) {
				
		Ocorrencia ocorrenciaResgistrada = registroOcorrenciaService
				.registrar(entregaId, ocorrenciaInput.getClass());
			
		return ocorrenciaAmssembler.toModel(ocorrenciaResgistrada);

	}

}