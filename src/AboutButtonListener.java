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
		// ������ �����ִ� ���̾�α׸� ����
		JOptionPane.showMessageDialog(null," 20101490?? ������\n 201014??? �����\n 20101551 ������\n 20101570 ������\n 20101576 ������\n");
	}
}
