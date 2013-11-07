package com.mycompany.listBoxer;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import com.mycompany.listBoxer.panel.ListBoxerPanel;

public class MainApplication {

	public static void main(String[] args) {
		JFrame f = new JFrame("List Boxer");

		f.getContentPane().add(new ListBoxerPanel());

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		f.setSize(400, 400);
		f.setVisible(true);
	}

}
