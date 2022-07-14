package controller;

//classe criada na aula 3.1 ; 24:47

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import assembler.EntregaAssembler;
import domain.model.Entrega;
import domain.model.EntregaModel;
import domain.model.input.EntregaInput;
import lombok.AllArgsConstructor;
import repository.EntregaRepository;
import service.FinalizacaoEntregaService;
import service.SolicitacaoEntregaService;
import common.ModelMapperConfig; 

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")

public class EntregaController {

	private EntregaRepository entregarepository;
	private SolicitacaoEntregaService solicitacaoEntregaService;
	private FinalizacaoEntregaService finalizacaoEntregaService;
	private EntregaAssembler entregaAssembler;
	
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public EntregaModel solicitar(@Valid @RequestBody EntregaInput entregaInput) {
		Entrega novaEntrega = entregaAssembler.toEntity(entregaInput);
		Entrega entregaSolicitada = solicitacaoEntregaService.solicitar(novaEntrega);
		
		return entregaAssembler.toModel(entregaSolicitada);

	}
	
	@PutMapping("/{entregaId}/finalizar")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void finalizar(@PathVariable Long entregId) {
		finalizacaoEntregaService.finalizar(entregId);
		
	}
	
	@GetMapping
	public List<EntregaModel> listar() {
		return EntregaAssembler.toColletionModel(entregarepository.findAll());
	}
	@GetMapping("/entregaId")
	public ResponseEntity<Entrega> buscar(@PathVariable Long entregaId) {
		return entregarepository.findById(entregaId)
				.map(entrega -> ResponseEntity.ok(entregaAssembler.toModel(entrega)))
				.orElse(ResponseEntity.notFound().build());
	}
	 
}


 