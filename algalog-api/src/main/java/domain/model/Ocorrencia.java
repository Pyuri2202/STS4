package domain.model;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Ocorrencia {

	@EqualsAndHashCode.Include
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@ManyToOne
	private Entrega entrega;
	
	private String descrição;
	private OffsetDateTime dataResgistro;
	public void setDescricao(String descricao) {
		// TODO Auto-generated method stub
		
	}
	public void setEntrega(Entrega entrega2) {
		// TODO Auto-generated method stub
		
	}
	
	
}
