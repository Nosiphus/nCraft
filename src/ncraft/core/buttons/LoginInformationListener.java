package ncraft.core.buttons;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import ncraft.core.Launcher;

public class LoginInformationListener implements ItemListener {

	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			String usr = Launcher.username.getText();
			
			List<String> lines = Arrays.asList(usr);
			Path file = Paths.get(Launcher.cache + File.separator + "login-info.txt");
			try {
				Files.write(file, lines, Charset.forName("UTF-8"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} else if (e.getStateChange() == ItemEvent.DESELECTED) {
	        File file = new File(Launcher.cache + File.separator + "login-info.txt");
			if(file.delete()){
	            System.out.println("Login information has been deleted.");
	        }else System.out.println("Login information doesn't exist.");
		}
	}

}
