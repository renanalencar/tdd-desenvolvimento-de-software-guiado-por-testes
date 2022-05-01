import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author renanalencar
 *
 */
public class TesteStringsCamelCase {

	@Test
	public void testeConverterCameCase1() {
		List<String> palavras = new ArrayList<>();
		palavras = StringsCamelCase.converterCamelCase("nome");
		Assertions.assertEquals("nome", palavras.get(0));
	}

	@Test
	public void testeConverterCameCase2() {
		List<String> palavras = new ArrayList<>();
		palavras = StringsCamelCase.converterCamelCase("Nome");
		Assertions.assertEquals("Nome", palavras.get(0));
	}

	@Test
	public void testeConverterCameCase3() {
		List<String> palavras = new ArrayList<>();
		palavras = StringsCamelCase.converterCamelCase("nomeComposto");
		Assertions.assertEquals("nome", palavras.get(0));
		Assertions.assertEquals("Composto", palavras.get(1));
	}
	
	@Test
	public void testeConverterCameCase4() {
		List<String> palavras = new ArrayList<>();
		palavras = StringsCamelCase.converterCamelCase("NomeComposto");
		Assertions.assertEquals("Nome", palavras.get(0));
		Assertions.assertEquals("Composto", palavras.get(1));
	}

	@Test
	public void testeConverterCameCase5() {
		List<String> palavras = new ArrayList<>();
		palavras = StringsCamelCase.converterCamelCase("CPF");
		Assertions.assertEquals("CPF", palavras.get(0));
	}

	@Test
	public void testeConverterCameCase6() {
		List<String> palavras = new ArrayList<>();
		palavras = StringsCamelCase.converterCamelCase("numeroCPF");
		Assertions.assertEquals("numero", palavras.get(0));
		Assertions.assertEquals("CPF", palavras.get(1));
	}

	@Test
	public void testeConverterCameCase7() {
		List<String> palavras = new ArrayList<>();
		palavras = StringsCamelCase.converterCamelCase("numeroCPFContribuinte");
		Assertions.assertEquals("numero", palavras.get(0));
		Assertions.assertEquals("CPF", palavras.get(1));
		Assertions.assertEquals("Contribuinte", palavras.get(2));
	}

	@Test
	public void testeConverterCameCase8() {
		List<String> palavras = new ArrayList<>();
		palavras = StringsCamelCase.converterCamelCase("recupera10Primeiros");
		Assertions.assertEquals("recupera", palavras.get(0));
		Assertions.assertEquals("10", palavras.get(1));
		Assertions.assertEquals("Primeiros", palavras.get(2));
	}

	@Test
	public void testeConverterCameCase9() {
		Assertions.assertThrows(StringIniciaNumeroException.class,
				() -> StringsCamelCase.converterCamelCase("10Primeiros"));
	}

	@Test
	public void testeConverterCameCase10() {
		Assertions.assertThrows(StringContemCaractereEspecialException.class,
				() -> StringsCamelCase.converterCamelCase("nome#Composto"));
	}

}
