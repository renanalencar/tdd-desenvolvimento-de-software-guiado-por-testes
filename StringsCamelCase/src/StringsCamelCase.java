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
					"Inv�lido! Caracteres especiais n�o s�o permitidos, somente letras e n�meros.");
		}
		if (original.matches("^([0-9])\\w+")) {
			throw new StringIniciaNumeroException("Inv�lido! N�o deve come�ar com n�meros.");
		}
		
		String[] palavras = original.split("(?<=[a-z])(?=[A-Z])|(?<=[A-Z])(?=[A-Z][a-z])|(?<=[0-9])(?=[A-Z][a-z])|(?<=[a-zA-Z])(?=[0-9])");

		return Arrays.asList(palavras);
	}

}
