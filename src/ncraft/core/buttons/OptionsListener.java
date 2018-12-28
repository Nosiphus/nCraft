package ncraft.core.buttons;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import javax.swing.*;

import ncraft.core.Launcher;

public class OptionsListener implements ActionListener {
	
	File login = new File(Launcher.settings + "login.txt");
	File ram = new File(Launcher.settings + "ram.txt");
	
	public static JTextField maximum = new JTextField();
	public static JTextField minimum = new JTextField();
	
	public void actionPerformed(ActionEvent e)
	{
		JFrame options;
		
		options = new JFrame("Options");
		
		//Preference Loader
		
			//RAM
			Properties ram = new Properties();
			try {
				FileInputStream ramLoad = new FileInputStream(Launcher.settings + "ram.txt");
				ram.load(ramLoad);
				ramLoad.close();
				FileOutputStream ramStore = new FileOutputStream(Launcher.settings + "ram.txt");
				ram.store(ramStore, "");
				ramStore.close();
				} catch (IOException e1) {
				e1.printStackTrace();
			}
		
		//Buttons
		
			//Login Information
			JRadioButton logininformation = new JRadioButton("Remember login information");
			logininformation.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent m) {
					if(logininformation.isSelected()) {
						loginSave();
					}
					else {
						loginDelete();
					}
				}
			});
			logininformation.setBounds(50, 100, 200, 30);
			
			//Save and Exit
			JButton saveandexit = new JButton("Save and Exit");
			saveandexit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ramSave();
				}
			});
			saveandexit.setBounds(80, 325, 150, 25);
			
		//End Buttons
			
		//Labels
			
			//Maximum RAM
			JLabel maxRAM = new JLabel("Maximum RAM");
			maxRAM.setBounds(50, 150, 200, 25);
			
			//Minimum RAM
			JLabel minRAM = new JLabel("Minimum RAM");
			minRAM.setBounds(50, 180, 200, 25);
			
		//End Labels
			
		//Text Boxes
			
			//Maximum RAM
			maximum.setBounds(150, 150, 100, 25);
			maximum.setText(ram.getProperty("max"));
			
			//Minimum RAM
			minimum.setBounds(150, 180, 100, 25);
			minimum.setText(ram.getProperty("min"));
			
		//End Text Boxes
			
		//Window Contents
		options.add(logininformation);
		options.add(maximum);
		options.add(maxRAM);
		options.add(minimum);
		options.add(minRAM);
		options.add(saveandexit);
			
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
	
	//Save
	
		//Login
		public void loginSave() {
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(login.getAbsolutePath()));
				writer.write("user=" + Launcher.username.getText() + "\npass=" + Launcher.password.getPassword());
				writer.newLine();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//RAM
		public void ramSave() {
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(ram.getAbsolutePath()));
				writer.write("max=" + maximum.getText() + "\nmin=" + minimum.getText());
				writer.newLine();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	//End Save	
		
	//Delete
		
		//Login
		public void loginDelete() {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(login));
				String line = reader.readLine();
			
				while (line != null)
				{
					line = reader.readLine();
					if (line.startsWith("user=")) {
						line = "";
						
						FileWriter writer = new FileWriter(login);
						writer.write(line);
						writer.close();
					}
					if (line.startsWith("pass=")) {
						line = "";
					
						FileWriter writer = new FileWriter(login);
						writer.write(line);
						writer.close();
					}
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//End Login
		
		//RAM
		public void ramDelete() {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(ram));
				String line = reader.readLine();
			
				while (line != null)
				{
					line = reader.readLine();
					if (line.startsWith("max=")) {
						line = "";
						
						FileWriter writer = new FileWriter(ram);
						writer.write(line);
						writer.close();
					}
					if (line.startsWith("min=")) {
						line = "";
					
						FileWriter writer = new FileWriter(ram);
						writer.write(line);
						writer.close();
					}
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	//End Delete
}