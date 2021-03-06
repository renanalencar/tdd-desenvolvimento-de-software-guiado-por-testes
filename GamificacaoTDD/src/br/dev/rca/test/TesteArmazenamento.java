/**
 * 
 */
package br.dev.rca.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.dev.rca.Armazenamento;
import br.dev.rca.ValorPontoException;

/**
 * @author renan
 *
 */
class TesteArmazenamento {

	@Test
	void testeArmazenamentoArmazenarPontos() {
		Armazenamento armazenamento = new Armazenamento("./src/armazenamento.json");
		Assertions.assertDoesNotThrow(() -> armazenamento.armazenarPontos("guerra", "estrela", 1));
	}
	
	@Test
	void testeArmazenamentoArmazenarPontosComFalha() {
		Armazenamento armazenamento = new Armazenamento("./src/armazenamento.json");
		Assertions.assertThrows(ValorPontoException.class, () -> armazenamento.armazenarPontos("guerra", "estrela", 0));
	}

	@Test
	void testeArmazenamentoRecuperarPontos() {
		Armazenamento armazenamento = new Armazenamento("./src/armazenamento.json");
		Assertions.assertEquals(1, armazenamento.recuperarPontos("guerra", "estrela"));
	}

	@Test
	void testeArmazenamentoRetornarTodosUsuariosComPonto() {
		Armazenamento armazenamento = new Armazenamento("./src/armazenamento.json");
		
		
		armazenamento.armazenarPontos("guerra", "estrela", 2);
		armazenamento.armazenarPontos("guerra", "moeda", 3);
		armazenamento.armazenarPontos("fernandes", "estrela", 5);
		
		List<String> usuarios = new ArrayList<>();
		usuarios.add("guerra");
		usuarios.add("fernandes");
		
		Assertions.assertEquals(usuarios, armazenamento.retornarTodosUsuariosComPonto());
	}

	@Test
	void testeArmazenamentoRetornarTodosTiposPontosUmUsuario() {
		Armazenamento armazenamento = new Armazenamento("./src/armazenamento.json");
		
		armazenamento.armazenarPontos("guerra", "estrela", 2);
		armazenamento.armazenarPontos("guerra", "moeda", 3);
		armazenamento.armazenarPontos("fernandes", "estrela", 5);
		armazenamento.armazenarPontos("fernandes", "moeda", 10);
		
		List<String> tipos = new ArrayList<>();
		tipos.add("estrela");
		tipos.add("moeda");
		
		Assertions.assertEquals(tipos, armazenamento.retornarTodosTiposPontosUmUsuario("guerra"));
	}
}
