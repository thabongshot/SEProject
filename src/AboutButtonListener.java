import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import java.awt.*;
import javax.swing.filechooser.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

public class AboutButtonListener extends JFrame implements ActionListener {

	JFileChooser openfile = new JFileChooser();
	
	public void actionPerformed(ActionEvent e) {
		// 정보를 보여주는 다이얼로그를 띄운다
		JOptionPane.showMessageDialog(null," 20101490?? 권현수\n 201014??? 김다정\n 20101551 유지원\n 20101570 이지문\n 20101576 임지원\n");
	}
}
