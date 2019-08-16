package control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import utilidades.Searcher;
import utilidades.Hashmap;
import utilidades.HerramientasTexto;


public class Mainclaina {

	public static void main(String[] args) throws IOException {


		ArrayList<String> arrTxt = HerramientasTexto.fileToArray("BIBLIACOMPLETA.txt");
		ArrayList<String> arrTxt2 = new ArrayList<String>();

		arrTxt2 = HerramientasTexto.quitarRepeticiones(arrTxt);

		for (int x =0; x<arrTxt2.size(); x++){
    	    System.out.println(arrTxt2.get(x));
		}
		 HashMap<Integer,String> listaPalabras;

		Hashmap Listpal = new Hashmap();

		listaPalabras = Listpal.creaHashmap();
		Listpal.llenarHashMap(listaPalabras, arrTxt2);
 		Listpal.mostrarPalabras2(listaPalabras);
    	
		System.out.println("Primer array: "+arrTxt.size()+"\n");
		System.out.println("Segundo array sin repes: "+arrTxt2.size());
		

		
	}
}
