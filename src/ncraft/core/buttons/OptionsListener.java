package ncraft.core.buttons;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;

import ncraft.core.Launcher;

public class OptionsListener implements ActionListener {
	
	File file = new File(Launcher.cache + "application.txt");
	
	public void actionPerformed(ActionEvent e)
	{
		JFrame options;
		
		options = new JFrame("Options");
		
		//Buttons
		
			//Login Information
			JRadioButton logininformation = new JRadioButton("Remember login information");
			logininformation.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent m) {
					if(logininformation.isSelected()) {
						save();
					}
					else {
						delete();
					}
				}
			});
			logininformation.setBounds(50, 100, 200, 30);
			
		//End Buttons
			
		//Window Contents
		options.add(logininformation);
			
		//Window Layout
		options.setLayout(null);
		options.setResizable(false);
		options.setSize(300, 400);
		options.setVisible(true);
		
		//Window Location
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - options.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - options.getHeight()) / 2);
		options.setLocation(x, y);
	}
	
	//Save Data
	public void save() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file.getAbsolutePath()));
			writer.write("user=" + Launcher.username.getText() + "\npass=" + Launcher.password.getPassword());
			writer.newLine();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Delete Data
	public void delete() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			
			while (line != null)
			{
				line = reader.readLine();
				if (line.startsWith("user=")) {
					line = "";
					
					FileWriter writer = new FileWriter(file);
					writer.write(line);
					writer.close();
				}
				if (line.startsWith("pass=")) {
					line = "";
					
					FileWriter writer = new FileWriter(file);
					writer.write(line);
					writer.close();
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}