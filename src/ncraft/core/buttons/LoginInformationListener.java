package ncraft.core.buttons;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import ncraft.core.Launcher;

public class LoginInformationListener implements ItemListener {
	
	File file = new File(Launcher.cache + "application.txt");

	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {	
			try {
	             BufferedReader reader = new BufferedReader(new FileReader(file));
	             String line = "", oldtext = "";
	             
	             while((line = reader.readLine()) != null) {
	            	 oldtext += line + "\r\n";
	             }
	             reader.close();
	             
	             String usertext = oldtext.replaceAll("user=", "user=" + Launcher.username.getText());
	             
	             FileWriter writer = new FileWriter (Launcher.cache + "application.txt");
	             writer.write(usertext);
	             writer.close();
			}
			catch (IOException ioe) {
				ioe.printStackTrace();
			}
		} else {
			try {
	             BufferedReader reader = new BufferedReader(new FileReader(file));
	             String line = "", oldtext = "";
	             
	             while((line = reader.readLine()) != null) {
	            	 oldtext += line + "\r\n";
	             }
	             reader.close();
	             
	             String usertext = oldtext.replaceAll("user=" + Launcher.username.getText(), "user=");
	             
	             FileWriter writer = new FileWriter (Launcher.cache + "application.txt");
	             writer.write(usertext);
	             writer.close();
			}
			catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}

}
