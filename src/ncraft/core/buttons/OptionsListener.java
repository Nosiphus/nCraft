package ncraft.core.buttons;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.*;

public class OptionsListener implements ActionListener {
	public void actionPerformed(ActionEvent e)
	{
		JFrame options;
		
		options = new JFrame("Options");
		
		//Buttons
		
			//Login Information
			JRadioButton logininformation = new JRadioButton("Remember login information");
			logininformation.addActionListener(new LoginInformationListener());
			logininformation.setBounds(50, 100, 200, 30);
		
			//Save
			JButton save = new JButton("Save");
			save.setBounds(210, 320, 70, 30);
			
		//End Buttons
			
		//Window Contents
		options.add(logininformation);
		options.add(save);
			
		//Window Layout
		options.setLayout(null);
		options.setResizable(false);
		options.setSize(300, 400);
		options.setVisible(true);
		
		//Window Location
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - options.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - options.getHeight()) / 2);
		options.setLocation(x, y);
	}
}
