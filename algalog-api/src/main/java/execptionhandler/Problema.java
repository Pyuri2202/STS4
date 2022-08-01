package execptionhandler;

import java.time.LocalDateTime;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(Include.NON_NULL)
@Getter
@Setter
public class Problema {

	
	private Integer status;
	private LocalDateTime dataHora;
	private String titulo;
	private List<campo> campos;
	
	@AllArgsConstructor
	@Getter
	public static class campo {
		
		private String nome;
		private String mensagem;
	}

	public static void setStatus(int value) {
		// TODO Auto-generated method stub
		
	}


	public void setDataHora(LocalDateTime now) {
		// TODO Auto-generated method stub
		
	}


	public void setTitulo(String string) {
		// TODO Auto-generated method stub
		
	}


	public void setCampos() {
		// TODO Auto-generated method stub
		
	}
	
}
