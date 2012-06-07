import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import java.awt.*;
import javax.swing.filechooser.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

public class SaveAsButtonListener extends JFrame implements ActionListener {

	JFileChooser openfile = new JFileChooser();

	public void actionPerformed(ActionEvent e) {
		int re = openfile.showSaveDialog(this);
		
		String source = "writing test\n";
		char input[] = new char[source.length()];
		
		if (re == JFileChooser.APPROVE_OPTION) // 파일저장 다이얼로그를 띄운다
		{
			File file_open = openfile.getSelectedFile(); // 저장할 파일명을 가져온다

			try {
				PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file_open))); // PrintWriter객체를 생성해서
				source.getChars(0, source.length(),input,0); //(쓸 위치, 소스 크기, 소스 담을 char배열, 0)
				pw.write(input); // 화면의 내용을 파일에 쓴다
				pw.close();
			}

			catch (FileNotFoundException ie2) {
			} catch (IOException ie) {
			}

		}
	}
}