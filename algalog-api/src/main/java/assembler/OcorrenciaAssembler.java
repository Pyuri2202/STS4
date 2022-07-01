package assembler;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import domain.model.Ocorrencia;
import domain.model.OcorrenciaModel;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class OcorrenciaAssembler {

	private ModelMapper modelMapper;

	public OcorrenciaModel toModel(Ocorrencia ocorrencia) {
		return modelMapper.map(ocorrencia, OcorrenciaModel.class);
		
	}
}
  