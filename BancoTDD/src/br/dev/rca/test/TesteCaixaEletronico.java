package br.dev.rca.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.dev.rca.CaixaEletronico;
import br.dev.rca.Hardware;
import br.dev.rca.HardwareException;
import br.dev.rca.ServicoRemoto;
import br.dev.rca.ServicoRemotoException;

class TesteCaixaEletronico {

	@Test
	void testeCaixaEletronicoLogarComSucesso() {
		CaixaEletronico caixaEletronico = new CaixaEletronico();
		MockHardware mockHardware = new MockHardware();
		caixaEletronico.adicionarHardware(mockHardware);
		ServicoRemoto mockServicoRemoto = new MockServicoRemoto();
		caixaEletronico.adicionarServicoRemoto(mockServicoRemoto);
		Assertions.assertEquals("Usu?rio autenticado.", caixaEletronico.logar());
	}

	@Test
	void testeCaixaEletronicoLogarcomFalha() {
		CaixaEletronico caixaEletronico = new CaixaEletronico();
		MockHardware mockHardware = new MockHardware();
		caixaEletronico.adicionarHardware(mockHardware);
		MockServicoRemoto mockServicoRemoto = new MockServicoRemoto();
		mockServicoRemoto.falhar();
		caixaEletronico.adicionarServicoRemoto(mockServicoRemoto);
		Assertions.assertEquals("N?o foi poss?vel autenticar usu?rio.", caixaEletronico.logar());
	}

	@Test
	void testeCaixaEletronicoSaldoComSucesso() {
		CaixaEletronico caixaEletronico = new CaixaEletronico();
		MockHardware mockHardware = new MockHardware();
		caixaEletronico.adicionarHardware(mockHardware);
		MockServicoRemoto mockServicoRemoto = new MockServicoRemoto();
		caixaEletronico.adicionarServicoRemoto(mockServicoRemoto);
		caixaEletronico.logar();
		Assertions.assertEquals("O saldo ? R$100,00", caixaEletronico.saldo());
	}

	@Test
	void testeCaixaEletronicoSaldoComFalha() {
		CaixaEletronico caixaEletronico = new CaixaEletronico();
		MockHardware mockHardware = new MockHardware();
		caixaEletronico.adicionarHardware(mockHardware);
		MockServicoRemoto mockServicoRemoto = new MockServicoRemoto();
		caixaEletronico.adicionarServicoRemoto(mockServicoRemoto);
		caixaEletronico.logar();
		Assertions.assertEquals("O saldo ? R$100,00", caixaEletronico.saldo());
	}

	@Test
	void testeCaixaEletronicoSacarComSucesso() {
		CaixaEletronico caixaEletronico = new CaixaEletronico();
		MockHardware mockHardware = new MockHardware();
		caixaEletronico.adicionarHardware(mockHardware);
		MockServicoRemoto mockServicoRemoto = new MockServicoRemoto();
		caixaEletronico.adicionarServicoRemoto(mockServicoRemoto);
		caixaEletronico.logar();
		Assertions.assertEquals("Retire o seu dinheiro.", caixaEletronico.sacar(10.50));
		Assertions.assertEquals("O saldo ? R$89,50", caixaEletronico.saldo());
	}

	@Test
	void testeCaixaEletronicoSacarComFalha() {
		CaixaEletronico caixaEletronico = new CaixaEletronico();
		MockHardware mockHardware = new MockHardware();
		caixaEletronico.adicionarHardware(mockHardware);
		MockServicoRemoto mockServicoRemoto = new MockServicoRemoto();
		caixaEletronico.adicionarServicoRemoto(mockServicoRemoto);
		caixaEletronico.logar();
		Assertions.assertEquals("Saldo insuficiente.", caixaEletronico.sacar(200.0));
	}

	@Test
	void testeCaixaEletronicoDepositarComSucesso() {
		CaixaEletronico caixaEletronico = new CaixaEletronico();
		MockHardware mockHardware = new MockHardware();
		caixaEletronico.adicionarHardware(mockHardware);
		MockServicoRemoto mockServicoRemoto = new MockServicoRemoto();
		caixaEletronico.adicionarServicoRemoto(mockServicoRemoto);
		caixaEletronico.logar();
		Assertions.assertEquals("Dep?sito recebido com sucesso.", caixaEletronico.depositar(10.50));
		Assertions.assertEquals("O saldo ? R$110,50", caixaEletronico.saldo());
	}

	@Test
	void testeCaixaEletronicoDepositarComFalha() {
		CaixaEletronico caixaEletronico = new CaixaEletronico();
		MockHardware mockHardware = new MockHardware();
		caixaEletronico.adicionarHardware(mockHardware);
		MockServicoRemoto mockServicoRemoto = new MockServicoRemoto();
		caixaEletronico.adicionarServicoRemoto(mockServicoRemoto);
		caixaEletronico.logar();
		Assertions.assertEquals("Dep?sito n?o realizado.", caixaEletronico.depositar(0));
	}

	@Test
	void testeHardwareComFalhaPegarNumeroContaCartao() {
		CaixaEletronico caixaEletronico = new CaixaEletronico();
		Hardware mockHardware = new MockHardwareComFalha();
		caixaEletronico.adicionarHardware(mockHardware);
		MockServicoRemoto mockServicoRemoto = new MockServicoRemoto();
		caixaEletronico.adicionarServicoRemoto(mockServicoRemoto);
		Assertions.assertThrows(HardwareException.class, () -> caixaEletronico.logar());
	}

	@Test
	void testeHardwareComFalhaEntregarDinheiro() {
		CaixaEletronico caixaEletronico = new CaixaEletronico();
		Hardware mockHardware = new MockHardware();
		caixaEletronico.adicionarHardware(mockHardware);
		MockServicoRemoto mockServicoRemoto = new MockServicoRemoto();
		caixaEletronico.adicionarServicoRemoto(mockServicoRemoto);
		caixaEletronico.logar();
		Hardware mockHardwareComFalha = new MockHardwareComFalha();
		caixaEletronico.adicionarHardware(mockHardwareComFalha);
		Assertions.assertThrows(HardwareException.class, () -> caixaEletronico.sacar(10.50));
	}

	@Test
	void testeHardwareComFalhaLerEnvelope() {
		CaixaEletronico caixaEletronico = new CaixaEletronico();
		Hardware mockHardware = new MockHardware();
		caixaEletronico.adicionarHardware(mockHardware);
		MockServicoRemoto mockServicoRemoto = new MockServicoRemoto();
		caixaEletronico.adicionarServicoRemoto(mockServicoRemoto);
		caixaEletronico.logar();
		Hardware mockHardwareComFalha = new MockHardwareComFalha();
		caixaEletronico.adicionarHardware(mockHardwareComFalha);
		Assertions.assertThrows(HardwareException.class, () -> caixaEletronico.depositar(10.50));
	}

	@Test
	void testeServicoRemotoComFalhaRecuperarConta() {
		CaixaEletronico caixaEletronico = new CaixaEletronico();
		Hardware mockHardware = new MockHardware();
		caixaEletronico.adicionarHardware(mockHardware);
		ServicoRemoto mockServicoRemoto = new MockServicoRemotoComFalha();
		caixaEletronico.adicionarServicoRemoto(mockServicoRemoto);
		Assertions.assertThrows(ServicoRemotoException.class, () -> caixaEletronico.logar());
	}

	@Test
	void testeServicoRemotoComFalhaPersistirConta() {
		CaixaEletronico caixaEletronico = new CaixaEletronico();
		Hardware mockHardware = new MockHardware();
		caixaEletronico.adicionarHardware(mockHardware);
		ServicoRemoto mockServicoRemoto = new MockServicoRemoto();
		caixaEletronico.adicionarServicoRemoto(mockServicoRemoto);
		caixaEletronico.logar();
		ServicoRemoto mockServicoRemotoComFalha = new MockServicoRemotoComFalha();
		caixaEletronico.adicionarServicoRemoto(mockServicoRemotoComFalha);
		Assertions.assertThrows(ServicoRemotoException.class, () -> caixaEletronico.depositar(10.50));
	}

}
