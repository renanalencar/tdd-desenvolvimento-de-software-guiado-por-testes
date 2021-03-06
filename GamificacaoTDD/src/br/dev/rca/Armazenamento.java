/**
 * 
 */
package br.dev.rca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author renan
 *
 */
public class Armazenamento implements IArmazenamento {
	private String arquivo;
	private Map<String, Map<String, String>> placares;

	public Armazenamento(String nomeArquivo) {
		this.arquivo = nomeArquivo;
		placares = new HashMap<>();
		Jason.lerDeArquivo(this.arquivo);
	}

	@Override
	public void armazenarPontos(String usuario, String tipo, int valor) {
		if (valor > 0) {

			Map<String, Map<String, String>> arquivoLido = Jason.lerDeArquivo(this.arquivo);

			if (arquivoLido != null)
				this.placares = arquivoLido;

			Map<String, String> pontos = new HashMap<>();
			if (this.placares.containsKey(usuario))
				pontos = this.placares.get(usuario);
			pontos.put(tipo, String.valueOf(valor));

			this.placares.put(usuario, pontos);
			Jason.gravarEmArquivo(this.arquivo, this.placares);

		} else
			throw new ValorPontoException("Valor do ponto n?o pode ser 0.");
	}

	@Override
	public int recuperarPontos(String usuario, String tipo) {
		this.placares = Jason.lerDeArquivo(this.arquivo);
		Map<String, String> pontos = this.placares.get(usuario);
		String aux = "" + pontos.get(tipo);
		double d = Double.valueOf(aux);
		return (int) d;
	}

	@Override
	public List<String> retornarTodosUsuariosComPonto() {
		List<String> usuariosComPontos = new ArrayList<>();
		for (String usuario : this.placares.keySet()) {
			usuariosComPontos.add(usuario);
		}
		return usuariosComPontos;
	}

	@Override
	public List<String> retornarTodosTiposPontosUmUsuario(String usuario) {
		List<String> tipos = new ArrayList<>();
		Map<String, String> placar = this.placares.get(usuario);
		for (String tipo : placar.keySet()) {
			tipos.add(tipo);
		}
		return tipos;
	}

}
