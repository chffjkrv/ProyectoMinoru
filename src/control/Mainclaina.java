package control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


import utilidades.Searcher;
import utilidades.Hashmap;
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
	
		ArrayList<String> arrTxt = HerramientasTexto.fileToArray("SunenCríticasLiterarias.txt");
		System.out.println(arrTxt.size());
		for (int x =0; x<arrTxt.size(); x++){
    	    System.out.println(arrTxt.get(x));
    	} 


	}
}
