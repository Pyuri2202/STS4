package domain.model.input;

//Classe criada na aula 3.5 / 25:38

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DestinatarioInput {

	@NotBlank
	private String nome;
	
	@NotBlank
	private String logradouro;
	
	@NotBlank
	private String numero;
	
	@NotBlank
	private String Complemento;
	
	@NotBlank
	private String bairro;
	
}
