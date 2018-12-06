package nosiphus.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Launcher {
	
	JFrame frame;
	
	Launcher() {
		frame = new JFrame("nCraft");
		ImageIcon jack = new ImageIcon("jack.png");
		JLabel label = new JLabel(jack);
		
		//Buttons
		
			//Check for Updates Button
			JButton checkUpdates = new JButton("Check for Updates");
			checkUpdates.setBounds(600, 460, 140, 30);
			checkUpdates.addActionListener(new updateListener());
			
			//Download Button
			JButton download = new JButton("Download");
			download.setBounds(760, 460, 100, 30);
			download.addActionListener(new downloadListener());
		
			//Exit Button
			JButton exit = new JButton("Exit");
			exit.setBounds(880, 460, 60, 30); 
			exit.addActionListener(new exitListener());
			
		//End Buttons
		
		//Button Tooltips
		checkUpdates.setToolTipText("Checks for updates.");
		download.setToolTipText("Download updates.");
		exit.setToolTipText("Exits nCraft.");
		
		//Dropdown Lists
		String[] modpackList = {"telkit", "telkit-classic", "nosiphus-required-mods" };
		
		//Window Operations
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Window Contents
		frame.add(label);
		frame.add(checkUpdates);
		frame.add(download);
		frame.add(exit);
		
		//Window Layout
		frame.setSize(960, 540);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setIconImage(jack.getImage());
	}
	
	//Button Operations
	
		//Check for Updates Button
		class updateListener implements ActionListener {
			public void actionPerformed(ActionEvent e)
			{
				
			}
		}
	
		//Download Button
		class downloadListener implements ActionListener {
			public void actionPerformed(ActionEvent e)
			{	
				String username = System.getProperty("user.name");
				String directory = "C:\\Users\\" + username + "\\Desktop\\";
				
				String modpack;
				modpack = JOptionPane.showInputDialog(frame,"What modpack will you be installing?");
				
				String versionNumber;
				versionNumber = JOptionPane.showInputDialog(frame, "Enter version number:");
				
		        String fromFile = "https://www.nosiphus.com/minecraft/modpacks/" + modpack + "/" + versionNumber + ".txt";
		        String toFile = directory + versionNumber + ".txt";
				
		        try {

		            URL website = new URL(fromFile);
		            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
		            FileOutputStream fos = new FileOutputStream(toFile);
		            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		            fos.close();
		            rbc.close();

		        } catch (IOException f) {
		            f.printStackTrace();
		        }

			}
		}
	
		//Exit Button
		class exitListener implements ActionListener {
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		}
		
	//End Button Operations
		
	public static void main(String[] args)
	{
		new Launcher();
	}
}