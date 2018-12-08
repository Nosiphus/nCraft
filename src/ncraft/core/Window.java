package ncraft.core;

import java.awt.*;
import javax.swing.*;
import ncraft.core.buttons.*;

public class Window {
	
	public class OSDetection {   
	    public void windows(String[] args) {          
	        String os = System.getProperty("os.name");        
	        if(os.contains("Windows")) {  
	            System.out.println("nCraft is running on Windows.");  
	        }else  
	            System.out.println("nCraft requires Windows.");
	        	System.exit(0);
	    }  
	}  
	
	JFrame launcher;
	
	Window() {
		launcher = new JFrame("nCraft");
		ImageIcon jack = new ImageIcon("/ncraft/images/jack.png");
		JLabel label = new JLabel(jack);
		
		//Buttons
			
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
			
			//Options
			JButton options = new JButton("Options");
			options.setBounds(660, 460, 90, 30);
			options.addActionListener(new OptionsListener());
			options.setToolTipText("Opens Options Menu.");
		
		//End Buttons
		
		//Window Contents
		launcher.add(label);
		launcher.add(download);
		launcher.add(login);
		launcher.add(options);
		
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