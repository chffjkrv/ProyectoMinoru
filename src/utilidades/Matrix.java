package utilidades;

public class Matrix {
	
	public Matrix() {
		
	}
	/**
	 * 
	 * @param arrIntTxt El array de int que corresponda al txt
	 * @return Una matriz bidimensional del tamaño del int array.
	 */
	public Integer[][] creaMatrix(Integer[] arrIntTxt) {
		
		int tamanio = arrIntTxt.length;		
		Integer[][] MtrxInt = new Integer[tamanio][tamanio];		
		
		return MtrxInt;
		
	}
	
	

}
