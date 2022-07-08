package domain.model.input;

//Classe criada na aula 3.5 / 21:50

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntregaInput {

	@Valid
	@NotNull
	private ClienteIdInput cliente;
	
	@Valid
	@NotNull
	private DestinatarioInput destinatario;
	
	@NotNull
	private BigDecimal taxa;
	
	private OffsetDateTime dataFinalizacao;
	
}
