/**
 * 
 */
package br.dev.rca.test;

import br.dev.rca.ContaCorrente;
import br.dev.rca.ServicoRemoto;
import br.dev.rca.ServicoRemotoException;

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
