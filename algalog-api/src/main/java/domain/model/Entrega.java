package domain.model;

//Classe criada na aula 3.1 / 2:12

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
import domain.model.exception.NegocioException;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import service.ValidationGroups;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Entrega {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Cliente cliente;
	
	@Embedded
	private Destinatario destinatario;
	
	private BigDecimal taxa;
	
	@OneToMany(mappedBy = "entrega")
	private List<Ocorrencia> ocorrencias = new ArrayList<>();
		
	@Enumerated(EnumType.STRING)
	private StatusEntrega status;
		
	private OffsetDateTime dataPedido;
	
	private OffsetDateTime dataFinalizacao;
	
	public Ocorrencia adicionarOcorrencia(String descricao) {
		Ocorrencia ocorrencia = new Ocorrencia();
		ocorrencia.setDescricao(descricao);
		ocorrencia.setEntrega(this);
		
	//	this.getOcorrencia().add(ocorrencia);
		
		return ocorrencia;
		
	}
	
	private BigDecimal getOcorrencia() {
		// TODO Auto-generated method stub
		return null;
	}

	public void finalizar() {
		if (!naopodeSerFinalizada()) {
			throw new NegocioException ("Entrega não pode ser finalizada");
	
		}
		
		setStatus(StatusEntrega.FINALIZADA );
	//	setDataFinalizacao(OffsetDateTime.now());
		
	//	public boolean naopodeSerFinalizada(); {
	//		return StatusEntrega.PENDENTE.equals(getStatus());
		}
	//}

	private boolean naopodeSerFinalizada() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setStatus(StatusEntrega pendente) {
		// TODO Auto-generated method stub
		
	}
	
}