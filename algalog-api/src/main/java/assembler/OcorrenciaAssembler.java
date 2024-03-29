package assembler;

// Classe criada na aula 3.6 / 20:15

import java.util.List;
import java.util.stream.Collectors;

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
	
		public List<OcorrenciaModel> toCollectionModel(List<Ocorrencia> ocorrencias) {
			return ocorrencias.stream()
					.map(this::toModel)
					.collect(Collectors.toList());
	}
}
  