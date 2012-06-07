import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import java.awt.*;
import javax.swing.filechooser.*;
import java.awt.event.*;
import java.io.*;
import java.util.Arrays;

import javax.swing.*;

import org.w3c.dom.Document;

public class LoadButtonListener extends JFrame implements ActionListener {

	JFileChooser openfile = new JFileChooser();
	Container pane;
	JTextArea text;
	FileInputStream fis;
	ByteArrayOutputStream output;					
	ByteArrayInputStream input;
//	XMLMain xml = new XMLMain();

			
	public void actionPerformed(ActionEvent e) {
		int re = openfile.showOpenDialog(this); // ���Ͽ��� ���̾�α� â�� ����
		if (re == JFileChooser.APPROVE_OPTION) {

			File file_open = openfile.getSelectedFile(); // ������ ���ϸ��� �����´�

			
			
			byte[] buffer = new byte [512];	
			
			try {
				fis = new FileInputStream(file_open); // FileInputStream��ü�� �����ϰ�
				output = new ByteArrayOutputStream();
				int data = 0;
				while ((data = fis.read()) != -1) // ������ ���������� �о
				{
					output.write((char)data);					
				}					
				
				//JOptionPane.showMessageDialog(null, output.toString());
				
				fis.close();
				output.close();
				
			} catch (FileNotFoundException fe) {
			} catch (IOException ie) {
			}
		}
	
	}
	
	
	public void keyTyped(KeyEvent e){
		KeyStroke ks2 = KeyStroke.getKeyStroke(e.getKeyChar(),e.getModifiers());		
	}
	
}
