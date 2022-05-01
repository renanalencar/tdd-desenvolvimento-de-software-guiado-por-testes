/**
 * 
 */
package br.dev.rca;

/**
 * @author renan
 *
 */
public class ContaCorrente {

	private String numeroConta;
	private double saldo;

	public ContaCorrente(String numero, double valor) {
		this.setNumeroConta(numero);
		this.saldo = valor;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public double getSaldo() {
		return this.saldo;
	}

	public void setSaldo(double valor) {
		this.saldo = valor;
	}

}
