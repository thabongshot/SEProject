import javax.swing.JOptionPane;

public class MatrixData {

	int[][] data;
	String[] title;

	public MatrixData() {
		data = new int[1][1];
		data[0][0] = 0;

		title = new String[1];
		title[0] = " ";
	}

	public void setMatrix(int[][] resource) {

		data = resource;
	

	}
	public int[][] getMatrix(){
		return data;
	}

	/*
	 * public void Group(String [] input){
	 * 
	 * for(k=0; k<data.length; k++){ if(data[k] == "</group>"){
	 * data[k]=group[count]; count++; } else data[k]=group[count]; } }
	 */
}
