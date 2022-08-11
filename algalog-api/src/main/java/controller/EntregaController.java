package controller;

//classe criada na aula 3.1 ; 24:47

import java.util.List;

import javax.validation.Valid;

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
import lombok.Getter;
import lombok.Setter;
import repository.EntregaRepository;
import service.FinalizacaoEntregaService;
import service.SolicitacaoEntregaService;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
@Getter
@Setter

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
	
	//3.7 / 13:22
	@PutMapping("/{entregaId}/finalizacao")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void finalizar(@PathVariable Long entregaId) {
		finalizacaoEntregaService.finalizar(entregaId);
	}
	
	@GetMapping
	public List<EntregaModel> listar() {
		return entregaAssembler.toColletion(entregarepository.findAll());
		
	}
	// 3.2 / 13:35
	@GetMapping("/entregaId")
	public ResponseEntity<EntregaModel> buscar(@PathVariable Long entregaId) {
		return entregarepository.findById(entregaId)
			.map(entrega -> ResponseEntity.ok(entregaAssembler.toModel(entrega)))
				.orElse(ResponseEntity.notFound().build());
	}
	 
}


 