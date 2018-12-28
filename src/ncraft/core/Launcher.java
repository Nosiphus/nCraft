package ncraft.core;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
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
	public static String settings = directory + "settings" + File.separator;
	
	public static JPasswordField password = new JPasswordField();
	public static JTextField username = new JTextField();
	
	public Launcher() throws IOException {
		launcher = new JFrame("nCraft");
		
		//Base Operations
		
			//Create Folders
			new File(cache).mkdirs();
			new File(settings).mkdirs();
			
			//Create Property Files
			new File(settings + "login.txt").createNewFile();
			new File(settings + "ram.txt").createNewFile();
			
			//Preference Loader
			
				//Login
				Properties login = new Properties();
				FileInputStream loginLoad = new FileInputStream(settings + "login.txt");
				login.load(loginLoad);
				loginLoad.close();
				FileOutputStream loginStore = new FileOutputStream(settings + "login.txt");
				login.store(loginStore, "");
				loginStore.close();
				
				//RAM
				Properties ram = new Properties();
				FileInputStream ramLoad = new FileInputStream(settings + "ram.txt");
				ram.load(ramLoad);
				ramLoad.close();
				FileOutputStream ramStore = new FileOutputStream(settings + "ram.txt");
				ram.store(ramStore, "");
				ramStore.close();
				
		//End Base Operations
		
		//Buttons
			
			//Add Pack
			JButton addpack = new JButton("Add Pack");
			addpack.addActionListener(new AddPackListener());
			addpack.setBounds(560, 460, 90, 30);
			addpack.setToolTipText("Adds a new pack.");
			
			//Download
			JButton download = new JButton("Download");
			download.addActionListener(new DownloadListener());
			download.setBounds(760, 460, 100, 30);
			download.setToolTipText("Download updates.");
			
			//Options
			JButton options = new JButton("Options");
			options.addActionListener(new OptionsListener());
			options.setBounds(660, 460, 90, 30);
			options.setToolTipText("Opens Options Menu.");
			
			//Play
			JButton play = new JButton("Play");
			play.addActionListener(new PlayListener());
			play.setBounds(870, 460, 70, 30);
			play.setToolTipText("Will eventually log player into Minecraft.");
		
		//End Buttons
		
		//Images
			
			ImageIcon icon = createImageIcon("../images/logo.png", "nCraft");
			JLabel logo = new JLabel(icon);
			logo.setBounds(400, -10, 550, 250);
			
		//End Images	
			
		//End Scroll Boxes
		
		//Text Boxes
			
			//Password
			password.setBounds(660, 425, 280, 25);
			password.setText(login.getProperty("pass"));
			password.setToolTipText("Password");
			
			//Username
			username.setBounds(660, 390, 280, 25);
			username.setText(login.getProperty("user"));
			username.setToolTipText("Username");
			
		//End Text Boxes
		
		//Window Contents
		launcher.add(addpack);
		launcher.add(download);
		launcher.add(logo);
		launcher.add(options);
		launcher.add(password);
		launcher.add(play);
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