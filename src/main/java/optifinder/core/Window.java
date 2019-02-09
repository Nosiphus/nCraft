package optifinder.core;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import net.minecraftforge.fml.common.FMLCommonHandler;

public class Window {

	public Window(String version) {
		
		JFrame frame = null;
		
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
		
		JButton close = new JButton("Close");
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent g) {
				FMLCommonHandler.instance().exitJava(0, false);
			}
		});
		
		Object[] options = {openDirectory, close};
		
		int n = JOptionPane.showOptionDialog(frame, "Your browser has been opened to download OptiFine_" + version + ".jar. Run the installer and extract the OptiFine_" + version + "_MOD.jar to this pack's mods directory and delete any previous versions. Set the mods folder file to be read-only.", "Install OptiFine", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
		

		
	}
	
	public static void main(String version) {
		new Window(version);
	}
	
}