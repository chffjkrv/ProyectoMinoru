package utilidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import java.util.HashMap;
import java.util.Map;


public class Hashmap {

   public Hashmap() {

   }

   public  HashMap<Integer,String> creaHashmap() {
	   HashMap<Integer,String> listaPalabras = new HashMap<Integer,String>();
	   return listaPalabras;
   }

   public void guardarPalabra(Integer codigo, String palabra, HashMap <Integer,String> listaPalabras){
	    if (listaPalabras.containsKey(codigo)) {
	        System.out.println("No se puede introducir el Palabra. El c�digo esta repetido.");
	    } else {
	        listaPalabras.put(codigo, palabra);
	    }
	}

   public  void modificaPalabra(Integer codigo, HashMap<Integer,String> listaPalabras){
	    Scanner sc = new Scanner(System.in);
	    if (listaPalabras.containsKey(codigo)) {
	        System.out.println("Introduce la palabra que quieras que tenga este codigo:");
	        listaPalabras.put(codigo, sc.next());
	    } else {
	        System.out.println("No hay ninguna Palabra con ese c�digo.");
	    }
	}

   public  void mostrarPalabras(HashMap<Integer, String> listaPalabras) {
	    Integer clave;
	    Iterator<Integer> Palabras = listaPalabras.keySet().iterator();
	    System.out.println("Hay los siguientes Palabras:");
	    while(Palabras.hasNext()){
	        clave = Palabras.next();
	        System.out.println(clave + " - " + listaPalabras.get(clave));
	    }
	}

   public  void mostrarPalabras2(HashMap<Integer, String> listaPalabras) {
	    Iterator iterador = listaPalabras.entrySet().iterator();

	    Map.Entry Palabra;
	    while (iterador.hasNext()) {
	        Palabra = (Map.Entry) iterador.next();
	        System.out.println(Palabra.getKey() + " - " + Palabra.getValue());
	    }
	}

   public  void eliminaPalabra(Integer codigo, HashMap<Integer,String> listaPalabras) {
	    if (listaPalabras.containsKey(codigo)) {
	        listaPalabras.remove(codigo);
	    } else {
	        System.out.println("No hay ningun Palabra con ese c�digo.");
	    }
	}

   public Integer[] arrTxtTOidArrTxt(ArrayList<String> arrTxt) {
	   Integer[] intArrtxt = new Integer[arrTxt.size()];
	   for(int i=0;i<arrTxt.size();i++) {

	   }

	   return intArrtxt;
   }
}
