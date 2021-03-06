/**
 * 
 */
package br.dev.rca.test;

import br.dev.rca.ContaCorrente;
import br.dev.rca.ServicoRemoto;

/**
 * @author renan
 *
 */
public class MockServicoRemoto implements ServicoRemoto {

	private boolean falha = false;

	@Override
	public ContaCorrente recuperarConta(String numeroContaCorrente) {
		if (falha)
			return null;
		return new ContaCorrente("123", 100.0);
	}

	@Override
	public void persistirConta(ContaCorrente contaCorrente, double saldo) {
		contaCorrente.setSaldo(saldo);
	}

	public void falhar() {
		this.falha = true;
	}

}
