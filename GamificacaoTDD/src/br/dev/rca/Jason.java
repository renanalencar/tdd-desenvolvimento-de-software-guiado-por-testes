/**
 * 
 */
package br.dev.rca;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

/**
 * @author renan
 *
 */
public class Jason {

	public static void gravarEmArquivo(String arquivo, Map<String, Map<String, String>> placares) {		
		try {
			Gson gson = new Gson();
	
			Writer writer = Files.newBufferedWriter(Paths.get(arquivo));
			gson.toJson(placares, writer);
	
			writer.close();
		} catch (IOException e) {
	
			e.printStackTrace();
		}
	}

	public static Map<String, Map<String, String>> lerDeArquivo(String arquivo) {
		Map<String, Map<String, String>> resultado = new HashMap<>();
		
		try {
			Gson gson = new Gson();
	
			Reader reader = Files.newBufferedReader(Paths.get(arquivo));
			resultado = gson.fromJson(reader, Map.class);
			reader.close();
		} catch (IOException e) {
	
			e.printStackTrace();
		}
		return resultado;
	}

}
