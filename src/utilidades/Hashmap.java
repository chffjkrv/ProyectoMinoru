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
/**
 * 
 * @return retorna un HashMap clave Integer, valor String.
 */
   public  HashMap<Integer,String> creaHashmap() {
	   HashMap<Integer,String> listaPalabras = new HashMap<Integer,String>();
	   return listaPalabras;
   }

   public void guardarPalabra(Integer codigo, String palabra, HashMap <Integer,String> listaPalabras){
	    if (listaPalabras.containsKey(codigo)) {
	        System.out.println("No se puede introducir el Palabra. El codigo esta repetido.");
	    } else {
	        listaPalabras.put(codigo, palabra);
	    }
	}
   
   public void llenarHashMap(HashMap <Integer,String> lista, ArrayList<String> arrtxt2 ) {
	 
	   Hashmap Listpal = new Hashmap();
		for (int x =0; x<arrtxt2.size(); x++){
			Listpal.guardarPalabra(x, arrtxt2.get(x), lista);
		}   
   }

   public  void modificaPalabra(Integer codigo, HashMap<Integer,String> listaPalabras){
	    Scanner sc = new Scanner(System.in);
	    if (listaPalabras.containsKey(codigo)) {
	        System.out.println("Introduce la palabra que quieras que tenga este codigo:");
	        listaPalabras.put(codigo, sc.next());
	    } else {
	        System.out.println("No hay ninguna Palabra con ese codigo.");
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
   public Integer damelId(HashMap<Integer, String> listaPalabras, String pal) {
	    
	   Iterator iterador = listaPalabras.entrySet().iterator();
	   Integer id;
	   
	    Map.Entry Palabra;
	    while (iterador.hasNext()) {
	        Palabra = (Map.Entry) iterador.next();
	        id = Palabra.getKey();
	        String palInterna = (String)Palabra.getValue());
	    }
	    return id;
	}

   public  void eliminaPalabra(Integer codigo, HashMap<Integer,String> listaPalabras) {
	    if (listaPalabras.containsKey(codigo)) {
	        listaPalabras.remove(codigo);
	    } else {
	        System.out.println("No hay ninguna palabra con ese codigo.");
	    }
	}

   public Integer[] arrTxtTOidArrTxt(ArrayList<String> arrTxt) {
	   Integer[] intArrtxt = new Integer[arrTxt.size()];
	   
	   for(int i=0;i<arrTxt.size();i++) {
		   
	   }

	   return intArrtxt;
   }
}
