/**
 * 
 */
package br.dev.rca;

/**
 * @author renan
 *
 */
public class CaixaEletronico {

	private Hardware hardware;
	private ServicoRemoto servicoRemoto;
	private ContaCorrente contaCorrente;

	public void adicionarHardware(Hardware hardware) {
		this.hardware = hardware;
	}

	public void adicionarServicoRemoto(ServicoRemoto servicoRemoto) {
		this.servicoRemoto = servicoRemoto;
	}

	public String logar() {
		this.contaCorrente = servicoRemoto.recuperarConta(this.hardware.pegarNumeroDaContaCartao());

		if (contaCorrente != null)
			return "Usu?rio autenticado.";
		return "N?o foi poss?vel autenticar usu?rio.";
	}

	public String saldo() {
		return String.format("O saldo ? R$%.2f", this.contaCorrente.getSaldo());
	}

	public String sacar(double valorSaque) {
		if (valorSaque <= this.contaCorrente.getSaldo()) {
			double novoSaldo = this.contaCorrente.getSaldo() - valorSaque;
			this.hardware.entregarDinheiro(valorSaque);
			this.servicoRemoto.persistirConta(this.contaCorrente, novoSaldo);
			return "Retire o seu dinheiro.";
		}

		return "Saldo insuficiente.";
	}

	public Object depositar(double valorDeposito) {
		if (valorDeposito > 0) {
			double novoSaldo = this.contaCorrente.getSaldo() + valorDeposito;
			this.hardware.lerEnvelope(valorDeposito);
			this.servicoRemoto.persistirConta(this.contaCorrente, novoSaldo);
			return "Dep?sito recebido com sucesso.";
		}

		return "Dep?sito n?o realizado.";
	}

}
