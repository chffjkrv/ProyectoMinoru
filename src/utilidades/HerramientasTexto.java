package utilidades;

import java.io.*;
import java.text.Normalizer;
import java.util.*;
import java.lang.String;

public class HerramientasTexto {
	
	public HerramientasTexto() {
		
	}

	public static String normalizaString(String plbr) {
		
	    String limpio =null;
	    if (plbr !=null) {
	    	limpio = plbr;
	        // Normalizar texto para eliminar acentos, dieresis, cedillas y tildes
	        limpio = Normalizer.normalize(limpio, Normalizer.Form.NFD);
	        // Quitar caracteres no ASCII.
	        // Poner en minusculas.
	        limpio = limpio.toLowerCase();
	        limpio = limpio.replaceAll("[^\\p{ASCII}]", "");
	        // Quitar cualquier tipo de puntuación aderida a la palabra
	        limpio = limpio.replaceAll("\\p{Punct}","");	        
	    }
	    return limpio;
	}
	
	public static ArrayList<String> fileToArray(String pathText) throws IOException  {

		ArrayList<String> arrayText = new ArrayList<String>();
        String s1;
        String s2;
        try {
        // Cargamos el buffer con el contenido del archivo
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(pathText), "utf-8"));
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
	
	public static ArrayList<String> quitarRepeticiones(ArrayList<String> arrText){
		
		ArrayList<String> arrText2 = (ArrayList<String>)arrText.clone();
		
		Set<String> hs = new HashSet<>();
		hs.addAll(arrText2);
		arrText2.clear();
		arrText2.addAll(hs);
		
		return arrText2;
		
	}
	
}






















