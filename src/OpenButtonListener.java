import java.awt.event.*;
import java.io.*;

import javax.swing.*;

public class OpenButtonListener extends JFrame  implements ActionListener {

	JFileChooser openfile = new JFileChooser();
	int[][] data;
	String[] title;


	public OpenButtonListener(int[][] data, String[] title) {
		this.data = data;
		this.title = title;
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

		try {

			fis = new FileInputStream(file_open); // FileInputStream��ü�� �����ϰ�
			bis = new BufferedInputStream(fis);
			in = new BufferedReader(new InputStreamReader(bis));
			String line = null;
			int j = 0;
			int i = 0;

			int datanum = Integer.parseInt(in.readLine());

			data = new int[datanum][datanum];
			title = new String[datanum];

			for (int k = 0; k < datanum; k++) {
				line = in.readLine();
				String[] ex = null;
				ex = line.split(" ");

				for (j = 0; j < data.length; j++) {
					data[i][j] = Integer.parseInt(ex[j]);
				}
				i++;
			}

			for (i = 0; i < datanum; i++) {
				title[i] = in.readLine();
			}

			fis.close();
			bis.close();
			in.close();

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