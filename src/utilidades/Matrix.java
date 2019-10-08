package utilidades;

import java.util.List;

import java.util.ArrayList;

public class Matrix {
	
	static Integer num1;
	static Integer num2;
	static Integer numCell;
	private static Integer cell;
	
	public Matrix() {
		
	}
	/**
	 * 
	 * @param arrIntTxt El array de int que corresponda al txt
	 * @return Una matriz bidimensional del tama�o del int array.
	 */
	public static Integer[][] creaMatrix(ArrayList<String> arrTxt) {
		
		int tamanio = arrTxt.size();		
		Integer[][] MtrxInt = new Integer[tamanio][tamanio];		
		
		return MtrxInt;
		
	}
	
	public static void inicializarMatrix(Integer[][] MtrxInt) {
		for(int f=0;f<MtrxInt.length;f++) {
			for(int c=0;c<MtrxInt.length;c++) {
				MtrxInt[f][c]=0;
			}
		}
	}
	
	public static Integer[][] rellenaMatrix(Integer[][] MtrxInt, Integer[] arrTxtInteger) {
		

		Integer num1;
		Integer num2;
		Integer numCell;

		
		for(int x = 0;x<arrTxtInteger.length-1;x++) {

				num1 = arrTxtInteger[x];
				num2 = arrTxtInteger[x+1];
				numCell=MtrxInt[num1][num2];
				numCell += 1;
				MtrxInt[num1][num2] = numCell;
			
		}
		
		return MtrxInt;
		
	}
/**
 * 
 * @param MtrxInt
 * @return 
 */
	public static ArrayList<Integer> normalizacionPorColumna(Integer[][] MtrxInt){
		
		ArrayList<Integer> sumacolumna = new ArrayList<Integer>();

		
		for(int col = 0; col <MtrxInt[0].length ; col++) {
			
			int cell = 0;			
			
			for(int fil = 0; fil<MtrxInt[0].length ; fil++) {
				
				 cell +=  MtrxInt[col][fil];
				 
			}
			
			sumacolumna.add(col, cell);
		}		
		
		return sumacolumna;
	}
	
	public static List<List<Integer>> confluencia(Integer[][] MtrxInt, Integer[] arrTxtInteger){

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
