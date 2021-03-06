/**
 * 
 */
package br.dev.rca.test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.dev.rca.IArmazenamento;
import br.dev.rca.MockArmazenamento;
import br.dev.rca.Placar;

/**
 * @author renan
 *
 */
class TestePlacar {

	@Test
	void testePlacarRegistrar() {
		IArmazenamento armazenamento = new MockArmazenamento("./src/arquivo.json");
		Placar placar = new Placar();
		placar.adicionaArmazenamento(armazenamento);
		Assertions.assertDoesNotThrow(() -> placar.registrarPontos("guerra", "estrela", 1));
	}

	@Test
	void testePlacarRetornarPontosDoUsuario() {
		IArmazenamento armazenamento = new MockArmazenamento("./src/arquivo.json");
		Placar placar = new Placar();
		placar.adicionaArmazenamento(armazenamento);
		Map<String, Integer> pontos = new HashMap<>();
		pontos.put("moeda", 2);
		pontos.put("estrela", 3);
		Assertions.assertEquals(pontos, placar.retornarPontosDoUsuario("guerra"));
	}

	@Test
	void testePlacarRetornarRankingTipo() {
		IArmazenamento armazenamento = new MockArmazenamento("./src/arquivo.json");
		Placar placar = new Placar();
		placar.adicionaArmazenamento(armazenamento);
		Map<String, Integer> ranking = new HashMap<>();
		ranking.put("guerra", 3);
		ranking.put("fernandes", 5);
		
		Map<String, Integer> result = ranking.entrySet().stream()
				.sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

		Assertions.assertEquals(result, placar.retornarRankingTipo("estrela"));
	}

}
