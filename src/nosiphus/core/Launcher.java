package nosiphus.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Launcher {
	
	JFrame frame;
	
	Launcher() {
		frame = new JFrame("nCraft");
		
		//Buttons
		
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
		download.setToolTipText("Download updates.");
		exit.setToolTipText("Exits nCraft.");
		
		//Icons
		ImageIcon jack = new ImageIcon("nosiphus/gui/jack.png");
		
		//Window Operations
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Window Contents
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
	
		//Download Button
		class downloadListener implements ActionListener {
			public void actionPerformed(ActionEvent e)
			{	
				String username = System.getProperty("user.name");
				String directory = "C:\\Users\\" + username + "\\Desktop\\";
				
		        String fromFile = "https://www.nosiphus.com/minecraft/modpacks/telkit/6.6.0.txt";
		        String toFile = directory + "6.6.0.txt";
				
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