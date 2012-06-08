import java.awt.event.*;
import java.io.*;

import javax.swing.*;


public class OpenButtonListener extends JFrame  implements ActionListener {

	JFileChooser openfile = new JFileChooser();
	
	TableData tbdata;


	public OpenButtonListener(TableData tbdata) {
		// TODO Auto-generated constructor stub
		this.tbdata = tbdata;
	}


	// �޴����� ���� Ŭ�������� �̺�Ʈ ó��
	public void actionPerformed(ActionEvent e) {
		int re = openfile.showOpenDialog(this); // ���Ͽ��� ���̾�α� â�� ����
		if (re == JFileChooser.APPROVE_OPTION) {

			File file_open = openfile.getSelectedFile(); // ������ ���ϸ��� �����´�

			DsmData(file_open);

		}
	}

	public void DsmData(File dsm) {

		File file_open = openfile.getSelectedFile(); // ������ ���ϸ��� �����´�

		FileInputStream fis;
		BufferedInputStream bis;
		BufferedReader in;
		
		// for debug
		JOptionPane.showMessageDialog(null, "DEBUG :: file read function");
		
		try {

			fis = new FileInputStream(file_open); // FileInputStream��ü�� �����ϰ�
			bis = new BufferedInputStream(fis);
			in = new BufferedReader(new InputStreamReader(bis));
			String line = null;
			int j = 0;
			int i = 0;

			int datanum = Integer.parseInt(in.readLine());

			tbdata.data = new int[datanum][datanum];
			tbdata.title = new String[datanum];

			for (int k = 0; k < datanum; k++) {
				line = in.readLine();
				String[] ex = null;
				ex = line.split(" ");

				for (j = 0; j < tbdata.data.length; j++) {
					tbdata.data[i][j] = Integer.parseInt(ex[j]);
				}
				i++;
			}

			for (i = 0; i < datanum; i++) {
				tbdata.title[i] = in.readLine();
			}

			fis.close();
			bis.close();
			in.close();
			
			
			JTreeController jc = new JTreeController(tbdata.title, tbdata.tree);

		} catch (FileNotFoundException fe) {
			JOptionPane.showMessageDialog(null,
					(new StringBuilder()).append("Unable to load DSM file "),
					"Error", 0);
		} catch (IOException ie) {
		}
	}

	public void keyTyped(KeyEvent e) {
		KeyStroke ks = KeyStroke.getKeyStroke(e.getKeyChar(), e.getModifiers());
	}
}