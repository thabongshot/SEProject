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


	// 메뉴에서 열기 클릭했을때 이벤트 처리
	public void actionPerformed(ActionEvent e) {
		int re = openfile.showOpenDialog(this); // 파일열기 다이얼로그 창을 띄운다
		if (re == JFileChooser.APPROVE_OPTION) {

			File file_open = openfile.getSelectedFile(); // 선택한 파일명을 가져온다

			DsmData(file_open);

		}
	}

	public void DsmData(File dsm) {

		File file_open = openfile.getSelectedFile(); // 선택한 파일명을 가져온다

		FileInputStream fis;
		BufferedInputStream bis;
		BufferedReader in;

		try {

			fis = new FileInputStream(file_open); // FileInputStream객체를 생성하고
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