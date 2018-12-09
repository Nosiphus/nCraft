package ncraft.core.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import javax.swing.JOptionPane;

import ncraft.core.Launcher;

public class DownloadListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		String modpack;
		modpack = JOptionPane.showInputDialog("What modpack will you be installing?");
		
		String version;
		version = JOptionPane.showInputDialog("Enter version number:");
		
		String fromFile = "https://www.nosiphus.com/minecraft/modpacks/" + modpack + "/updates/" + version + ".txt";
		new File(Launcher.cache + File.separator + modpack + File.separator).mkdirs();
		String toFile = Launcher.cache + modpack + File.separator + version + ".txt";
		
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
