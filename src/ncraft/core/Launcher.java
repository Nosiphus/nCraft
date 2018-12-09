package ncraft.core;

import java.awt.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
	
	public static String user = System.getProperty("user.home");
	public static String directory = user + File.separator + "nCraft" + File.separator;
	public static String cache = directory + "cache" + File.separator;
	
	public Launcher() {
		launcher = new JFrame("nCraft");
		
		//Base Operations
			
			new File(cache).mkdirs();
		
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
			JPasswordField password = new JPasswordField();
			password.setBounds(660, 425, 280, 25);
			password.setToolTipText("Password");
			
			//Username
			JTextField username = new JTextField();
			username.setBounds(660, 390, 280, 25);
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
	
	public static void main(String[] args)
	{
		new Launcher();
	}
}