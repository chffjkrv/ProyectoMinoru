package utilidades;

import java.io.File;
import java.io.*;
import java.util.*;
import java.io.IOException;

public class HerramientasTexto {
	
	public HerramientasTexto() {
		
	}
	
	public static void fileToArray() throws IOException  {

		        String s1;
		        String s2;
		 
		        // Cargamos el buffer con el contenido del archivo
		        try {
		        BufferedReader br = new BufferedReader (new FileReader ("/HailYoMismo/src/textos/pruebota1.txt"));
		        // Leemos la primera linea
		        s1 = br.readLine();
		 
		        System.out.println ("La primera linea del archivo es: " + s1);
		        System.out.println ("La linea tiene " + s1.length() + " caracteres");
		 
		        System.out.println ();
		        System.out.println ("Separando la linea en trozos tenemos las siguientes palabras:");
		 
		        int numTokens = 0;
		        StringTokenizer st = new StringTokenizer (s1);
		 
		        // bucle por todas las palabras
		        while (st.hasMoreTokens())
		        {
		            s2 = st.nextToken();
		            numTokens++;
		            System.out.println ("    Palabra " + numTokens + " es: " + s2);
		        
		        }
		        try{                    
		            if( null != br ){   
		               br.close();     
		            }                  
		         }catch (Exception e2){ 
		            e2.printStackTrace();
		         } 
		        } catch(IOException e) {
			        	e.getMessage();
			        	System.out.println("NIEEET");
			        } 		
	}

}
