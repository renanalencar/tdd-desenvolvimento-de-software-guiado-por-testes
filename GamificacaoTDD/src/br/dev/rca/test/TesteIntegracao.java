package br.dev.rca.test;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.dev.rca.Armazenamento;
import br.dev.rca.IArmazenamento;
import br.dev.rca.Placar;
import br.dev.rca.ValorPontoException;

class TesteIntegracao {

	@Test
	void testePlacarRegistrar() {
		IArmazenamento armazenamento = new Armazenamento("./src/armazenamento.json");
		Placar placar = new Placar();
		placar.adicionaArmazenamento(armazenamento);
		Assertions.assertDoesNotThrow(() -> placar.registrarPontos("guerra", "estrela", 1));
	}

	@Test
	void testePlacarRegistrarComFalha() {
		IArmazenamento armazenamento = new Armazenamento("./src/armazenamento.json");
		Placar placar = new Placar();
		placar.adicionaArmazenamento(armazenamento);
		Assertions.assertThrows(ValorPontoException.class, () -> placar.registrarPontos("guerra", "estrela", 0));
	}

	@Test
	void testePlacarRetornarPontosDoUsuario() {
		IArmazenamento armazenamento = new Armazenamento("./src/armazenamento.json");
		Placar placar = new Placar();
		placar.adicionaArmazenamento(armazenamento);

		placar.registrarPontos("guerra", "estrela", 2);
		placar.registrarPontos("guerra", "moeda", 3);
		placar.registrarPontos("fernandes", "estrela", 5);
		placar.registrarPontos("fernandes", "moeda", 10);

		Map<String, Integer> pontos = new HashMap<>();
		pontos.put("estrela", 2);
		pontos.put("moeda", 3);

		Assertions.assertEquals(pontos, placar.retornarPontosDoUsuario("guerra"));
	}

	@Test
	void testePlacarRetornarRankingTipo() {
		IArmazenamento armazenamento = new Armazenamento("./src/armazenamento.json");
		Placar placar = new Placar();
		placar.adicionaArmazenamento(armazenamento);

		placar.registrarPontos("guerra", "estrela", 2);
		placar.registrarPontos("guerra", "moeda", 3);
		placar.registrarPontos("fernandes", "estrela", 5);
		placar.registrarPontos("fernandes", "moeda", 10);

		Map<String, Integer> ranking = new HashMap<>();
		ranking.put("guerra", 2);
		ranking.put("fernandes", 5);

		Map<String, Integer> result = ranking.entrySet().stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

		Assertions.assertEquals(result, placar.retornarRankingTipo("estrela"));
	}

}
