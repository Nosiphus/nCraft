package ncraft.operations;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import javax.swing.JOptionPane;

import ncraft.Launcher;

public class DownloadListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		
		String modpack;
		modpack = JOptionPane.showInputDialog("What modpack will you be installing?");
		
		System.out.println("Modpack ID is " + modpack + ".");
	
		String packfolder = Launcher.directory + "environments" + File.separator + modpack + File.separator;
		String cache = Launcher.cache;
		
		//Directory Creation
		new File(packfolder + "bin").mkdirs();
		new File(packfolder + "cache").mkdirs();
		new File(packfolder + "coremods").mkdirs();
		new File(packfolder + "flan").mkdirs();
		new File(packfolder + "mods").mkdirs();
		new File(packfolder + "resourcepacks").mkdirs();
		new File(packfolder + "texturepacks").mkdirs();
		new File(packfolder + "usermods").mkdirs();
		
		String version;
		version = JOptionPane.showInputDialog("Enter version number:");
		
		System.out.println("Version number is " + version + ".");
		
		String fromFile = "https://ncraft.nosiphus.com/modpacks/" + modpack + "/updates/" + version + ".txt";
		new File(Launcher.cache + File.separator + modpack + File.separator).mkdirs();
		String toFile = packfolder + "cache" + File.separator + version + ".txt";
		
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
		
		downloader(cache, packfolder, toFile);
	}

	public void downloader(String cache, String packfolder, String toFile) {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(toFile));
			String line = reader.readLine();
			
			while ((line = reader.readLine()) != null) {
				if (line.contains("minecraft=")) {
					String minecraft = line.substring(line.indexOf("=") + 1);
					new File(packfolder + "mods" + File.separator + minecraft + File.separator).mkdirs();
					
					String fromClient = "https://www.nosiphus.com/minecraft/clients.txt";
					String toClient = cache + "clients.txt";
					
					try {
						URL website = new URL(fromClient);
						ReadableByteChannel rbc = Channels.newChannel(website.openStream());
						FileOutputStream fos = new FileOutputStream(toClient);
						fos.getChannel().transferFrom(rbc, 0 , Long.MAX_VALUE);
						fos.close();
						rbc.close();
						
						installMinecraft(cache, minecraft, toClient, packfolder);
						
					} catch (IOException g) {
						g.printStackTrace();
					}
				}
				
				if (line.contains("n:http")) {
					String location = packfolder + (line.substring(0, line.indexOf("=")));
					String mod = line.substring(line.indexOf("=n:") + 3);
					
					try {
						URL website = new URL(mod);
						HttpURLConnection con = (HttpURLConnection) (website.openConnection());
						System.setProperty("http.agent", "");
						con.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");
						ReadableByteChannel rbc = Channels.newChannel(con.getInputStream());
						FileOutputStream fos = new FileOutputStream(location);
						fos.getChannel().transferFrom(rbc, 0 , Long.MAX_VALUE);
						rbc.close();
						fos.close();
					} catch (IOException f) {
						f.printStackTrace();
					}
				}
				
				if (line.contains("w:http")) {
					String page = line.substring(line.indexOf("=w:") + 3);
					
					if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
						Desktop.getDesktop().browse(new URI(page));
					}
				}
			}
		reader.close();
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}

	public void installMinecraft(String cache, String minecraft, String toClient, String packfolder) {
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(toClient));
			String line = reader.readLine();
			
			while ((line = reader.readLine()) != null) {
				if (line.contains(minecraft + "=")) {
					String mcVersion = line.substring(line.indexOf("=") + 1);
					String mcLocale = packfolder + "bin" + File.separator + "minecraft.jar";
					
					try {
						URL website = new URL(mcVersion);
						HttpURLConnection con = (HttpURLConnection) (website.openConnection());
						System.setProperty("http.agent", "");
						con.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");
						ReadableByteChannel rbc = Channels.newChannel(con.getInputStream());
						FileOutputStream fos = new FileOutputStream(mcLocale);
						fos.getChannel().transferFrom(rbc, 0 , Long.MAX_VALUE);
						rbc.close();
						fos.close();
					} catch (IOException i) {
						i.printStackTrace();
					}
				}
			}	
		reader.close();	
		} catch (IOException h) {
			h.printStackTrace();
		}	
	}
}