package utilidades;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;

public class EscribeTXT{

	public EscribeTXT(){
	
}
    public static void escribeArrIntEnTXT(Integer[] arrInt, String nombreArchivo) {

        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(nombreArchivo+".txt");
            pw = new PrintWriter(fichero);
     		for (int x =0; x<arrInt.length; x++){
     			pw.println(arrInt[x]);
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
    public static void escribeArrStringEnTXT(String[] arrString, String nombreArchivo) {

        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(nombreArchivo+".txt");
            pw = new PrintWriter(fichero);
     		for (int x =0; x<arrString.length; x++){
     			pw.println(arrString[x]);
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
}
