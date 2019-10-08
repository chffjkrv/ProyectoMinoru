package utilidades;

import java.io.*;
import java.text.Normalizer;
import java.util.*;
import java.lang.String;

public class HerramientasTexto {
	
	private static BufferedReader br;
	public HerramientasTexto() {
		
	}
/**
 * 
 * @param plbr
 * @return Devuelve la palabra noromalizada en ASCII.
 */
	public static String normalizaString(String plbr) {
		
	    String limpio =null;
	    if (plbr !=null) {
	    	limpio = plbr;
	        // Normalizar texto para eliminar acentos, dieresis, cedillas y tildes

	        limpio = Normalizer.normalize(limpio, Normalizer.Form.NFD).toLowerCase().replaceAll("[^\\p{ASCII}]", "").replaceAll("\\p{Punct}","");
	        // Quitar caracteres no ASCII.
	        // Poner en minusculas.
	      /**  limpio = limpio.toLowerCase();
=======
	        limpio = Normalizer.normalize(limpio, Normalizer.Form.NFD);
	        // Poner en minusculas.
	        limpio = limpio.toLowerCase();
	        // Quitar caracteres no ASCII.
>>>>>>> 5940ddda10f3e3dafa5fa9b632f1a46d03eadb5b
	        limpio = limpio.replaceAll("[^\\p{ASCII}]", "");
	        // Quitar cualquier tipo de puntuaci�n aderida a la palabra
	        limpio = limpio.replaceAll("\\p{Punct}","");	   
	        */     
	    }
	    return limpio;
	}
	/**
	 * 
	 * @param pathText
	 * @return Devuelve un ArrayList con el texto del fichero del path quie pasamos como parametro.
	 * @throws IOException
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
	 * 
	 * @param arrText
	 * @return Devuelve un String[] del texto ordenado alfanumericamente y sin repeticiones en las palabras y numeros.
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






















