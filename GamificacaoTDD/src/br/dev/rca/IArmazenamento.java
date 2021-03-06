/**
 * 
 */
package br.dev.rca;

import java.util.List;

/**
 * @author renan
 *
 */
public interface IArmazenamento {
	public void armazenarPontos(String usuario, String tipo, int valor);

	public int recuperarPontos(String usuario, String tipo);

	public List<String> retornarTodosUsuariosComPonto();

	public List<String> retornarTodosTiposPontosUmUsuario(String usuario);
}
