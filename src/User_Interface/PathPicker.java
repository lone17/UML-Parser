package User_Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import JTree.TreePanel;

public class PathPicker implements ActionListener {

	private JMenuItem target;
	private String selectedPath;

	public PathPicker(JMenuItem target) {
		this.target = target;
		this.selectedPath = "";
	}

	@Override
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == target) {
			JFileChooser chooser = new JFileChooser(new java.io.File("."));

			chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

			int i = chooser.showOpenDialog(App.mainWindow);
			if (i == JFileChooser.APPROVE_OPTION) {
				File f = chooser.getSelectedFile();
				selectedPath = f.getAbsolutePath();
				App.mainWindow.remove(App.treePanel.getScrollPane());
				App.treePanel = new TreePanel(selectedPath);
				App.mainWindow.add(App.treePanel.getScrollPane(), BorderLayout.WEST);
				App.text.append("Loaded " + App.treePanel.getLoadedFilesCount()
						                + " file(s) from " + f.getAbsolutePath() + "\n");
				App.mainWindow.revalidate();
				App.mainWindow.repaint();
			}
		}
	}
}
