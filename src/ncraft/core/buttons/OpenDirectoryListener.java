package ncraft.core.buttons;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import ncraft.core.Launcher;

public class OpenDirectoryListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String directory = Launcher.directory;
		
		File file = new File (directory);
		Desktop desktop = Desktop.getDesktop();
		
		try {
			desktop.open(file);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}

}