package control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import utilidades.Searcher;
import utilidades.HerramientasTexto;


public class Mainclaina {

	public static void main(String[] args) throws IOException {
    		
		/** PRUEBA DE METODO SEARCHER
		
		Searcher searchEngine = new Searcher();
        String[] matches;
        matches = searchEngine.search(
                "Perro Verde",
               
                "El Perro Verde nace en el año 2005 en colaboración "+
                "de Ángel Lorenzo Cachazo (Martivilli) junto Verde con su"+
                " hijo Javier, con Perro Verde Perro Vila Viniteca. Es uno de los proyectos ");
        searchEngine.printMatches(matches);
	}
	*/
		ArrayList<String> arrayText = new ArrayList<String>();
        String s1;
        String s2;
 
        // Cargamos el buffer con el contenido del archivo
        BufferedReader br = new BufferedReader (new FileReader ("ElQvixote.txt"));
 
        // Leemos la primera linea
        while (br.ready()) {
        	s1 = br.readLine();
        	System.out.println ("texto de cada linea: " + s1);
        	
 
        System.out.println ("La primera linea del archivo es: " + s1);
        System.out.println ("La linea tiene " + s1.length() + " caracteres");
 
        System.out.println ();
        System.out.println ("Separando la linea en trozos tenemos las siguientes palabras:");
 
        int numTokens = 0;
        StringTokenizer st = new StringTokenizer (s1);
 
        // bucle por todas las palabras
        while (st.hasMoreTokens())
        {
            s2 = st.nextToken();
            System.out.println ("    Palabra " + numTokens + " es: " + s2);
            arrayText.add(s2);
            numTokens++;
        }
        System.out.println(" \n\n");
        }
        for (int i =0; i<arrayText.size(); i++){
            System.out.println(arrayText.get(i));
       }
	}
}
