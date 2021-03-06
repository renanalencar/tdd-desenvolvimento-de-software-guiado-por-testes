/**
 * 
 */
package br.dev.rca;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author renan
 *
 */
public class Placar {
	private IArmazenamento armazenamento;

	public void adicionaArmazenamento(IArmazenamento armazenamento) {
		this.armazenamento = armazenamento;
	}

	public void registrarPontos(String usuario, String tipo, int valor) {
		this.armazenamento.armazenarPontos(usuario, tipo, valor);
	}

	public Map<String, Integer> retornarPontosDoUsuario(String usuario) {
		Map<String, Integer> pontos = new HashMap<>();

		for (String tipo : this.armazenamento.retornarTodosTiposPontosUmUsuario(usuario)) {
			pontos.put(tipo, this.armazenamento.recuperarPontos(usuario, tipo));
		}

		return pontos;
	}

	public Map<String, Integer> retornarRankingTipo(String tipo) {
		Map<String, Integer> ranking = new HashMap<>();
		for (String usuario : this.armazenamento.retornarTodosUsuariosComPonto()) {
			Map<String, Integer> pontos = this.retornarPontosDoUsuario(usuario);
			if (pontos.containsKey(tipo))
				ranking.put(usuario, pontos.get(tipo));
		}

		return ordenarMapaDescrente(ranking);
	}

	private Map<String, Integer> ordenarMapaDescrente(Map<String, Integer> ranking) {
		Map<String, Integer> result = ranking.entrySet().stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

		return result;
	}

}
