package ncraft.core;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
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
		System.out.println("nCraft is running on " + System.getProperty("os.name") + ".");
		System.out.println("OS version number is " + System.getProperty("os.version") + ".");
		
			//Create Folders
			new File(cache).mkdirs();
			new File(settings).mkdirs();
			System.out.println("Directory structure created.");
			
			//Create Property Files
			new File(settings + "installed.txt").createNewFile();
			new File(settings + "login.txt").createNewFile();
			new File(settings + "ram.txt").createNewFile();
			System.out.println("Property files created.");
			
				//Preference Loader
			
					//Installed
					Properties installed = new Properties();
					FileInputStream installedLoad = new FileInputStream(settings + "installed.txt");
					installed.load(installedLoad);
					installedLoad.close();
					FileOutputStream installedStore = new FileOutputStream(settings + "installed.txt");
					installed.store(installedStore, "");
					installedStore.close();
					System.out.println("Installed packs loaded.");
			
					//Login
					Properties login = new Properties();
					FileInputStream loginLoad = new FileInputStream(settings + "login.txt");
					login.load(loginLoad);
					loginLoad.close();
					FileOutputStream loginStore = new FileOutputStream(settings + "login.txt");
					login.store(loginStore, "");
					loginStore.close();
					System.out.println("Login settings loaded.");
				
					//RAM
					Properties ram = new Properties();
					FileInputStream ramLoad = new FileInputStream(settings + "ram.txt");
					ram.load(ramLoad);
					ramLoad.close();
					FileOutputStream ramStore = new FileOutputStream(settings + "ram.txt");
					ram.store(ramStore, "");
					ramStore.close();
					System.out.println("Memory settings loaded.");
				
				//End Preference Loader
				
		//End Base Operations
		
		//Buttons
			
			//Download
			JButton download = new JButton("Download");
			download.addActionListener(new DownloadListener());
			download.setBounds(760, 460, 100, 30);
			download.setToolTipText("Download updates.");
			
			//Open Directory
			JButton openDirectory = new JButton("Open Directory");
			openDirectory.addActionListener(new OpenDirectoryListener());
			openDirectory.setBounds(520, 460, 130, 30);
			openDirectory.setToolTipText("Opens nCraft installation directory.");
			
			//Options
			JButton options = new JButton("Options");
			options.addActionListener(new OptionsListener());
			options.setBounds(660, 460, 90, 30);
			options.setToolTipText("Opens the Options Pane.");
			
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
			
		//Scroll Contents
			
			//We will add this once we have constructed the installed packs list.
			
		//End Scroll Contents
			
		//Scroll Panes
			
			JScrollPane packLister = new JScrollPane();
			packLister.setBounds(20, 20, 200, 100);
			packLister.setToolTipText("Displays all installed modpacks.");
			
		//End Scroll Panes
		
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
		launcher.add(download);
		launcher.add(logo);
		launcher.add(openDirectory);
		launcher.add(options);
		launcher.add(packLister);
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