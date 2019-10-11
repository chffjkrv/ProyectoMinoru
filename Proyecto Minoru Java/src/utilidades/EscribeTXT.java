package utilidades;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
/**
 * Esta clase es la encargada de proveer los métodos con los cuales crearemos y escribiremos los resultados de obtenidos.
 * @author Daniel Arroyave
 * @version 08/10/2019
 */
public class EscribeTXT{

	
	public EscribeTXT() {
		
	}
	
	/**
	 * Método para crear y escribir un fichero que contienga un array.
	 * @param arrInt Es el array que queremos escribir en el fichero.
	 * @param nombreArchivo Es el nombre (String) que queremos poner al fichero.
	 */
    public static void escribeArrIntEnTXT(Integer[] arrInt, String nombreArchivo) {
    	
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(nombreArchivo+".txt");
            pw = new PrintWriter(fichero);
     		for (int x =0; x<arrInt.length; x++){
     			pw.print(arrInt[x]+" ");
    		}
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }

    
    /**
	 * Método para crear y escribir un fichero que contienga un ArrayList.
	 * @param listaConfluencias Es el ArrayList que queremos escribir en el fichero.
	 * @param nombreArchivo Es el nombre (String) que queremos poner al fichero.
	 */
    public static void escribeArrListIntEnTXT(ArrayList<Integer> listaConfluencias, String nombreArchivo) {
    	
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(nombreArchivo+".txt");
            pw = new PrintWriter(fichero);
     		for (int f =0; f<listaConfluencias.size(); f++){
     			pw.print(listaConfluencias.get(f)+", ");
    		}
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
    
    /**
	 * Método para crear y escribir un fichero que contienga el ArrayList con las normalizaciones de las columnas.
	 * @param normalizaciones Es el ArrayList que queremos escribir en el fichero.
	 * @param nombreArchivo Es el nombre (String) que queremos poner al fichero.
	 */   
    public static void escribeNormalizacionIntEnTXT(ArrayList<Integer> normalizaciones, String nombreArchivo) {
		
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(nombreArchivo+".txt");
            pw = new PrintWriter(fichero);
     		pw.print(Arrays.toString(normalizaciones.toArray()));
     		
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
    
    
    @Override
	public String toString() {
		return "EscribeTXT []";
	}
    
    /**
	 * Método para crear y escribir un fichero que contienga por ejemplo un texto.
	 * @param arrString Es el array de String que queremos escribir en el fichero.
	 * @param nombreArchivo Es el nombre (String) que queremos poner al fichero.
	 */
	public static void escribeArrStringEnTXT(String[] arrString, String nombreArchivo) {
		
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(nombreArchivo+".txt");
            pw = new PrintWriter(fichero);
     		for (int x =0; x<arrString.length; x++){
     			pw.print(arrString[x]+",");
    		}
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
    
	/**
	 * Método para crear y escribir un fichero que contienga el id de las palabras y las palabras en si, con un hashmap (clave, valor)
	 * @param listaPalabras Es el hasmap que queremos escribir en el fichero.
	 * @param nombreArchivo Es el nombre (String) que queremos poner al fichero.
	 */
    public static void escribeHashMapEnTXT(HashMap<Integer, String> listaPalabras, String nombreArchivo) {
    	    	
        FileWriter fichero = null;
        PrintWriter pw = null;
	    Integer clave;
	    Iterator<Integer> Palabras = listaPalabras.keySet().iterator();
        try
        {
            fichero = new FileWriter(nombreArchivo+".txt");
            pw = new PrintWriter(fichero);
    	    while(Palabras.hasNext()){	
    	        clave = Palabras.next();
    	        pw.println(clave + " - " + listaPalabras.get(clave));
    	    }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
    
    /**
	 * Método para crear y escribir un fichero que contienga la matriz con la que trabajaremos.
	 * @param MatrizDoble Es la matriz que queremos escribir en el fichero.
	 * @param nombreArchivo Es el nombre (String) que queremos poner al fichero.
	 */
    public static void escribeArrIntEnTXT(Integer[][] MatrizDoble, String nombreArchivo) {
       	
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(nombreArchivo+".txt");
            pw = new PrintWriter(fichero);
     		for(int f=0;f<MatrizDoble.length;f++) {

    			for(int c=0;c<MatrizDoble.length;c++) {
    				pw.print(MatrizDoble[f][c]+" ");
    			}
    			pw.print("\n");
    		}
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
}

