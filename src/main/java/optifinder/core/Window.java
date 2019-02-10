package optifinder.core;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import net.minecraftforge.fml.common.FMLCommonHandler;

public class Window extends JDialog {

	public Window(JFrame parent, String title, String message, String version) {
		
		super(parent, title, true);
		
		JPanel messagePane = new JPanel();
		messagePane.add(new JLabel(message));
		getContentPane().add(messagePane);
		
		JPanel buttonPane = new JPanel();
		
		JButton openDirectory = new JButton("Open Directory");
		openDirectory.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String location = (new File("mods")).getAbsolutePath();	
				
				File file = new File(location);
				Desktop desktop = Desktop.getDesktop();
				
				try {
					desktop.open(file);
					FMLCommonHandler.instance().exitJava(0, false);
				} catch (IOException f) {
					f.printStackTrace();
				}
			}
		});
		
		buttonPane.add(openDirectory);
		
		JButton close = new JButton("Close");
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent g) {
				FMLCommonHandler.instance().exitJava(0, false);
			}
		});
		
		buttonPane.add(close);
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		pack();
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width)/2 - getWidth()/2, (Toolkit.getDefaultToolkit().getScreenSize().height)/2 - getHeight()/2);
		setVisible(true);
	}
	
	public static void main(String version) {
		Window window = new Window(new JFrame(), "Install OptiFine", "Your browser has been opened to download OptiFine_" + version + ".jar. Run the installer and extract the OptiFine_" + version + "_MOD.jar to this pack's mods directory and delete any previous versions. Set the mods folder file to be read-only.", version);
	}
	
}