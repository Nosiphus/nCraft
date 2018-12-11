package ncraft.core.buttons;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import ncraft.core.Launcher;

public class LoginInformationListener implements ItemListener {

	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			String usr = Launcher.username.getText();
			
			List<String> lines = Arrays.asList(usr);
			Path file = Paths.get(Launcher.cache + File.separator + "config.properties");
			try {
				Files.write(file, lines, Charset.forName("UTF-8"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} else if (e.getStateChange() == ItemEvent.DESELECTED) {
	        File file = new File(Launcher.cache + File.separator + "config.properties");
			if(file.delete()){
	            System.out.println("Login information has been deleted.");
	        }else System.out.println("Login information doesn't exist.");
		}
	}

}
