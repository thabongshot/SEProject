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
		
		if (re == JFileChooser.APPROVE_OPTION) // �������� ���̾�α׸� ����
		{
			File file_open = openfile.getSelectedFile(); // ������ ���ϸ��� �����´�

			try {
				PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file_open))); // PrintWriter��ü�� �����ؼ�
				source.getChars(0, source.length(),input,0); //(�� ��ġ, �ҽ� ũ��, �ҽ� ���� char�迭, 0)
				pw.write(input); // ȭ���� ������ ���Ͽ� ����
				pw.close();
			}

			catch (FileNotFoundException ie2) {
			} catch (IOException ie) {
			}

		}
	}
}