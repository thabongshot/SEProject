import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import java.awt.*;
import javax.swing.filechooser.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;


public class ExitButtonListener extends JFrame implements ActionListener {
	
	JFileChooser openfile = new JFileChooser();

    public void actionPerformed(ActionEvent e)
	   {
	    dispose(); // â�� �ݰ� 
	    System.exit(0); // �����Ѵ�
	   }
	
}
