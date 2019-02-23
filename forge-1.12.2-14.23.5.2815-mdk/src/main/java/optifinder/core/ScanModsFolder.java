package optifinder.core;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import net.minecraftforge.fml.common.FMLCommonHandler;

public class ScanModsFolder {

	String location = (new File("mods")).getAbsolutePath();	
	
	String[] mods;
	
	boolean isPresent;
	
	public ScanModsFolder(String version) {

		File folder = new File(location);
		
		FilenameFilter optifineFilter = new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				if(name.contentEquals("OptiFine_" + version + "_MOD.jar")) {
					isPresent = true;
					return true;
				} else {
					return false;
				}
			}
		};
		
		File[] files = folder.listFiles(optifineFilter);
		
		for (File file : files) {
			System.out.println(file.getName());
		}
		
		if (isPresent) {
			System.out.println("OptiFine is installed, proceeding.");
			return;
		} else {
			System.out.println("OptiFine is not installed, exiting.");
			downloader(version);
			Window.main(version);
		}
		
	}
	
	public static void downloader(String version) {
		try {
			String page = "https://www.nosiphus.com/minecraft/optifinder/1.12.2.html";
			
			if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
				Desktop.getDesktop().browse(new URI(page));
			}
		} catch (IOException | URISyntaxException e) {
				e.printStackTrace();
		}
	}
	
	public static void main(String version) {
		
		new ScanModsFolder(version);
		
	}
	
}