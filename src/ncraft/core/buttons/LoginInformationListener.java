package ncraft.core.buttons;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import ncraft.core.Launcher;

public class LoginInformationListener implements ItemListener {

	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			
		} else if (e.getStateChange() == ItemEvent.DESELECTED) {
			
		}
	}

}
