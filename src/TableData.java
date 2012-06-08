import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTree;


// include tree data
public class TableData {
		public TableData(){
			isExpand = false;
		}
		JTree tree;
		JTreeController jc;
		MatrixModel mx;
		JTable table;
		JList rowheader;
		mainViewer mv;
		int[][] data;
		String[] title;
		MatrixController mc;

		boolean isExpand;
}
