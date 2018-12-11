package ncraft.core;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.*;
import ncraft.core.buttons.*;

public class Launcher {
	
	JFrame launcher;
	
	/** Returns an ImageIcon, or null if the path was invalid. */
	protected ImageIcon createImageIcon(String path,
	                                           String description) {
	    java.net.URL imgURL = getClass().getResource(path);
	    if (imgURL != null) {
	        return new ImageIcon(imgURL, description);
	    } else {
	        System.err.println("Couldn't find file: " + path);
	        return null;
	    }
	}
	
	public static String directory = System.getProperty("user.home") + File.separator + "nCraft" + File.separator;
	public static String cache = directory + "cache" + File.separator;
	
	public static JPasswordField password = new JPasswordField();
	public static JTextField username = new JTextField();
	
	public Launcher() throws IOException {
		launcher = new JFrame("nCraft");
		
		//Base Operations
		
			//Create Cache Folder
			new File(cache).mkdirs();
			
			//Create Property Files
			new File(cache + "defaultProperties.txt").createNewFile();
			new File(cache + "appProperties.txt").createNewFile();
			
			//Create Default Properties
			Properties defaultProps = new Properties();
			FileInputStream in = new FileInputStream(cache + "defaultProperties.txt");
			defaultProps.load(in);
			in.close();
			
				//Default Properties
				defaultProps.setProperty("user", "");
				defaultProps.setProperty("pass", "");
			
			//Create Application Properties
			Properties applicationProps = new Properties(defaultProps);
			
			//Load Properties
			in = new FileInputStream(cache + "appProperties.txt");
			applicationProps.load(in);
			in.close();
			
			//Save Properties
			FileOutputStream out = new FileOutputStream(cache + "appProperties.txt");
			applicationProps.store(out, null);
			out.close();
		
		//End Base Operations
		
		//Buttons
			
			//Download
			JButton download = new JButton("Download");
			download.addActionListener(new DownloadListener());
			download.setBounds(760, 460, 100, 30);
			download.setToolTipText("Download updates.");
			
			//Login
			JButton login = new JButton("Login");
			login.addActionListener(new LoginListener());
			login.setBounds(870, 460, 70, 30);
			login.setToolTipText("Will eventually log player into Minecraft.");
			
			//Options
			JButton options = new JButton("Options");
			options.addActionListener(new OptionsListener());
			options.setBounds(660, 460, 90, 30);
			options.setToolTipText("Opens Options Menu.");
		
		//End Buttons
		
		//Images
			
			ImageIcon icon = createImageIcon("../images/logo.png", "nCraft");
			JLabel logo = new JLabel(icon);
			logo.setBounds(400, -10, 550, 250);
			
		//End Images
		
		//Text Boxes
			
			//Password
			password.setBounds(660, 425, 280, 25);
			password.setText(applicationProps.getProperty("pass"));
			password.setToolTipText("Password");
			
			//Username
			username.setBounds(660, 390, 280, 25);
			username.setText(applicationProps.getProperty("user"));
			username.setToolTipText("Username");
			
		//End Text Boxes
		
		//Window Contents
		launcher.add(download);
		launcher.add(login);
		launcher.add(logo);
		launcher.add(password);
		launcher.add(options);
		launcher.add(username);
		
		//Window Operations
		launcher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Window Layout
		launcher.setLayout(null);
		launcher.setResizable(false);
		launcher.setSize(960,540);
		launcher.setVisible(true);
		
		//Window Location
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - launcher.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - launcher.getHeight()) / 2);
		launcher.setLocation(x, y);
	}
	
	public static void main(String[] args) throws IOException
	{
		new Launcher();
	}
}