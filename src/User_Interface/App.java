package User_Interface;

import JTree.JTreeExample;
import JTree.TreePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;

public class App {
	static MainWindow mainWindow;
	static TreePanel treePanel;
	static JTextArea text;

	public static MainWindow getMainWindow() {
		return mainWindow;
	}

	public static void run() {
		mainWindow = MainWindow.getMainWindowInstance();
		treePanel = new TreePanel();
		text = new JTextArea();


		mainWindow.add(treePanel.getScrollPane(), BorderLayout.WEST);
		mainWindow.add(text, BorderLayout.CENTER);
//		JPanel drawPanel = new JPanel();
//		drawPanel.setSize(new Dimension(300, 400));
//		mainWindow.add(drawPanel, BorderLayout.SOUTH);
//		mainWindow.pack();
	}

	public static void main(String[] args){
//		run();
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				App.run();
			}
		});

	}

}
