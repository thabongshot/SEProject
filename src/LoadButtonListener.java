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
		int re = openfile.showOpenDialog(this); // 파일열기 다이얼로그 창을 띄운다
		if (re == JFileChooser.APPROVE_OPTION) {

			File file_open = openfile.getSelectedFile(); // 선택한 파일명을 가져온다

			
			
			byte[] buffer = new byte [512];	
			
			try {
				fis = new FileInputStream(file_open); // FileInputStream객체를 생성하고
				output = new ByteArrayOutputStream();
				int data = 0;
				while ((data = fis.read()) != -1) // 파일이 끝날때까지 읽어서
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
