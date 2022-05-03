/**
 * 
 */
package br.dev.rca;

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
