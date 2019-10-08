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
 /**
  * Este metodo rellena un HashMap (lista) con las palabras del arrtxt2(String[] normalizado y sin repeticiones)
  * creando para cada una, un id numerico.
  * @param lista
  * @param arrtxt2
  */
   public void llenarHashMap(HashMap <Integer,String> lista, ArrayList<String> arrtxt2 ) {
	 
	   Hashmap Listpal = new Hashmap();
		for (int x =0; x<arrtxt2.size(); x++){
			Listpal.guardarPalabra(x, arrtxt2.get(x), lista);
		}   
   }
/**
 * Sirve para modificar alguna palabra dado un Id.
 * @param codigo
 * @param listaPalabras
 */
   public  void modificaPalabra(Integer codigo, HashMap<Integer,String> listaPalabras){
	    Scanner sc = new Scanner(System.in);
	    if (listaPalabras.containsKey(codigo)) {
	        System.out.println("Introduce la palabra que quieras que tenga este codigo:");
	        listaPalabras.put(codigo, sc.next());
	    } else {
	        System.out.println("No hay ninguna Palabra con ese codigo.");
	    }
	}
/**
 * Lista las palabras por pantalla.
 * @param listaPalabras
 */
   public  void mostrarPalabras(HashMap<Integer, String> listaPalabras) {
	    Integer clave;
	    Iterator<Integer> Palabras = listaPalabras.keySet().iterator();
	    System.out.println("Hay los siguientes Palabras:");
	    while(Palabras.hasNext()){	
	        clave = Palabras.next();
	        System.out.println(clave + " - " + listaPalabras.get(clave));
	    }
	}
/**
 * Lista las palabras por pantalla creando un entrySet() y recogiendo las claves y los valores.
 * @param listaPalabras
 */
   public  void mostrarPalabras2(HashMap<Integer, String> listaPalabras) {
	    Iterator iterador = listaPalabras.entrySet().iterator();

	    Map.Entry Palabra;
	    while (iterador.hasNext()) {
	        Palabra = (Map.Entry) iterador.next();
	        System.out.println(Palabra.getKey() + " - " + Palabra.getValue());
	    }
	}
/**
 * Aqui dada una palabra, se crea un entrySet() y se itera sobre el HashMap buscando esta palabra para recoger su id.
 * @param listaPalabras
 * @param pal
 * @return Id de la palabra introducida.
 */
   public Integer damelId(HashMap<Integer, String> listaPalabras, String pal) {
	    
	   Iterator iterador = listaPalabras.entrySet().iterator();
	   Integer id = null;
	   	Boolean para = false;
	    Map.Entry Palabra;
	    while (iterador.hasNext()) {
	        Palabra = (Map.Entry) iterador.next();
 	        if(Palabra.getValue().equals(pal)) {
	         id = (Integer)Palabra.getKey();
	        }
	    }
	    return id;
	}
/**
 * Con este metodo
 * @param codigo
 * @param listaPalabras
 */
   public  void eliminaPalabra(Integer codigo, HashMap<Integer,String> listaPalabras) {
	    if (listaPalabras.containsKey(codigo)) {
	        listaPalabras.remove(codigo);
	    } else {
	        System.out.println("No hay ninguna palabra con ese codigo.");
	    }
	}

   public Integer[] arrTxtTOidArrTxt(ArrayList<String> arrTxt, HashMap<Integer, String> listaPalabras) {
	   Integer[] intArrtxt = new Integer[arrTxt.size()];
	   Integer intAux = null;
	   String palAux;
	   
	   for(int i=0;i<arrTxt.size();i++) {
		 palAux = arrTxt.get(i);  
		 intAux = damelId(listaPalabras,palAux);
		 intArrtxt[i]=intAux;
	   }

	   return intArrtxt;
   }
}
