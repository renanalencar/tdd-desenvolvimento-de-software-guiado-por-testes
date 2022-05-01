/**
 * 
 */
package br.dev.rca;

/**
 * @author renan
 *
 */
public class MockServicoRemotoComFalha implements ServicoRemoto {

	@Override
	public ContaCorrente recuperarConta(String numeroContaCorrente) {
		throw new ServicoRemotoException("Falha ao recuperar conta.");
	}

	@Override
	public void persistirConta(ContaCorrente contaCorrente, double saldo) {
		throw new ServicoRemotoException("Falha ao persistir conta.");
	}

}
