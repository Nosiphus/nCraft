package ncraft.core;

import java.awt.*;
import javax.swing.*;
import ncraft.core.buttons.*;

public class Window {
	
	JFrame launcher;
	
	Window() {
		launcher = new JFrame("nCraft");
		ImageIcon jack = new ImageIcon("/ncraft/images/jack.png");
		JLabel label = new JLabel(jack);
		
		//Buttons
		
			//Check for Updates
			JButton checkUpdates = new JButton("Check for Updates");
			checkUpdates.setBounds(610, 460, 140, 30);
			checkUpdates.addActionListener(new UpdateListener());
			checkUpdates.setToolTipText("Checks for updates.");
			
			//Download
			JButton download = new JButton("Download");
			download.setBounds(760, 460, 100, 30);
			download.addActionListener(new DownloadListener());
			download.setToolTipText("Download updates.");
			
			//Login
			JButton login = new JButton("Login");
			login.setBounds(870, 460, 70, 30);
			login.addActionListener(new LoginListener());
			login.setToolTipText("Will eventually log player into Minecraft.");
		
		//End Buttons
		
		//Window Contents
		launcher.add(label);
		launcher.add(checkUpdates);
		launcher.add(download);
		launcher.add(login);
		
		//Window Operations
		launcher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Window Layout
		launcher.setSize(960,540);
		launcher.setResizable(false);
		launcher.setLayout(null);
		launcher.setVisible(true);
		launcher.setIconImage(jack.getImage());
	}
	
	public static void main(String[] args)
	{
		new Window();
	}
}