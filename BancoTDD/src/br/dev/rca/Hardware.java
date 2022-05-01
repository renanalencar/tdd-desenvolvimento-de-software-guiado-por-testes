/**
 * 
 */
package br.dev.rca;

/**
 * @author renan
 *
 */
public interface Hardware {
	public String pegarNumeroDaContaCartao() throws HardwareException;

	public void entregarDinheiro(double valor) throws HardwareException;

	public void lerEnvelope(double valor) throws HardwareException;
}
