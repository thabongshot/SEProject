import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class JTreeController {

	JTree tree;
	DefaultMutableTreeNode root;
	JTreeData jd;
	TreeUpActionHandler handler;
	DefaultTreeModel jm;
	int nodenum;
	

	public TreeUpActionHandler getTreeUpActionHandler(){
		JOptionPane.showMessageDialog(null, "DEBUG :: getTreeUpCont");
		return null; //new TreeUpActionHandler(tree);
	}

	public JTreeController(JTree tree) {
		this.tree = tree;
		jd = new JTreeData();
		nodenum = 1;
		tree.setModel(JTreeMake());

	}

	public JTreeController(String[] title, JTree tree) {
		jd = new JTreeData(title);
		this.tree = tree;
		nodenum = title.length;
		this.tree.setModel(JTreeMake(title));
	}

	public void setJtreeData(String[] nodename) {
		jd.setJTreeData(nodename);
		nodenum = nodename.length;
		tree.setModel(JTreeMake(nodename));
	}
		

	public DefaultTreeModel JTreeMake() {
		root = new DefaultMutableTreeNode("root");
		jm = new DefaultTreeModel(root);
		jm.setRoot(root);
		return jm;
	}

	public DefaultTreeModel JTreeMake(String[] childnode) {
		root = new DefaultMutableTreeNode("$root");
		jm = new DefaultTreeModel(root);
		jm.setRoot(root);
		for (int i = 0; i < nodenum; i++) {
			// DefaultMutableTreeNode child = new
			// DefaultMutableTreeNode(childnode[i]);
			jm.insertNodeInto(new DefaultMutableTreeNode(childnode[i]), root, root.getChildCount());
		}

		return jm;

	}

	public JTree getJTree() {
		return this.tree;
	}
}

