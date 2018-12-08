package ncraft.core;

import java.awt.*;
import javax.swing.*;
import ncraft.core.buttons.*;

public class Launcher {
	
	JFrame launcher;
	
	Launcher() {
		launcher = new JFrame("nCraft");
		ImageIcon jack = new ImageIcon("/ncraft/images/jack.png");
		JLabel label = new JLabel(jack);
		
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
		launcher.add(label);
		launcher.add(download);
		launcher.add(login);
		launcher.add(password);
		launcher.add(options);
		launcher.add(username);
		
		//Window Operations
		launcher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Window Layout
		launcher.setIconImage(jack.getImage());
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