/**
 * 
 */
package br.dev.rca;

/**
 * @author renan
 *
 */
public class ServicoRemotoException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServicoRemotoException(String mensagem) {
		super(mensagem);
	}
}
