package utilidades;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
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

