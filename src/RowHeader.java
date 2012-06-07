import javax.swing.AbstractListModel;
import javax.swing.ListModel;

public class RowHeader {
	ListModel lm;

	public RowHeader(){
		lm = new AbstractListModel(){

			@Override
			public Object getElementAt(int index) {
				// TODO Auto-generated method stub
				return (index+1) + "  " +"$root  ";
			}

			@Override
			public int getSize() {
				// TODO Auto-generated method stub
				return 1;
			}};
	}
	public RowHeader(final String[] title) {

		lm = new AbstractListModel() {

			String headers[] = title;

			@Override
			public Object getElementAt(int index) {
				// TODO Auto-generated method stub
				return (index+1) + "    " + headers[index];
			}

			@Override
			public int getSize() {
				// TODO Auto-generated method stub
				return headers.length;
			}

		};
	}
}
