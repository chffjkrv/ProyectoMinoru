package utilidades;

import java.io.*;
import java.text.Normalizer;
import java.util.*;
import java.lang.String;
/**
 * Esta clase es la encargada de proporcionarlos las herramientas para poder manipular correctamente el texto.
 * @author Daniel Arroyave
 * @version 08/10/2019 
 */
public class HerramientasTexto {
	
	private static BufferedReader br;
	public HerramientasTexto() {
		
	}
	
	
/**
 * Con este metodo normalizamos el texto a ASCII, retiramos puntuación y ponemos todo en minúsculas.
 * @param plbr Esta es la palabra que deseamos normalizar gramaticalmente.
 * @return Devuelve la palabra noromalizada.
 */
	public static String normalizaString(String plbr) {
		
	    String limpio =null;
	    if (plbr !=null) {
	    	limpio = plbr;
	        // Normalizar texto para eliminar acentos, dieresis, cedillas y tildes

	        limpio = Normalizer.normalize(limpio, Normalizer.Form.NFD).toLowerCase().replaceAll("[^\\p{ASCII}]", "").replaceAll("\\p{Punct}","");
	        // Quitar caracteres no ASCII.
	        // Poner en minusculas.
	    }
	    return limpio;
	}
	
	
	/**
	 * Este método pasa a un array de String todo el texto
	 * @param pathText Esta es la ruta de la ubiación del archivo .txt
	 * @return Devuelve un ArrayList con el texto.
	 * @throws IOException Capturamos el mensaje de error al abrir el fichero, si lo hubiese.
	 */
	public static ArrayList<String> fileToArray(String pathText) throws IOException  {

		ArrayList<String> arrayText = new ArrayList<String>();
        String s1;
        String s2;
        try {
        br = new BufferedReader(new InputStreamReader(new FileInputStream(pathText), "utf-8"));
        // Leemos la primera linea
        while (br.ready()) {
        	s1 = br.readLine();
       StringTokenizer st = new StringTokenizer (s1);
        // bucle por todas las palabras
        	while (st.hasMoreTokens())
        	{
       			s2 = st.nextToken();
       			s2 = normalizaString(s2);
        		arrayText.add(s2);
        	}    	
        }
        }catch(IOException e) {
        	e.getMessage();
        }
        
		return arrayText;	
		
		
	}
	/**
	 * Este método crea un ArrayList que contiene el texto sin palabras repetidas,
	 * @param arrText Este es el ArrayList que contiene el texto.
	 * @return Devuelve un Arraylist con el texto ordenado alfanumericamente y sin repeticiones en las palabras y numeros.
	 */
	public static ArrayList<String> quitarRepeticiones(ArrayList<String> arrText){
		
		ArrayList<String> arrText2 = (ArrayList<String>)arrText.clone();
		
		Set<String> hs = new HashSet<>();
		hs.addAll(arrText2);
		arrText2.clear();
		arrText2.addAll(hs);
		arrText2.sort(null);
		
		return arrText2;
		
	}
	
}
