/**
 * 
 */
package br.dev.rca;

/**
 * @author renan
 *
 */
public interface ServicoRemoto {
	public ContaCorrente recuperarConta(String numeroContaCorrente) throws ServicoRemotoException;

	public void persistirConta(ContaCorrente contaCorrente, double saldo) throws ServicoRemotoException;
}
