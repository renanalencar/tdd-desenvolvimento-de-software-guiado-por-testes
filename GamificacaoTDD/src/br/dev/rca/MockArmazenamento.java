/**
 * 
 */
package br.dev.rca;

import java.util.ArrayList;
import java.util.List;

/**
 * @author renan
 *
 */
public class MockArmazenamento implements IArmazenamento {

	public MockArmazenamento(String string) {

	}

	@Override
	public void armazenarPontos(String usuario, String tipo, int valor) {

	}

	@Override
	public int recuperarPontos(String usuario, String tipo) {
		if (usuario.equals("guerra")) {
			if (tipo.equals("moeda"))
				return 2;
			else
				return 3;
		}

		if (usuario.equals("fernandes")) {
			if (tipo.equals("moeda"))
				return 5;
			else
				return 5;
		}
		return 0;
	}

	@Override
	public List<String> retornarTodosUsuariosComPonto() {
		List<String> usuarios = new ArrayList<>();
		usuarios.add("guerra");
		usuarios.add("fernandes");
		return usuarios;
	}

	@Override
	public List<String> retornarTodosTiposPontosUmUsuario(String usuario) {
		List<String> tipos = new ArrayList<>();
		tipos.add("moeda");
		tipos.add("estrela");
		return tipos;
	}

}
