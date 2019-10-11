package utilidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * Esta clase es la encargada de proveer los métodos con los cuales haremos el tratamiento del HashMap.
 * @author Daniel Arroyave
 * @version 08/10/2019
 */
public class Hashmap {

   private Scanner sc;
   
   
 /**
  * Constructor vacío
  */
public Hashmap() {

   }


/**
 * Este método te devuelve un HashMap vació cuando es llamado.
 * @return retorna un HashMap clave Integer, valor String.
 */
   public  HashMap<Integer,String> creaHashmap() {
	   HashMap<Integer,String> listaPalabras = new HashMap<Integer,String>();
	   return listaPalabras;
   }

   
   /**
    * Este método nos instroducirá nuevas palabras en el HashMap
    * @param codigo Es el Integer con el numero de id de la palabra.
    * @param palabra Es el String con la palabra que deseamos introducir.
    * @param listaPalabras Es el HashMap donde deseamos introducir la nueva palabra.
    */
   public void guardarPalabra(Integer codigo, String palabra, HashMap <Integer,String> listaPalabras){
	    if (listaPalabras.containsKey(codigo)) {
	        System.out.println("No se puede introducir el Palabra. El codigo esta repetido.");
	    } else {
	        listaPalabras.put(codigo, palabra);
	    }
	}
   
   
 /**
  * Este metodo rellena un HashMap con las palabras del array que contiene las todas las palabras sin repeticiones del texto, creando para cada una un id autonumérico.
  * @param lista Aqui le pasamos el HashMap ya creado pero vacío.
  * @param arrtxt2 Es el ArrayList que contiene las palabras sin repeticiones.
  */
   public void llenarHashMap(HashMap <Integer,String> lista, ArrayList<String> arrtxt2 ) {
	 
	   Hashmap Listpal = new Hashmap();
		for (int x =0; x<arrtxt2.size(); x++){
			Listpal.guardarPalabra(x, arrtxt2.get(x), lista);
		}   
   }
   
   
/**
 * Este método sirve para modificar alguna palabra dado un Id.
 * @param codigo Es el Integer con el código de la palabra que queramos modificar.
 * @param listaPalabras Es el HashMap en el cual queremos hacer la modificación.
 */
   public  void modificaPalabra(Integer codigo, HashMap<Integer,String> listaPalabras){
	    try{
	    	sc = new Scanner(System.in);
	    
	    if (listaPalabras.containsKey(codigo)) {
	        System.out.println("Introduce la palabra que quieras que tenga este codigo:");
	        listaPalabras.put(codigo, sc.next());
	    } else {
	        System.out.println("No hay ninguna Palabra con ese codigo.");
	    }
	    }catch(Exception e ){
	    	e.getStackTrace();
	    }
	    
	}
/**
 * Este método nos muestra por pantalla el contenido del HashMap, este método puede ser reutilizado en un futuro si fuese necesario escribirlo en un fichero.
 * @param listaPalabras Es el HashMap que queremos escribir en pantalla.
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
 *Este método nos muestra por pantalla el contenido del HashMap, pero a diferencia del anterior lo hace usando un iterador.
 * @param listaPalabras Es el HashMap que queremos escribir en pantalla.
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
 * Este metodo es un get con el cual podemos obtener el id dada una palabra.
 * @param listaPalabras Es el Hashmap que queremos analizar.
 * @param pal Es la palabra sobre la cual queremos conocer el id.
 * @return Retorna el id de la palabra introducida.
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
 * Con este metodo eliminamos una palabra del HashMap.
 * @param codigo Es el código de la palabra que queremos eliminar, si no lo conocemos lo obtendremos a traves del método anterior.
 * @param listaPalabras Es el Hashmap que queremos analizar.
 */
   public  void eliminaPalabra(Integer codigo, HashMap<Integer,String> listaPalabras) {
	    if (listaPalabras.containsKey(codigo)) {
	        listaPalabras.remove(codigo);
	    } else {
	        System.out.println("No hay ninguna palabra con ese codigo.");
	    }
	}

   /**
    * Con este método creamos un array de Integers, el cual contiene el texto pero en lugar de palabras estarán sus correspondientes id's.
    * @param arrTxt Es el ArrayList que contiene el texto.
    * @param listaPalabras Es el HashMap que contiene las palabras y sus id's.
    * @return Retorna un array de Integers.
    */
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
