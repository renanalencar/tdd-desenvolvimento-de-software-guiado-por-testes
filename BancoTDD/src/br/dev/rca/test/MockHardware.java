/**
 * 
 */
package br.dev.rca.test;

import br.dev.rca.Hardware;

/**
 * @author renan
 *
 */
public class MockHardware implements Hardware {

	@Override
	public String pegarNumeroDaContaCartao() {
		return "123";
	}

	@Override
	public void entregarDinheiro(double valor) {

	}

	@Override
	public void lerEnvelope(double valor) {

	}

}
