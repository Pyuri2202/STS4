package domain.model;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OcorrenciaModel {

	private Long Id;
	private String descricao;
	private OffsetDateTime dataRegistro;
	
}
