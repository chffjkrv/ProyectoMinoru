package utilidades;

import java.util.List;

import java.util.ArrayList;


/**
 * Esta clase es la encargada de generar y manipular matrices.
 * @author Daniel Arroyave
 * @version 18/10/2019
 *
 */
public class Matrix {
	
	static Integer num1;
	static Integer num2;
	static Integer numCell;
	
	
	/**
	 * Constructor vacío.
	 */
	public Matrix() {
		
	}
	
	
	/**
	 * Este método genera una matriz del tamaño del texto.
	 * @param arrTxt El array de int que corresponde a las palabras sin repeticiones.
	 * @return Una matriz bidimensional del tamaño del array que hemos introducido.
	 */
	public static Integer[][] creaMatrix(ArrayList<String> arrTxt) {
		
		int tamanio = arrTxt.size();		
		Integer[][] MtrxInt = new Integer[tamanio][tamanio];		
		
		return MtrxInt;		
	}
	
	
	/**
	 * Con este método inicializaríamos la matriz si fuese necesario, poniendo todos sus valores a 0
	 * @param MtrxInt Es la matriz que queremos inicializar.
	 */
	public static void inicializarMatrix(Integer[][] MtrxInt) {
		for(int f=0;f<MtrxInt.length;f++) {
			for(int c=0;c<MtrxInt.length;c++) {
				MtrxInt[f][c]=0;
			}
		}
	}
	
	
	/**
	 * Este método es de los más importantes del programa, en el se recorre por tuplas el texto convertido a id's y se van reforzando las confluencias.
	 * @param MtrxInt Esta es la matriz vacía que anteriormente hemos creado.
	 * @param arrTxtInteger Este es el array de Integers que equivale al texto.
	 * @return Devuelve la matriz rellena.
	 */
	public static Integer[][] rellenaMatrix(Integer[][] MtrxInt, Integer[] arrTxtInteger) {
		

		Integer num1;
		Integer num2;
		Integer numCell;

		
		for(int x = 0;x<arrTxtInteger.length-1;x++) {

				num1 = arrTxtInteger[x];
				num2 = arrTxtInteger[x+1];
				numCell=MtrxInt[num1][num2];
				if(numCell == null) {
					numCell=0;
				}
				numCell += 1;
				MtrxInt[num1][num2] = numCell;
			
		}
		
		return MtrxInt;
		
	}
	
	
/**
 * En este método normalizamos las columnas de la matriz alimentada.
 * @param MtrxInt Esta es la matriz alimentada.
 * @return Retorna un ArrayList con las normalizaciones de las columnas, equivaliendo ArrayList[0] la primera columna.
 */
	public static ArrayList<Integer> normalizacionPorColumna(Integer[][] MtrxInt){
		
		ArrayList<Integer> sumacolumna = new ArrayList<Integer>();

		
		for(int fil = 0; fil <MtrxInt[0].length; fil++) {
			
			int cell = 0;			
			
			for(int col = 0; col<MtrxInt[0].length ; col++) {
				
				if(MtrxInt[fil][col] != null) {
					 cell +=  MtrxInt[fil][col];		
				}
							 
			}
			
			sumacolumna.add(fil, cell);
		}		
		
		return sumacolumna;
	}
}
	
/**	public static List<List<Integer>> confluencia(Integer[][] MtrxInt, Integer[] arrTxtInteger){

		ArrayList<Integer> posicionesCon = new ArrayList<Integer>();
		List<List<Integer>> listOfLists = new ArrayList<List<Integer>>(); 
		
		for(int x = 0;x<arrTxtInteger.length-1;x++) {

			num1 = arrTxtInteger[x];
			num2 = arrTxtInteger[x+1];
			numCell=MtrxInt[num1][num2];
			ArrayList<Integer>[][] list = new ArrayList[10][10];
			list[0][0] = new ArrayList<>();
				if(numCell>0) {
					posicionesCon.add(numCell);
					posicionesCon.add(num1);
					posicionesCon.add(num2);
				}
		}
		
		return listOfLists;
	}
}
*/