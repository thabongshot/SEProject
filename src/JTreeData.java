import javax.swing.JOptionPane;

public class JTreeData {

	String[] nodename;

	public JTreeData() {
		nodename = new String[1];
		nodename[0] = "root";
	}

	public JTreeData(String[] nodename) {
		this.nodename = nodename;
	}

	public void setJTreeData(String[] nodename) {

		this.nodename = nodename;
	}
}
