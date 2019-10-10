package control;

/**import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;*/
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
/**
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import utilidades.Searcher;
*/
import utilidades.EscribeTXT;
import utilidades.Hashmap;
import utilidades.HerramientasTexto;
import utilidades.Matrix;


public class Mainclaina {

	public static void main(String[] args) throws IOException {
		
	
		String texto = "ElQvixote";
		
		ArrayList<String> arrTxt;
		ArrayList<String> arrTxt2;
		HashMap<Integer,String> listaPalabras;
		Hashmap Listpal;
		
		Integer[] arrTxtInteger;
 		Integer[][] MatrizDoble;
 		
 		//Pasamos por arrays el texto para normalizar las palabras.
 		arrTxt = HerramientasTexto.fileToArray(texto+".txt");
 		arrTxt2 = new ArrayList<String>();		
		arrTxt2 = HerramientasTexto.quitarRepeticiones(arrTxt);
		
		//Aqui creamos el HashMap con las palabras y sus correspondientes id.
		Listpal = new Hashmap(); 
		listaPalabras = Listpal.creaHashmap();
		Listpal.llenarHashMap(listaPalabras, arrTxt2);
 		Listpal.mostrarPalabras2(listaPalabras);
 		
 		//Creamos un array que es el texto con las palabras cambiadas por id's.
 		arrTxtInteger = new Integer[arrTxt2.size()];
 		arrTxtInteger = Listpal.arrTxtTOidArrTxt(arrTxt, listaPalabras);

 		//Generacion de Matix.
 		MatrizDoble = Matrix.creaMatrix(arrTxt2);
 		System.out.println(MatrizDoble.length);
 		Matrix.rellenaMatrix(MatrizDoble, arrTxtInteger);
 		ArrayList<Integer> arrNorm = new ArrayList<Integer>();
 		arrNorm = Matrix.normalizacionPorColumna(MatrizDoble);
		
 		//Generamos los documentos .txt
 		EscribeTXT.escribeArrIntEnTXT(arrTxtInteger,texto+"TextoEnNumeros");
 		EscribeTXT.escribeHashMapEnTXT(listaPalabras, texto+"ListaPalabrasID");  
 		EscribeTXT.escribeArrIntEnTXT(MatrizDoble, texto+"Matrix");
 		EscribeTXT.escribeNormalizacionIntEnTXT(arrNorm,texto+"normalizaciones");

 		System.out.println("El texto tiene : "+arrTxt.size()+" palabras");
 		System.out.println("Sin repeticiones son: "+arrTxt2.size()+" palabras");
 		System.out.println("En la normalización se han sumado "+arrNorm.size()+" registros");
 		System.out.println("Ya esta listo");
 		
	}	
} 
