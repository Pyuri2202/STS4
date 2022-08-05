package domain.model;

//Classe criada na aula 3.1 / 2:12

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Cliente cliente;
	
	@Embedded
	private Destinatario destinatario;
	
	private BigDecimal taxa;
	
	@OneToMany(mappedBy = "entrega", cascade = CascadeType.ALL)
	private List<Ocorrencia> ocorrencia = new ArrayList<>();
		
	public List<Ocorrencia> getOcorrencia() {
		return ocorrencia;
	}

	public void setOcorrencia(List<Ocorrencia> ocorrencia) {
		this.ocorrencia = ocorrencia;
	}

	@Enumerated(EnumType.STRING)
	private StatusEntrega status;
		
	public StatusEntrega getStatus() {
		return status;
	}

	public void setStatus(StatusEntrega status) {
		this.status = status;
	}

	public OffsetDateTime getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(OffsetDateTime dataPedido) {
		this.dataPedido = dataPedido;
	}

	private OffsetDateTime dataPedido;
	
	private OffsetDateTime dataFinalizacao;
	
	public Ocorrencia adicionarOcorrencia(String descricao) {
		Ocorrencia ocorrencia = new Ocorrencia();
		ocorrencia.setDescricao(descricao);
		ocorrencia.setEntrega(this);
		
		this.getOcorrencia().add(ocorrencia);
		
		return ocorrencia;
		
	}

	//3.7 / 05:20
	public void finalizar() {
		if (!naoPodeSerFinalizada()) {
			throw new NegocioException("Entrega nao pode ser finalizada");
		}
		
		setStatus(StatusEntrega.FINALIZADA);
		setDataFinalizacao(OffsetDateTime.now());
		}
		
		public OffsetDateTime getDataFinalizacao() {
		return dataFinalizacao;
	}

	public void setDataFinalizacao(OffsetDateTime dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}

		public boolean podeSerFinalzada() {
			return StatusEntrega.PENDENTE.equals(getStatus());
		}
		
		public boolean naoPodeSerFinalizada() {
			return !podeSerFinalzada();
	}


	
}