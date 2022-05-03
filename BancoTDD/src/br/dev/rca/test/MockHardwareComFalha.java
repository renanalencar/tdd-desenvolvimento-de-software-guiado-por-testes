/**
 * 
 */
package br.dev.rca.test;

import br.dev.rca.Hardware;
import br.dev.rca.HardwareException;

/**
 * @author renan
 *
 */
public class MockHardwareComFalha implements Hardware {

	@Override
	public String pegarNumeroDaContaCartao() {
		throw new HardwareException("Erro ao pegar número da conta.");
	}

	@Override
	public void entregarDinheiro(double valor) {
		throw new HardwareException("Erro ao entregar dinheiro.");
	}

	@Override
	public void lerEnvelope(double valor) {
		throw new HardwareException("Erro ao ler envelope.");
	}

}
