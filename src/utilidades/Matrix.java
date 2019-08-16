package utilidades;

import java.util.ArrayList;

public class Matrix {
	
	public Matrix() {
		
	}
	/**
	 * 
	 * @param arrIntTxt El array de int que corresponda al txt
	 * @return Una matriz bidimensional del tamaño del int array.
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
	
	

}
