import java.util.Arrays;
import java.util.List;

/**
 * @author renanalencar
 *
 */
public class StringsCamelCase {

	public static List<String> converterCamelCase(String original) {
		
		if (!original.matches("[a-zA-Z0-9.]*")) {
			throw new StringContemCaractereEspecialException(
					"Inválido! Caracteres especiais não são permitidos, somente letras e números.");
		}
		if (original.matches("^([0-9])\\w+")) {
			throw new StringIniciaNumeroException("Inválido! Não deve começar com números.");
		}
		
		String[] palavras = original.split("(?<=[a-z])(?=[A-Z])|(?<=[A-Z])(?=[A-Z][a-z])|(?<=[0-9])(?=[A-Z][a-z])|(?<=[a-zA-Z])(?=[0-9])");

		return Arrays.asList(palavras);
	}

}
